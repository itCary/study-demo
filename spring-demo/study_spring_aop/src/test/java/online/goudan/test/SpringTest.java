package online.goudan.test;

import online.goudan.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 刘成龙
 * @description
 * @date 2020/9/10 22:08
 */
public class SpringTest {

    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        UserDao userDao1 = (UserDao) applicationContext.getBean("userDao");
        System.out.println(userDao);
        System.out.println(userDao1);
        userDao.save();
    }

    @Test
    /**
     * 测试初始化和销毁方法
     */
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        System.out.println(userDao);
        ((ClassPathXmlApplicationContext)applicationContext).close();
    }
}
