package online.goudan.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.istack.internal.NotNull;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import online.goudan.pojo.IUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 刘苟淡
 * @description
 * @date 2020/9/16 15:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class JdbcTemplateTest {

    @Autowired
    private ComboPooledDataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 测试 dataSourc 是否配置成功
     */
    @Test
    public void test01() throws Exception {
        System.out.println(dataSource.getUser());
        System.out.println(dataSource.getPassword());
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(2));
        }
        connection.close();
    }

    /**
     * 测试 jdbcTemplate 是否配置成功
     */
    @Test
    public void test02() {
        System.out.println(dataSource);
        System.out.println(jdbcTemplate.getDataSource());
    }

    /**
     * 使用 jdbcTemplate 完成数据库插入操作
     */
    @Test
    public void test03() {
        int update = jdbcTemplate.update("insert into user(name) values(?)", "按揭房垃圾");
        System.out.println("update:" + update);
        List<IUser> IUserList = jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<IUser>(IUser.class));
        for (IUser IUser : IUserList) {
            System.out.println(IUser);
        }
    }
}
