package online.goudan.utils;

import cn.hutool.crypto.digest.MD5;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

/**
 * @author chenglongliu
 * @date 2021/4/9 20:48
 * @desc http请求封装工具类
 */
public class HttpUtils {

    private final String basicUrl = "https://www.douyu.com";

    private String cookie;
    private String disgest;
    private File file;
    private final MD5 md5 = MD5.create();
    private Properties properties;
    private final LogUtil log = LogUtil.getInstance(getClass());

    public HttpUtils() {
        loadPropertiesFile();
    }

    private void loadPropertiesFile() {
        properties = new Properties();
        try {
            File dirfile = new File(System.getProperty("user.dir"));
            file = new File(dirfile, "douyu.properties");
            if (!file.exists()) {
                file.createNewFile();
            }
            properties.load(new FileInputStream(file));
        } catch (Exception e) {
            log.error("loadPropertiesFile: " + e.getMessage());
        }
    }


    public Request createGetRequest(String api, @Nullable Map<String, String> headers) {
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url(basicUrl + api);
        requestBuilder.addHeader("cookie", cookie);
        if (headers != null && headers.size() > 0) {
            Set<String> strings = headers.keySet();
            for (String headName : strings) {
                requestBuilder.addHeader(headName, headers.get(headName));
            }
        }
        return requestBuilder.build();
    }

    public Request createPostRequest(String api,
                                     @Nullable Map<String, String> headers,
                                     @Nullable Map<String, String> params) {
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url(basicUrl + api);
        requestBuilder.addHeader("cookie", cookie);

        if (headers != null && headers.size() > 0) {
            Set<String> strings = headers.keySet();
            for (String headName : strings) {
                requestBuilder.addHeader(headName, headers.get(headName));
            }
        }
        FormBody.Builder bodyBuilder = new FormBody.Builder();
        if (params != null && params.size() > 0) {
            Set<String> paramSet = params.keySet();
            for (String paramName : paramSet) {
                bodyBuilder.add(paramName, params.get(paramName));
            }

        }
        return requestBuilder
                .post(bodyBuilder.build())
                .build();
    }

    public synchronized void reloadCookie() {
        if (cookie == null || !md5.digestHex(md5.digest(file)).equals(disgest)) {
            try {
                properties.load(new FileInputStream(file));
                cookie = properties.getProperty("cookie");
                if (cookie != null && !md5.digestHex(md5.digest(file)).equals(disgest)) {
                    log.info("reloadCookie: properties配置文件发生更改,重新加载完成");
                }
                if (cookie != null && md5.digestHex(md5.digest(file)).equals(disgest)) {
                    log.info("reloadCookie: 加载properties配置文件成功");
                }
                disgest = md5.digestHex(md5.digest(file));
            } catch (Exception e) {
                log.info("reloadCookie: 加载properties配置文件失败");
                log.error("reloadCookie: " + e.getMessage());
            }
            if (cookie == null) {
                log.info("reloadCookie: 配置文件里没有cookie数据");
            }

        }
    }

    public int getMost() {
        try {
            return Integer.parseInt(properties.getProperty("most"));
        } catch (Exception e) {
            log.error("getMost: " + e.getMessage());
        }
        return -1;
    }

    public String gertBasicUrl() {
        return basicUrl;
    }

    public boolean enable() {
        if (cookie == null) {
            reloadCookie();
        }
        return cookie != null;
    }
}
