package online.goudan.producer.topics;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import online.goudan.util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author chenglongliu
 * @date 2021/3/14 22:22
 * @desc 通配符模式下的生产者
 */
public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();

        Channel channel = connection.createChannel();

        String exchangeName = "test_topic";
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.TOPIC, true, false, false, null);

        String queueName1 = "test_topic_queue1";
        String queueName2 = "test_topic_queue2";

        channel.queueDeclare(queueName1, true, false, false, null);
        channel.queueDeclare(queueName2, true, false, false, null);


        channel.queueBind(queueName1, exchangeName, "*.error");
        channel.queueBind(queueName1, exchangeName, "order.*");


        channel.queueBind(queueName2, exchangeName, "*.*");


        String body = "日志信息:xxx调用了find()方法。。。日志级别:info....";
        int i = 0;
        while (i++ < Integer.MAX_VALUE) {

            channel.basicPublish(exchangeName, "order.error", null, (body + ".error").getBytes());
            channel.basicPublish(exchangeName, "order.info", null, (body + ".order").getBytes());
            channel.basicPublish(exchangeName, "goods.info", null, (body + ".warning").getBytes());
        }
        channel.close();
        connection.close();
    }
}
