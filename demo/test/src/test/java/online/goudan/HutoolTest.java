package online.goudan;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

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
        double v = bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(v);
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "aa");
        System.out.println(map);
    }
}
