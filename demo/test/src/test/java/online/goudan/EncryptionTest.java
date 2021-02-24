package online.goudan;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author chenglongliu
 * @date 2020/11/12 10:25
 * @desc 加密测试
 */
public class EncryptionTest {
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

    @Test
    public void test01() {
        String hmac = genHMAC("afafafdsfa", "test123");
        System.out.println(hmac);
    }

    public static long feipo(int num) {
        long[] arr = new long[num];
        for (int i = 0; i < num; i++) {
            if (i == 0 || i == 1) {
                arr[i] = i;
            } else {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
        }
        return arr[num - 1];
    }

    @Test
    public void test02() {
        long s = System.currentTimeMillis();
        long sum = 0;
        for (long i = 0; i < 1000000000L; i++) {
            sum += i;
        }
        long e = System.currentTimeMillis();
        System.out.println(sum);
        System.out.println((e - s) / 1000d);
    }

    /**
     * 使用 HMAC-SHA1 签名方法对data进行签名
     *
     * @param data 被签名的字符串
     * @param key  密钥
     * @return 加密后的字符串
     */
    public static String genHMAC(String data, String key) {
        byte[] result = null;
        try {
            //根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
            SecretKeySpec signinKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
            //生成一个指定 Mac 算法 的 Mac 对象
            Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
            //用给定密钥初始化 Mac 对象
            mac.init(signinKey);
            //完成 Mac 操作
            byte[] rawHmac = mac.doFinal(data.getBytes());
            result = Base64.encodeBase64(rawHmac);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            System.err.println(e.getMessage());
        }
        if (null != result) {
            return new String(result);
        } else {
            return null;
        }
    }
}
