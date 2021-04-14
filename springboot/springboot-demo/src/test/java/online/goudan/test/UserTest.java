package online.goudan.test;

import online.goudan.pojo.User;
import online.goudan.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author chenglongliu
 * @date 2021/4/14 16:38
 * @desc UserTest
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setAge(322);
        user.setBirthday(new Date());
        user.setCreated(new Date());
        user.setSex(1);
        user.setName("di喊醒");
        user.setNote("akjfoqlajfoqjfojoqjlajfjl罗曼蒂克alfjal");
        user.setPassword("123456");
        user.setUserName("sgodaa");
        user.setUpdated(new Date());
        userService.saveUser(user);

    }
}
