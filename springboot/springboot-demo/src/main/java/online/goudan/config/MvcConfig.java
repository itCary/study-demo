package online.goudan.config;

import online.goudan.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author chenglongliu
 * @date 2021/4/14 15:34
 * @desc MvcConfig
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {


    @Autowired
    private MyInterceptor myInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).addPathPatterns("/*");
    }
}
