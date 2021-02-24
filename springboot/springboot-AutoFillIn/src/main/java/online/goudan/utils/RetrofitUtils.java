package online.goudan.utils;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenglongliu
 * @date 2020/12/21 14:18
 * @desc Retrofit 的封装
 */
@Slf4j
public class RetrofitUtils {

    private static String cookie;

    public static void setCookie(String cookie) {
        RetrofitUtils.cookie = cookie;
    }

    private static OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Request.Builder builder = request.newBuilder();
            if (cookie != null) {
                builder.addHeader("Cookie", cookie);
                log.info("intercept: cookie=" + cookie);
            }
            Request build = builder.build();
            return chain.proceed(build);
        }
    }).build();
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.1.1")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static Map<Class, Object> map = new HashMap<>();

    public static <T> T createApi(Class<T> tClass) {
        T t = (T) map.getOrDefault(tClass, null);
        if (t == null) {
            t = retrofit.create(tClass);
            map.put(tClass, t);
        }
        return t;
    }

}
