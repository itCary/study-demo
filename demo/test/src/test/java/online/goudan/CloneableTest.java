package online.goudan;

import online.goudan.domain.Car;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author 刘苟淡
 * @description
 * @date 2020/9/24 16:59
 */
public class CloneableTest {

    @Test
    public void test01() throws CloneNotSupportedException {
        Car car = new Car();
        car.setColor("红色");
        car.setName("大奔");
        Object clone = car.clone();

        System.out.println(car.toString());
        System.out.println(clone);

    }

    @Test
    public void test02() {
        String[] strings = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        Random random = new Random();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                stringBuilder.append(strings[random.nextInt(10)]);
            }
            boolean b = Verify.getInstance().verifySuccess(stringBuilder.toString());
            System.out.println(b);
        }
        System.out.println(list);
    }


    @Test
    public void test03() throws IOException {
        Process exec = Runtime.getRuntime().exec("ping www.baidu.com");
        InputStream inputStream = exec.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
    }
}
