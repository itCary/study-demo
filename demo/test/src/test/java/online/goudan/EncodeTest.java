package online.goudan;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author chenglongliu
 * @date 2020/11/11 13:53
 * @desc 编码demo
 */
public class EncodeTest {
    @Test
    public void test01() throws UnsupportedEncodingException {
        byte[] bytes = "中".getBytes("gbk");
        System.out.println(Arrays.toString(bytes));
        byte[] bytes1 = hexStringToBytes("ee03");
        System.out.println(Arrays.toString(bytes1));
    }

    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.trim();
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    public static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

}
