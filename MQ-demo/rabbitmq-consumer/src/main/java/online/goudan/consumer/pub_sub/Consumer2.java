package online.goudan.consumer.pub_sub;

import com.rabbitmq.client.*;
import online.goudan.util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author chenglongliu
 * @date 2021/3/12 17:09
 * @desc pubsub模式的消费者
 */
public class Consumer2 {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();

        Channel channel = connection.createChannel();

       Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("body: " + new String(body));
                System.out.println("将日志保存到数据库");
            }
        };
        String queueName1 = "test_fanout_queue1";
        String queueName2 = "test_fanout_queue2";
        channel.basicConsume(queueName2, true, consumer);


    }
}
