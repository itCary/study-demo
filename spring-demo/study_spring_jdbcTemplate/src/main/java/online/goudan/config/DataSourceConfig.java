package online.goudan.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author 刘苟淡
 * @description
 * @date 2020/9/16 15:02
 */
@Configuration
@PropertySource("db.properties")
public class DataSourceConfig {


    @Value("${driverName}")
    private String driver;
    @Value("${url}")
    private String url;
    @Value("${userName}")
    private String user;
    @Value("${password}")
    private String password;


    @Bean
    public ComboPooledDataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        return dataSource;
    }

}
