package online.goudan;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.TextUtils;

import javax.xml.crypto.URIReferenceException;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenglongliu
 * @date 2021/4/3 19:15
 * @desc Client
 */
@SuppressWarnings("all")
public class Client {
    public static String dir;

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (TextUtils.isEmpty(dir)) {
                System.out.println("请输入文件保存地址：");
                dir = scanner.nextLine();
            }
            System.out.println("请输入下载地址：");
            String url = scanner.nextLine();
            if ("exit".equals(url)) {
                break;
            }
            if (TextUtils.isEmpty(url) || TextUtils.isEmpty(dir)) {
                System.out.println("地址为空！！\n");
                continue;
            }
            executorService.execute(() -> {
                try {
                    downAndMerge(dir, url);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("退出。。。。。。");
        Thread.sleep(1500);
        System.out.println("退出成功！");
        System.exit(0);
    }

    private static void downAndMerge(String dir, String url) throws URIReferenceException {
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            String[] split = url.split("\\/");
            String name = split[split.length - 1];
            String fileName = name.split("\\.")[0] + ".ts";
            HttpGet httpGet = new HttpGet(url);
            ExecutorService executorService = Executors.newFixedThreadPool(10);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null && entity.isStreaming()) {
                System.out.println(fileName + "\t开始下载");
                File dirFile = new File(dir);
                if (!dirFile.exists()) {
                    dirFile.mkdirs();
                }
                File file = new File(dirFile, fileName);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()));
                String d;
                List<File> list = new ArrayList<>();
                while ((d = bufferedReader.readLine()) != null) {
                    if (d.startsWith("#")) {
                        continue;
                    }
                    String s = d;
                    executorService.execute(() -> {
//                        System.out.println("uri=" + get.getURI());
                        CloseableHttpResponse res = null;
                        InputStream content = null;
                        File f = new File(dirFile, s);
                        if (f.exists()) {
                            return;
                        }
                        HttpGet get = new HttpGet(url.replace(name, s));
                        try {
//                            System.out.println(s + "\tdownload...");
                            res = httpClient.execute(get);
//                            System.out.println(s + "\tdownload success");
                            FileOutputStream os = new FileOutputStream(f);
//                            System.out.println(s + "\twriting....");
                            res.getEntity().writeTo(os);
//                            System.out.println(s + "\twrite success\n");
                            list.add(f);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                }
                executorService.shutdown();
                while (!executorService.isTerminated()) {
                    Thread.sleep(1000);
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println(sdf.format(new Date()) + ",\t" + file.getName() + "下载完成");
                list.sort((o1, o2) -> {
                    String s1 = o1.getName().replace(".ts", "").split("_")[1];
                    String s2 = o2.getName().replace(".ts", "").split("_")[1];
                    return Integer.parseInt(s1) - Integer.parseInt(s2);
                });
                FileOutputStream outputStream = new FileOutputStream(file);
                for (File file1 : list) {
                    FileInputStream inputStream = new FileInputStream(file1);
                    byte[] bytes = new byte[inputStream.available()];
                    inputStream.read(bytes);
                    outputStream.write(bytes);
                    inputStream.close();
                    file1.delete();
                }
                outputStream.close();
                System.out.println(sdf.format(new Date()) + "\t" + file.getName() + "合并完成");
            }
        } catch (Exception e) {
            System.out.println("外围出错");
        }
    }

}
