package online.goudan;

import online.goudan.domain.M3U8;
import online.goudan.domain.VideoInfo;
import online.goudan.util.DBManager;
import online.goudan.util.M3U8Manager;
import online.goudan.util.ProcessManager;
import online.goudan.util.WebDriverManager;
import online.goudan.util.listener.M3U8TsListener;
import org.apache.http.util.TextUtils;

import java.io.File;
import java.util.List;
import java.util.Optional;
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
            System.out.println("请输入视频地址：");
            String videoUrl = scanner.nextLine();
            if ("exit".equals(videoUrl) || "exit".equals(dir)) {
                break;
            }
            if ("db".equals(videoUrl)) {
                System.out.println("输入开始下载id: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                List<VideoInfo> videoInfos = DBManager.getInstance().getm3U8List(id);
                for (VideoInfo videoInfo : videoInfos) {
                    executorService.execute(() -> downM3U8Ts(videoInfo));
                }
                continue;
            }
            if (TextUtils.isEmpty(videoUrl) || TextUtils.isEmpty(dir)) {
                System.out.println("地址为空！！!");
                continue;
            }
            WebDriverManager driverManager = WebDriverManager.getInstance();
            executorService.execute(() -> {
                VideoInfo videoInfo = driverManager.useWebDriverGetVideoInfo(videoUrl);
                DBManager.getInstance().saveBase64Name(videoInfo);
            });
        }
        WebDriverManager.close();
        System.out.println("退出应用");
        System.exit(0);
    }

    private static void downM3U8Ts(VideoInfo videoInfo) {
        ProcessManager processManager = ProcessManager.createProcessManager(dir, videoInfo.getVideoName());
        Optional<ProcessManager> optionalProcessManager = Optional.ofNullable(processManager);

        M3U8Manager m3U8Manager = M3U8Manager.getInstance();
        m3U8Manager.setListener(new M3U8TsListener() {
            @Override
            public void onDownloaded(int process) {
                optionalProcessManager.ifPresent(manager -> manager.setProcess(process));
            }

            @Override
            public void onFinish(M3U8 m3U8) {
                optionalProcessManager.ifPresent(manager -> {
                    manager.setProcess(m3U8.getProcess());
                    manager.addMessage("ts 下载完成了,开始合并");
                });
                m3U8Manager.mergeM3U8Ts();
            }

            @Override
            public void mergerProcess(File file) {
                optionalProcessManager.ifPresent(manger -> manger.addMessage("合并了" + file.getName()));
            }

            @Override
            public void megerFinish(File parentFile) {
                optionalProcessManager.ifPresent(manger -> {
                    manger.addMessage("合并完成");
                    manger.close();
                });
                if (parentFile.listFiles().length == 0) {
                    parentFile.delete();
                } else {
                    File[] files = parentFile.listFiles();
                    for (File file : files) {
                        file.delete();
                    }
                }

            }
        });

        m3U8Manager.setVideoInfo(videoInfo);
        m3U8Manager.generateM3U8(dir);
        m3U8Manager.downloadM3U8Ts();
    }
}
