package online.goudan.test;

import online.goudan.pojo.TbUser;
import online.goudan.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author 刘苟淡
 * @description 用户服务测试
 * @date 2020/9/23 18:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;


    /**
     * 测试保存用户
     */
    @Test
    public void test01() {
        TbUser tbUser = new TbUser();
        tbUser.setId(19L);
        tbUser.setUserName("test");
        tbUser.setName("test");
        tbUser.setPassword("123456");
        tbUser.setSex(2);
        tbUser.setAge(31);
        tbUser.setCreated(new Date());
        userService.saveTbUser(tbUser);
    }

    /**
     * 测试根据 id 查询
     */
    @Test
    public void test02() {
        TbUser tbUser = userService.queryById(1L);
        System.out.println(tbUser);
    }
}
