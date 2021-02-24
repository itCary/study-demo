package online.goudan;

import org.junit.Test;

/**
 * @author chenglongliu
 * @date 2020/12/30 09:30
 * @desc Math 类的 demo
 */
public class MathTest {

    @Test
    public void testToRadians() {
        double v_10 = Math.toRadians(-10);
        double v_370 = Math.toRadians(370);
        double sin10 = Math.sin(v_10);
        double sin370 = Math.sin(v_370);

        System.out.printf("v10:%f,v370:%f%n", sin10, sin370);
    }
}
