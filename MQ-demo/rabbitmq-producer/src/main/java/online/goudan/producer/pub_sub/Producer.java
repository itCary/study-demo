package online.goudan.producer.pub_sub;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import online.goudan.util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author chenglongliu
 * @date 2021/3/12 16:41
 * @desc PubSub模式的生产者
 */
public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        String exchangeName = "test_fanout";
        /**
         * exchangeDeclare(String exchange,BuiltinExchangeType type,boolean durable,boolean autoDelete,boolean internal,Map<String, Object> arguments)
         *
         * exchange: 交换机名称
         * type: 交换机类型
         *      DIRECT("direct"), FANOUT("fanout"), TOPIC("topic"), HEADERS("headers");
         *      direct: 定向
         *      fanout: 扇形(广播)
         *      topic: 通配符
         *      headers: 参数匹配
         * durable: 是否持久化
         * autoDelete: 自动删除
         * internal: 内部使用
         * arguments: 参数
         */
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.FANOUT, true, false, false, null);

        String queueName1 = "test_fanout_queue1";
        String queueName2 = "test_fanout_queue2";
        channel.queueDeclare(queueName1, true, false, false, null);
        channel.queueDeclare(queueName2, true, false, false, null);
        /**
         * queueBind(String queue, String exchange, String routingKey)
         *
         * queue: 要绑定的当前队列的名称
         * exchange: 交换机名称
         * routingKey: 绑定规则
         */
        channel.queueBind(queueName1, exchangeName, "");
        channel.queueBind(queueName2, exchangeName, "");

        String body = "日志信息:xxx调用了find()方法。。。日志级别:info....";
        channel.basicPublish(exchangeName, "", null, body.getBytes());
        channel.close();
        connection.close();
    }

}
