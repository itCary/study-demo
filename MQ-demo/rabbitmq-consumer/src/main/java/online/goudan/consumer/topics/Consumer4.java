package online.goudan.consumer.topics;

import com.rabbitmq.client.*;
import online.goudan.util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author chenglongliu
 * @date 2021/3/14 22:37
 * @desc 通配符模式下的消费者
 */
public class Consumer4 {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();

        Channel channel = connection.createChannel();

        String exchangeName = "test_topic";
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.TOPIC, true, false, false, null);

        String queueName1 = "test_topic_queue1";
        channel.queueDeclare(queueName1, true, false, false, null);

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body));

                System.out.println("保存到数据库");

                System.out.println(Thread.currentThread().getName());
//                dd();
            }
        };

        channel.basicConsume(queueName1, true, consumer);

    }

    public static synchronized void dd() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("同步方法块");
    }
}
