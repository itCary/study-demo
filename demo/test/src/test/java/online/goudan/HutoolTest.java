package online.goudan;

import cn.hutool.crypto.SecureUtil;
import org.junit.Test;

/**
 * @author chenglongliu
 * @date 2021/3/25 17:02
 * @desc Hutool工具类测试用例
 */
public class HutoolTest {

    @Test
    public void testIOUtil() {
    }

    @Test
    public void testSecureUtil() {
        String s = "ajofjofjqoqfn";
        String s1 = SecureUtil.md5(s);
        System.out.println(s1);
    }

    @Test
    public void testAnnotationUtil() {
    }
}
