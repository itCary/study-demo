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
        System.out.println("请输入文件的路径地址：");
        String fileDir = scanner.nextLine();
        File rootFile = new File(fileDir);
        if (rootFile.exists()) {
            file2file(rootFile, rootFile.getParentFile());
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
                    System.out.printf("文件夹生成%s%n", file.getParentFile().mkdirs() ? "成功" : "失败");
                }
                System.out.printf("文件生成%s%n", file.createNewFile() ? "成功" : "失败");
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
