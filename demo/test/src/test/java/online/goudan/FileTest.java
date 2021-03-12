package online.goudan;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author chenglongliu
 * @date 2021/3/11 14:09
 * @desc FileTest
 */
public class FileTest {

    @Test
    public void test01() throws IOException {
        File file = new File("a.txt");
        file.createNewFile();
        File file1 = new File(file.getAbsolutePath());
        System.out.println(file1.getParent());
    }
}
