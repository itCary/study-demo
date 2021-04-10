package online.goudan.task;

import com.google.gson.Gson;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import online.goudan.pojo.BackPack;
import online.goudan.pojo.Donate;
import online.goudan.pojo.Follow;
import online.goudan.utils.HttpUtils;
import online.goudan.utils.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author chenglongliu
 * @date 2021/4/9 20:35
 * @desc 每天定时获取免费礼物
 */
@Component
public class AutoDonateTask {

    @Autowired
    private HttpUtils httpUtils;
    @Autowired
    private OkHttpClient okHttpClient;
    private LogUtil log = LogUtil.getInstance(getClass());

    /**
     * 监控cookie文件是否发生变化
     *
     * @throws Exception
     */
    @Scheduled(fixedDelay = 15 * 1000)
    public void reloadCookie() {
        httpUtils.reloadCookie();
    }

    @Scheduled(fixedRate = 3 * 1000)
    public void exporterLog() {
        try {
            LogUtil.exporterLogFile();
        } catch (IOException e) {
            log.error("exporterLog: " + e.getMessage());
        }
    }

    private Gson gson = new Gson();
    int count = 10;

    int giftSize = 1;

    @Scheduled(cron = "0 0 2,6,12,18,22 * * ?")
//    @Scheduled(fixedRate = 1000 * 60 * 60 * 8)
    public void task() throws Exception {
        if (!httpUtils.enable()) {
            log.error("task: 没有cookie，无法进行！！！");
            if (count == 0) {
                count = 10;
                return;
            }
            count--;
            log.error("task: 30秒后尝试重新进行，第" + (10 - count) + "次");
            Thread.sleep(1000 * 30);
            task();
            return;
        }
        count = 10;
        //先获取关注列表
        Request followRequest = httpUtils.createGetRequest("/wgapi/livenc/liveweb/follow/list?sort=0&cid1=0", null);
        Response followResponse = okHttpClient.newCall(followRequest).execute();
        List<Follow.DataDTO.Room> roomList = gson.fromJson(followResponse.body().string(), Follow.class).getData().getList();
        if (httpUtils.getMost() == -1) {
            while (giftSize != 0) {
                roomList.stream().filter(room -> room.getIs_special() == 1)
                        .forEach(room -> {
                            try {
                                log.info("task: " + String.format("开始给主播 %s 送礼物了!", room.getNickname()));
                                Map<String, String> headers = new HashMap<>();
                                headers.put("referer", httpUtils.gertBasicUrl() + room.getUrl());
                                //获取背包里的礼物
                                Request backpackRequest = httpUtils.createGetRequest("/japi/prop/backpack/web/v1?rid=" + room.getRoom_id(), headers);
                                String backpackJson = okHttpClient.newCall(backpackRequest).execute().body().string();
                                BackPack backPack = gson.fromJson(backpackJson, BackPack.class);
                                List<BackPack.DataDTO.ListDTO> giftList = backPack.getData().getList();
                                giftSize = giftList.size();
                                if (giftList.size() <= 0) {
                                    log.info("task: 没有礼物了！！！没有礼物了！！！没有礼物了！！！没有礼物了！！！没有礼物了！！！");
                                    return;
                                }
                                BackPack.DataDTO.ListDTO listDTO = giftList.get(0);
                                int propCount = 1;
                                donateProp(room, headers, listDTO, propCount);
                            } catch (IOException e) {
                                log.error("task: " + e.getMessage());
                            }
                        });
            }
        }
        roomList.stream()
                .filter(room -> room.getIs_special() == 1)
                .sorted((o1, o2) -> {
                    if (o1.getRoom_id() == httpUtils.getMost()) {
                        return 1;
                    } else if (o2.getRoom_id() == httpUtils.getMost()) {
                        return -1;
                    }
                    return o1.getRoom_id() - o2.getRoom_id();
                })
                .forEach(room -> {
                    try {
                        log.info("task: " + String.format("开始给主播 %s 送礼物了!", room.getNickname()));
                        Map<String, String> headers = new HashMap<>();
                        headers.put("referer", httpUtils.gertBasicUrl() + room.getUrl());
                        //获取背包里的礼物
                        Request backpackRequest = httpUtils.createGetRequest("/japi/prop/backpack/web/v1?rid=" + room.getRoom_id(), headers);
                        String backpackJson = okHttpClient.newCall(backpackRequest).execute().body().string();
                        BackPack backPack = gson.fromJson(backpackJson, BackPack.class);
                        List<BackPack.DataDTO.ListDTO> giftList = backPack.getData().getList();
                        if (room.getRoom_id() == httpUtils.getMost()) {
                            giftList.stream().forEach(listDTO -> {
                                donateProp(room, headers, listDTO, listDTO.getCount());
                            });
                        }
                        if (giftList.size() <= 0) {
                            log.info("task: 没有礼物了！！！没有礼物了！！！没有礼物了！！！没有礼物了！！！没有礼物了！！！");
                            return;
                        }
                        BackPack.DataDTO.ListDTO listDTO = giftList.get(0);
                        int propCount = 1;
                        donateProp(room, headers, listDTO, propCount);
                    } catch (IOException e) {
                        log.error("task: " + e.getMessage());
                    }

                });
    }

    private void donateProp(Follow.DataDTO.Room room, Map<String, String> headers, BackPack.DataDTO.ListDTO listDTO, int propCount) {
        try {
            //赠送礼物
            Map<String, String> params = new HashMap<>();
            params.put("propId", String.valueOf(listDTO.getId()));
            params.put("propCount", String.valueOf(propCount));
            params.put("roomId", String.valueOf(room.getRoom_id()));
            params.put("bizExt", "");
            Request donateRequest = httpUtils.createPostRequest("/japi/prop/donate/mainsite/v1", headers, params);
            String donateJson = okHttpClient.newCall(donateRequest).execute().body().string();
            Donate donate = gson.fromJson(donateJson, Donate.class);
            if ("success".equals(donate.getMsg())) {
                log.info("donateProp: " + String.format("给主播 %s 赠送礼物 %s %d 个成功", room.getNickname(), listDTO.getName(), propCount));
            } else {
                log.error("donateProp: " + String.format("给主播 %s 赠送礼物 %s %d 个失败了", room.getNickname(), listDTO.getName(), propCount));
            }
            log.info("donateProp: " + String.format("礼物 %s 还剩下 %d 个", listDTO.getName(), listDTO.getCount()));
        } catch (IOException e) {
            log.error("donateProp: " + e.getMessage());
        }
    }

}
