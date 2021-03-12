package online.goudan.consumer.work_queue;

import com.rabbitmq.client.*;
import online.goudan.util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author chenglongliu
 * @date 2021/3/12 16:03
 * @desc 工作队列模式的消费者
 */
public class Consumer_WorkQueue4 {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        String queueName = "work_queues";
        channel.queueDeclare(queueName, true, false, false, null);
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                System.out.println("consumerTag: " + consumerTag);
//                System.out.println("Exchange: " + envelope.getExchange());
//                System.out.println("RoutingKey: " + envelope.getRoutingKey());
//                System.out.println("properties: " + properties);
                System.out.println("body: " + new String(body));
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }
}
