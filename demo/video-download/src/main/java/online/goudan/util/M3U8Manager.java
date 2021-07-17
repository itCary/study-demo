package online.goudan.util;

import com.mysql.jdbc.StringUtils;
import online.goudan.domain.M3U8;
import online.goudan.domain.M3U8Ts;
import online.goudan.domain.VideoInfo;
import online.goudan.util.listener.M3U8TsListener;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 刘成龙
 * @date 2021/6/24 11:41
 * @desc M3U8Manager
 */
@SuppressWarnings("all")
public class M3U8Manager {
    private ExecutorService executorService;
    private M3U8 m3U8;
    private M3U8TsListener listener;


    private VideoInfo videoInfo;

    private M3U8Manager() {
        executorService = Executors.newFixedThreadPool(10);
    }

    public static M3U8Manager getInstance() {
        return new M3U8Manager();
    }

    public void setListener(M3U8TsListener listener) {
        this.listener = listener;
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        this.videoInfo = videoInfo;
    }

    /**
     * 生成m3u8信息
     *
     * @param localDirPath
     * @return
     * @throws IOException
     */
    public void generateM3U8(String localDirPath) {

        try {
            m3U8 = new M3U8();
            m3U8.setLocalDirPath(localDirPath);
            //获取m3u8的baseUrl
            String m3u8BaseUrl = videoInfo.getM3u8Url().substring(0, videoInfo.getM3u8Url().lastIndexOf("/") + 1);
            m3U8.setBasePath(m3u8BaseUrl);
            InputStream m3u8InputStream = new URL(videoInfo.getM3u8Url()).openStream();
            BufferedReader m3u8Reader = new BufferedReader(new InputStreamReader(m3u8InputStream));
            String line;
            StringBuffer allM3U8 = new StringBuffer();
            while ((line = m3u8Reader.readLine()) != null) {
                if (line.startsWith("#EXTINF") || !line.startsWith("#")) {
                    allM3U8.append(line);
                }
            }
            setM3U8TsAndTotalTime(allM3U8);
        } catch (IOException e) {
            System.out.println("生成M3U8失败");
        }
    }

    private void setM3U8TsAndTotalTime(StringBuffer allM3U8) {
        float totalTime = 0f;
        String[] allM3U8StrArr = allM3U8.toString().replace("#EXTINF", "").split(":");
        for (String m3u8Str : allM3U8StrArr) {
            if (!StringUtils.isNullOrEmpty(m3u8Str)) {
                String[] m3u8Properties = m3u8Str.split(",");
                float seconds = Float.parseFloat(m3u8Properties[0]);
                totalTime += seconds;
                M3U8Ts m3U8Ts = new M3U8Ts(m3u8Properties[1], seconds);
                m3U8.addM3U8Ts(m3U8Ts);
            }
        }
        m3U8.setTotalTime(totalTime);
    }

    public void downloadM3U8Ts() {
        File parentFile = new File(m3U8.getLocalDirPath(), videoInfo.getVideoName());
        if (!parentFile.exists()) {
            if (!parentFile.mkdirs()) {
                System.out.println("download m3u8Ts fail");
                return;
            }
        }
        List<M3U8Ts> m3U8TsList = m3U8.getM3U8TsList();
        CountDownLatch countDownLatch = new CountDownLatch(m3U8TsList.size());

        for (M3U8Ts m3U8Ts : m3U8TsList) {
            executorService.execute(() -> {
                File m3U8TsFile = new File(parentFile, m3U8Ts.getName());
                m3U8.addM3U8TsFile(m3U8TsFile);
                try {
                    if (!m3U8TsFile.exists()) {
                        URL url = new URL(m3U8.getBasePath() + m3U8Ts.getName());
                        InputStream inputStream = url.openStream();
                        FileOutputStream output = new FileOutputStream(m3U8TsFile);
                        IOUtils.copy(inputStream, output);
                        output.close();
                        inputStream.close();
                    }
                    if (listener != null) {
                        listener.onDownloaded(m3U8.getProcess());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    m3U8.addDownloadedM3U8Ts(m3U8Ts);
                }
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            System.out.println("中断下载了");
        }
        if (listener != null) {
            listener.onFinish(m3U8);
        }
    }

    public void mergeM3U8Ts() {
        List<File> m3U8TsFileList = m3U8.getM3U8TsFileList();
        m3U8TsFileList.sort((o1, o2) -> {
            String s1 = o1.getName().replace(".ts", "").split("_")[1];
            String s2 = o2.getName().replace(".ts", "").split("_")[1];
            return Integer.parseInt(s1) - Integer.parseInt(s2);
        });

        List<Long> indexList = new ArrayList<>(m3U8TsFileList.size());
        long totalSize = 0;
        for (int i = 0; i < m3U8TsFileList.size(); i++) {
            File file = m3U8TsFileList.get(i);
            long length = file.length();
            indexList.add(totalSize);
            totalSize += length;
        }

        try {
            File videoFile = new File(m3U8.getLocalDirPath(), videoInfo.getVideoName() + ".ts");
            FileOutputStream videoOut = new FileOutputStream(videoFile, true);
            for (File file : m3U8TsFileList) {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bytes = new byte[fileInputStream.available()];
                fileInputStream.read(bytes);
                videoOut.write(bytes);
                fileInputStream.close();
                if (listener != null) {
                    listener.mergerProcess(file);
                }
            }
            videoOut.close();
            if (listener != null) {
                File parentFile = new File(m3U8.getLocalDirPath(), videoInfo.getVideoName());
                listener.megerFinish(parentFile);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


