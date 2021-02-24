package online.goudan.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import online.goudan.pojo.MacPojo;
import online.goudan.pojo.RequestPojo;
import online.goudan.utils.Api;
import online.goudan.utils.RetrofitUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author chenglongliu
 * @date 2020/12/21 14:52
 * @desc MyTask
 */

@Component
@Slf4j
public class MyTask {

    private ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @Scheduled(fixedDelay = 10 * 1000L)
    public void getMacList() {
        Api api = RetrofitUtils.createApi(Api.class);
        RequestPojo<Object> requestPojo = new RequestPojo<>();
        requestPojo.setMethod("get");
        String s = objectMapper.writeValueAsString(requestPojo);
        Call<Response<MacPojo>> macList = api.getMacList(s);
        macList.enqueue(new Callback<Response<MacPojo>>() {
            @Override
            public void onResponse(Call<Response<MacPojo>> call, Response<Response<MacPojo>> response) {
                log.debug("onResponse: " + response);
            }

            @SneakyThrows
            @Override
            public void onFailure(Call<Response<MacPojo>> call, Throwable throwable) {
                MacPojo body = call.execute().body().body();
                System.out.println("body=" + body);
                log.error("onFailure: " + throwable);
            }
        });
    }
}
