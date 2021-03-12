package online.goudan.producer.work_queue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import online.goudan.util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author chenglongliu
 * @date 2021/3/12 15:57
 * @desc 工作队列模式的生产者
 */
public class Producer_WorkQueue {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        String queueName = "work_queues";
        channel.queueDeclare(queueName, true, false, false, null);
        String body = "work queue .....";
        for (int i = 0; i < 100; i++) {
            channel.basicPublish("", queueName, null, (i + body).getBytes());
        }
        channel.close();
        connection.close();
    }
}
