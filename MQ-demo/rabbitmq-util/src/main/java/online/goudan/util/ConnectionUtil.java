package online.goudan.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author chenglongliu
 * @date 2021/3/12 15:50
 * @desc 获取connection的封装
 */
public class ConnectionUtil {
    private static String host = "172.16.239.131";
    private static int port = 5672;
    private static String username = "goudan";
    private static String password = "goudan125";
    private static String vHostName = "piaoxianglou";

    public static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(host);
        factory.setPort(port);
        factory.setUsername(username);
        factory.setPassword(password);
        factory.setVirtualHost(vHostName);
        return factory.newConnection();
    }
}
