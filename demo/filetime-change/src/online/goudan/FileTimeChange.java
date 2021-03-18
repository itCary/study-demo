package online.goudan;

import java.io.*;
import java.util.Scanner;

/**
 * @author chenglongliu
 * @date 2021/2/25 10:32
 * @desc 改变文件的创建时间
 */
public class FileTimeChange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入文件（包含文件夹）的路径地址：");
        String fileDir = scanner.nextLine();
        File rootFile = new File(fileDir);
        if (rootFile.exists()) {
            long startTime = System.currentTimeMillis();
            file2file(rootFile, rootFile.getParentFile());
            long endTime = System.currentTimeMillis();
            System.out.printf("总共用时：%ss", (endTime - startTime) / 1000);
        }
    }

    private static void file2file(File rootFile, File rootDir) {
        if (rootFile.isFile()) {
            file2disk(rootFile, rootDir);
            return;
        }
        if (rootFile.isDirectory()) {
            File[] files = rootFile.listFiles();
            for (File file : files) {
                file2file(file, rootDir);
            }
        }
    }

    private static void file2disk(File cFile, File rootDir) {
        File file = new File(rootDir.getPath() + "/副本", cFile.getPath().replace(rootDir.getPath(), ""));
        try {
            if (!file.exists()) {
                if (!file.getParentFile().exists()) {
                    System.out.printf("%n创建目录[%s]--%s--%n", file.getParent().replace(rootDir.getPath() + "/", ""), file.getParentFile().mkdirs() ? "成功" : "失败");
                }
                System.out.printf("创建文件【%s】--%s--%n", file.getName(), file.createNewFile() ? "成功" : "失败");
            } else {
                System.out.printf("文件【%s】已存在", file.getName());
            }

            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(cFile));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            byte[] buffer = new byte[1024 * 10];
            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, len);
            }
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            bufferedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
