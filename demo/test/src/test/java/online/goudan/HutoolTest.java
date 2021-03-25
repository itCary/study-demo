package online.goudan;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author chenglongliu
 * @date 2021/3/25 17:02
 * @desc Hutool工具类测试用例
 */
public class HutoolTest {

    @Test
    public void testIOUtil() {
//        Car car = null;
//        assert car != null : "car is null";
        BigDecimal bigDecimal = BigDecimal.valueOf(1.19);
        double v = bigDecimal.setScale(1, BigDecimal.ROUND_DOWN).doubleValue();
        System.out.println(v);

    }
}
