package online.goudan;

import io.reactivex.annotations.Nullable;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import javax.xml.crypto.URIReferenceException;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenglongliu
 * @date 2021/4/2 23:26
 * @desc HttpTest
 */
public class HttpTest {
    @Test
    public void testHttpClient() {
//        String url = "https://fc.imgscloud.com/e/ufletljgte/ufletljgte.m3u8";
//        String url = "https://fc.imgscloud.com/c/wgcrqiszfr/wgcrqiszfr.m3u8";
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Scanner scanner = new Scanner(System.in);
        String order = null;
        while (!"exit".equals(order)) {
            System.out.println("请输入地址：");
            order = scanner.nextLine();
            String url = order;
            executorService.execute(() -> {
                try {
                    downAndMerge(url);
                } catch (URIReferenceException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private void downAndMerge(@Nullable String url) throws URIReferenceException {
        if (null == url) {
            throw new URIReferenceException("找不到地址");
        }
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        String[] split = url.split("\\/");

        String name = split[split.length - 1];
        String fileName = name.split("\\.")[0] + ".ts";
        HttpGet httpGet = new HttpGet(url);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);

            HttpEntity entity = response.getEntity();
            if (entity != null && entity.isStreaming()) {
                File dirFile = new File("/Users/Cary/ts/");
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
                        HttpGet get = new HttpGet(url.replace(name, s));
                        System.out.println("uri=" + get.getURI());
                        CloseableHttpResponse res = null;
                        InputStream content = null;
                        File f = new File(dirFile, s);
                        try {
                            System.out.println(s + "\tdownload...");
                            res = HttpClientBuilder.create().build().execute(get);
                            System.out.println(s + "\tdownload success");
                            FileOutputStream os = new FileOutputStream(f);
                            System.out.println(s + "\twriting....");
                            res.getEntity().writeTo(os);
                            System.out.println(s + "\twrite success\n");
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
                System.out.println("下载完成");
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
                    System.out.println(file.getName());
                    file.delete();
                }
                outputStream.close();
                System.out.println("合并完成");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMerge() throws Exception {
        File parentFile = new File("/Users/Cary/ts");
        File[] files = parentFile.listFiles();
        FileOutputStream outputStream = new FileOutputStream(new File("/Users/Cary/ts/dd.ts"));
        List<File> list = new ArrayList<>();
        for (File file : files) {

            if (!file.getName().endsWith(".ts")) {
                continue;
            }
            list.add(file);
        }
        list.sort(new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                String s1 = o1.getName().replace(".ts", "").split("_")[1];
                String s2 = o2.getName().replace(".ts", "").split("_")[1];

                return Integer.parseInt(s1) - Integer.parseInt(s2);
            }
        });
        for (File file : list) {
            FileInputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            outputStream.write(bytes);
            inputStream.close();
            System.out.println(file.getName());
            file.delete();
        }
        outputStream.close();
    }

    @Test
    public void testB() throws InterruptedException {
        int i = 0;
        while (true) {
//            System.out.print("\b\b");
            System.out.print(i++ + "%");
            Thread.sleep(2000);
        }

    }
}
