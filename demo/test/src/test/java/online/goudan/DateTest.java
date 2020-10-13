package online.goudan;

import io.reactivex.Observable;
import io.reactivex.Observer;
import org.junit.Test;
import sun.tools.jcmd.JCmd;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author 刘苟淡
 * @description
 * @date 2020/9/22 09:07
 */
public class DateTest {

    /**
     * 使用 localdatetime 对日期进行格式化
     */
    @Test
    public void test01() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String chinaTime = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINA));
        System.out.println(chinaTime);
    }


    /**
     * 练习 String.format()
     */
    @Test
    public void test02() {
        System.out.printf("%010x%n", 732);
        System.out.printf("%010x%n", 732);
        System.out.printf("%06x%n", 15);
        System.out.printf("progress:%06.2f%%%n", 0.0253434);
    }
}
