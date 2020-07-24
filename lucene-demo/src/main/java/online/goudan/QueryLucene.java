package online.goudan;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;

/**
 * @author 刘成龙
 * @description
 * @date 2020/7/23 21:04
 */
public class QueryLucene {

    /**
     * 第一步：创建一个Directory对象，也就是索引库存放的位置。
     * 第二步：创建一个indexReader对象，需要指定Directory对象。
     * 第三步：创建一个indexsearcher对象，需要指定IndexReader对象
     * 第四步：创建一个TermQuery对象，指定查询的域和查询的关键词。
     * 第五步：执行查询。
     * 第六步：返回查询结果。遍历查询结果并输出。
     * 第七步：关闭IndexReader对象
     */
    public static void main(String[] args) throws IOException {
        //
        Directory indexDir = FSDirectory.open(new File("index").toPath());
        IndexReader indexReader = DirectoryReader.open(indexDir);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        //创建查询对象
        Query query = new TermQuery(new Term("filename", "apache"));
        //执行查询
        //第一个参数是查询对象，第二个返回结果数量的最大值
        TopDocs topDocs = indexSearcher.search(query, 1);
        System.out.println(topDocs.totalHits);

        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {

            //根据document的id查询
            //scoreDoc.doc就是document的id
            Document document = indexSearcher.doc(scoreDoc.doc);
            //根据document获得各个域的内容
            System.out.println(document.get("filename"));
            System.out.println(document.get("content"));
            System.out.println(document.get("path"));
            System.out.println(document.get("size"));

        }


    }
}
