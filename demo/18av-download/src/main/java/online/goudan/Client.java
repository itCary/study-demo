package online.goudan;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.TextUtils;

import javax.xml.crypto.URIReferenceException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.*;
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
        Class.forName("com.mysql.jdbc.Driver");
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
            System.out.println("请输入文件名：");
            String fileName = scanner.nextLine();
            executorService.execute(() -> {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql:///novel", "root", "root");
                    String sql = "insert into au(name,url,gmt_create,gmt_modified) values(?,?,?,?)";

                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    String fn = Base64.getEncoder().encodeToString(fileName.getBytes(StandardCharsets.UTF_8));
                    preparedStatement.setString(1, fn);
                    preparedStatement.setString(2, url);
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String dateStr = format.format(new Date());
                    preparedStatement.setString(3, dateStr);
                    preparedStatement.setString(4, dateStr);
                    final int i = preparedStatement.executeUpdate();
                    System.out.println(i > 0);
                    connection.close();
                    downAndMerge(dir, url, fileName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("退出应用");
        System.exit(0);
    }

    private static void downAndMerge(String dir, String url, String fileName) throws URIReferenceException {
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            String[] split = url.split("\\/");
            String name = split[split.length - 1];
//            String fileName = name.split("\\.")[0] + ".ts";
            HttpGet httpGet = new HttpGet(url);
            ExecutorService executorService = Executors.newFixedThreadPool(5);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null && entity.isStreaming()) {
                File dirFile = new File(dir);
                if (!dirFile.exists()) {
                    dirFile.mkdirs();
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                File logFile = new File(dir, fileName + ".log");
                if (!logFile.exists()) {
                    logFile.createNewFile();
                }
                FileOutputStream out = new FileOutputStream(logFile, true);
                out.write(String.format("[%s]   %s.ts 开始下载%n", sdf.format(new Date()), fileName).getBytes());

                File file = new File(dirFile, fileName + ".ts");
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
                        try {
                            File f = new File(dirFile, s);
                            if (f.exists()) {
                                synchronized (out) {
                                    out.write(String.format("%s已经存在%n", f.getName()).getBytes());
                                }
                                list.add(f);
                                return;
                            }
                            HttpGet get = new HttpGet(url.replace(name, s));
                            CloseableHttpResponse res = httpClient.execute(get);
                            FileOutputStream os = new FileOutputStream(f);
                            res.getEntity().writeTo(os);
                            synchronized (out) {
                                out.write(String.format("[%s]   %s下载成功%n", sdf.format(new Date()), f.getName()).getBytes());
                            }
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
                out.write(String.format("[%s]   %s下载完成%n", sdf.format(new Date()), file.getName()).getBytes());

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
                out.write(String.format("[%s]   %s合并完成%n", sdf.format(new Date()), file.getName()).getBytes());
            }
        } catch (Exception e) {
            System.out.println("aaaaaaaaaaaaaaaaa");
            e.printStackTrace();
        }
    }

}
