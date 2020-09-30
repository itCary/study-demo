package online.goudan;

import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/**
 * @author 刘苟淡
 * @description
 * @date 2020/9/30 14:51
 */
public class DigestTest {

    byte[] bytes;
    int count = 0;

    @Before
    public void init() throws Exception {
//        bytes = "73.25".getBytes("utf-8");
        bytes = "c60e784027c853f845c09f2e6bb14b3a".getBytes("utf-8");
    }

    /**
     * md2
     */
    @Test
    public void test01() throws Exception {
        //获取 md2加密对象
        MessageDigest digest = MessageDigest.getInstance("MD2");
        new Thread(() -> {
            for (; count < 100000000; count++) {
                bytes = digest.digest(bytes);
            }
        }).start();

        HexBinaryAdapter hexBinaryAdapter = new HexBinaryAdapter();
        String marshal;
        while (count < 100000000) {
            Thread.sleep(2000l);
            System.out.printf("%d : progress = %06.2f%%%n", System.currentTimeMillis() / 1000 % 3600, (count / 1000000d));
            marshal = hexBinaryAdapter.marshal(bytes);
            System.out.println(marshal.toLowerCase(Locale.CHINA));
        }
        System.out.printf("%dprogress:%06.2f%%%n", System.currentTimeMillis() / 1000 % 3600, (count / 1000000d));
        marshal = hexBinaryAdapter.marshal(bytes);
        hexBinaryAdapter.unmarshal("c60e784027c853f845c09f2e6bb14b3a");
        System.out.println(marshal.toLowerCase(Locale.CHINA));
    }

    @Test
    public void test02() throws Exception {
        HexBinaryAdapter hexBinaryAdapter = new HexBinaryAdapter();
        byte[] bytes = hexBinaryAdapter.unmarshal("c60e784027c853f845c09f2e6bb14b3a");
        System.out.println(new String(bytes));

    }
}
