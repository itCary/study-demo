package online.goudan.consumer.hello_world;

import com.rabbitmq.client.*;
import online.goudan.util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author chenglongliu
 * @date 2021/3/12 15:29
 * @desc 简单模式的消费者
 */
public class Consumer_HelloWorld {
    public static void main(String[] args) throws IOException, TimeoutException {


        Connection connection = ConnectionUtil.getConnection();

        //4.创建Channel

        Channel channel = connection.createChannel();

        //5.创建队列

        //如果没有名字叫 hello_world 的队列，则会创建
        channel.queueDeclare("hello_world", true, false, false, null);

        //6.接收消息
        /**
         * basicConsume(String queue, boolean autoAck, Consumer callback)
         *
         *      queue: 队列名称
         *      autoAck: 是否自动确认
         *      callback: 回调对象
         *
         */

        DefaultConsumer consumer = new DefaultConsumer(channel) {
            /**
             *
             * @param consumerTag 标识
             * @param envelope 获取一些信息（交换机的，routing_key....)
             * @param properties 配置信息
             * @param body 消息数据
             * @throws IOException
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.printf("consumerTag:%s%nExchange:%s%nRoutingKey:%s%nproperties:%s%nbody:%s%n",
                        consumerTag,
                        envelope.getExchange(),
                        envelope.getRoutingKey(),
                        properties.toString(),
                        new String(body));
            }
        };
        channel.basicConsume("hello_world", true, consumer);

    }
}
