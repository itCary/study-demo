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

    @Test
    public void test01() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String chinaTime = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINA));
        System.out.println(chinaTime);
    }

    @Test
    public void test02() throws InterruptedException {
        Random random = new Random();
        Observable.interval(0, 100, TimeUnit.MILLISECONDS)
                .subscribe(t -> {
                    System.out.println(random.nextInt(2000));
                    System.out.println(random.nextInt(2000));
                    System.out.println(random.nextInt(2000));
                });
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void test03(){
        System.out.printf("%06.1f",732d);
    }
}
