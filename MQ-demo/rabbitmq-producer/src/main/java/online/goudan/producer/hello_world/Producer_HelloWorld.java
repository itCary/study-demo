package online.goudan.producer.hello_world;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import online.goudan.util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author chenglongliu
 * @date 2021/3/12 14:44
 * @desc 简单模式的生产者
 */
public class Producer_HelloWorld {
    public static void main(String[] args) throws IOException, TimeoutException {


        Connection connection = ConnectionUtil.getConnection();
        //4.创建Channel

        Channel channel = connection.createChannel();

        //5.创建队列

        /**
         * queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete,
         *                                  Map<String, Object> arguments)
         *    queue: 队列名称
         *    durable: 是否持久化
         *    exclusive:
         *      * 是否独占，只能有一个消费来监听队列
         *      * 当connection关闭，是否删除队列
         *      * 一般设置为false
         *    autoDelete: 是否自动删除
         *    arguments: 参数
         *
         */
        //如果没有名字叫 hello_world 的队列，则会创建
        channel.queueDeclare("hello_world", true, false, false, null);

        //6.发送消息
        /**
         * basicPublish(String exchange, String routingKey, boolean mandatory, BasicProperties props, byte[] body)
         *      exchange: 交换机名称,简单模式下交换机会使用默认的
         *      routingKey: 路由的key
         *      props: 配置信息
         *      body: 发送的消息数据
         */
        String body = "hello rabbitmq...";
        channel.basicPublish("", "hello_world", null, body.getBytes());
        channel.close();
        connection.close();
    }
}
