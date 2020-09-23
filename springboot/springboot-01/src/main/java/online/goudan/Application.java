package online.goudan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 刘苟淡
 * @description
 * @date 2020/9/23 15:34
 */
@SpringBootApplication
@MapperScan("online.goudan.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
