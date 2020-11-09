package online.goudan;

import org.junit.Test;

import java.io.InputStream;

/**
 * @author chenglongliu
 * @date 2020/10/26 11:03
 * @desc shell 使用 Demo
 */
public class ShellTest  {

    @Test
    public void test01() throws Exception {
        InputStream in = Runtime.getRuntime().exec("ifconfig").getInputStream();

        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = in.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
    }
}
