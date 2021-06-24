package online.goudan;

import online.goudan.domain.M3U8;
import online.goudan.domain.VideoInfo;
import online.goudan.util.M3U8Manager;
import online.goudan.util.ProcessManager;
import online.goudan.util.listener.M3U8TsListener;

import java.io.File;
import java.util.Optional;

/**
 * @author 刘成龙
 * @date 2021/6/24 10:28
 * @desc ProcessViewClient
 */
public class ProcessViewClient {

    public static void main(String[] args) throws Exception {
//        InputStream inputStream = new URL("https://fc.imgscloud.com/c/oxnmkpsetv/oxnmkpsetv_351.ts").openStream();
//        IOUtils.copyFromURL(new URL("https://fc.imgscloud.com/c/oxnmkpsetv/oxnmkpsetv_351.ts"), new File("oxnmkpsetv_351.ts"));
//        ProcessManager processManager = ProcessManager.createProcessManager("/Users/Cary/Downloads", "aa");
//        processManager.addMessage("开始下载");
//        for (int i = 0; i <= 100; i++) {
//            processManager.setProcess(i);
//            Thread.sleep(500);
//        }
        M3U8Manager m3U8Manager = M3U8Manager.getInstance();
        VideoInfo ldjala = new VideoInfo("ldjala", "https://fc.imgscloud.com/c/oxnmkpsetv/oxnmkpsetv.m3u8");
        ProcessManager processManager = ProcessManager.createProcessManager("/Users/Cary/Downloads", ldjala.getVideoName());
        Optional<ProcessManager> optionalProcessManager = Optional.ofNullable(processManager);

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
            public void megerFinish() {
                optionalProcessManager.ifPresent(manger -> {
                    manger.addMessage("合并完成");
                    manger.close();
                });

            }
        });
        m3U8Manager.setVideoInfo(ldjala);
        optionalProcessManager.ifPresent(manager -> manager.addMessage("开始生成M3U8"));
        m3U8Manager.generateM3U8("/Users/Cary/Downloads");
        m3U8Manager.downloadM3U8Ts();
    }


}
