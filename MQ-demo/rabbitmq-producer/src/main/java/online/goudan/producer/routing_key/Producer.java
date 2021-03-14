package online.goudan.producer.routing_key;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import online.goudan.util.ConnectionUtil;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.TimeoutException;

/**
 * @author chenglongliu
 * @date 2021/3/14 21:15
 * @desc routing_key模式下的生产者
 */
public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();


        String exchangeName = "test_direct";
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.DIRECT, true, false, false, null);


        String queueName1 = "test_direct_queue1";
        String queueName2 = "test_direct_queue2";
        channel.queueDeclare(queueName1, true, false, false, null);
        channel.queueDeclare(queueName2, true, false, false, null);

        channel.queueBind(queueName1, exchangeName, "error");

        channel.queueBind(queueName2, exchangeName, "info");
        channel.queueBind(queueName2, exchangeName, "warning");
        channel.queueBind(queueName2, exchangeName, "error");

        String body = "日志信息:xxx调用了find()方法。。。日志级别:info....";

        channel.basicPublish(exchangeName, "error", null, body.getBytes());
        channel.close();
        connection.close();

    }
}
