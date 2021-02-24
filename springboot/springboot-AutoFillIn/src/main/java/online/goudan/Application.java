package online.goudan;

import online.goudan.utils.RetrofitUtils;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Scanner;

/**
 * @author chenglongliu
 * @date 2020/12/21 14:16
 * @desc 项目启动入口
 */
@SpringBootApplication
@EnableScheduling
public class Application implements ApplicationRunner {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .web(WebApplicationType.NONE)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入 cookid");
        String cookie = scanner.nextLine();
        RetrofitUtils.setCookie(cookie);
    }
}
