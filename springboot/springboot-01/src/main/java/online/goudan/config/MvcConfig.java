package online.goudan.config;

import online.goudan.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 刘苟淡
 * @description
 * @date 2020/9/23 16:57
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 将自定义的拦截器注册到 spring ioc 容器中
     *
     * @return
     */
    @Bean
    public MyInterceptor myInterceptor() {
        return new MyInterceptor();
    }

    /**
     * 重写该方法；往拦截器链添加自定义拦截器 * @param registry 拦截器链
     *
     * @param registry 拦截器链
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //通过registry添加myInterceptor拦截器，并设置拦截器路径为 /*
        registry.addInterceptor(myInterceptor()).addPathPatterns("/*");
    }
}
