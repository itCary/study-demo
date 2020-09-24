package online.goudan;

import online.goudan.domain.Car;
import org.junit.Test;

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
}
