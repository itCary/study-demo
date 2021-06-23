package online.goudan;

import online.goudan.utils.MailManager;
import org.junit.Test;

/**
 * @author 刘成龙
 * @date 2021/6/23 10:55
 * @desc MailTest
 */
public class MailTest {

    @Test
    public void testSendMail() {
        boolean b = MailManager.sendMail("1093782389@qq.com", "测试", "sijdifja");
        if (b) {
            System.out.println("发送成功");
        } else {
            System.out.println("发送失败");
        }
    }

}
