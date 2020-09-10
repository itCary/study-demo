package online.goudan;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

/**
 * @author 刘成龙
 * @description
 * @date 2020/7/23 20:47
 */
public class CreateLucene {
    /**
     * 使用步骤:
     * 第一步：创建一个java工程，并导入jar包。
     * 第二步：创建一个indexwriter对象。
     * 1）指定索引库的存放位置Directory对象
     * 2）指定一个IndexWriterConfig对象。
     * 第二步：创建document对象。
     * 第三步：创建field对象，将field添加到document对象中。
     * 第四步：使用indexwriter对象将document对象写入索引库，此过程进行索引创建。并将索引和document对象写入索引库。
     * 第五步：关闭IndexWriter对象。
     */
    public static void main(String[] args) throws IOException {
        //存放索引的文件夹
        File indexFile = new File("index");
        System.out.println(indexFile.getAbsolutePath());
        FSDirectory directory = FSDirectory.open(indexFile.toPath());
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(new IKAnalyzer());
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);

        //要生成索引的文档的原始路引
        File dir = new File("searchsource");
        for (File file : dir.listFiles()) {
            //文件名
            String fileName = file.getName();
            //文件内容
            String content = FileUtils.readFileToString(file, "utf-8");
            //文件路径
            String filePath = file.getPath();
            //文件大小
            long fileSize = FileUtils.sizeOf(file);

            //创建文件名域
            //第一个参数,域的名称
            //第二个参数,域的内容
            //第三个参数,是否存储
            TextField nameField = new TextField("filename", fileName, Field.Store.YES);
            //创建文件内容域
            TextField contentField = new TextField("content", content, Field.Store.YES);
            //文件路径域
            TextField pathField = new TextField("path", filePath, Field.Store.YES);
            //文件大小域
            TextField sizeField = new TextField("size", String.valueOf(fileSize), Field.Store.YES);


            //创建 document 对象
            Document document = new Document();
            //将域添加到 document 对象中
            document.add(nameField);
            document.add(contentField);
            document.add(pathField);
            document.add(sizeField);
            //创建索引,并写入索引库
            indexWriter.addDocument(document);
        }
        indexWriter.close();
    }
}
