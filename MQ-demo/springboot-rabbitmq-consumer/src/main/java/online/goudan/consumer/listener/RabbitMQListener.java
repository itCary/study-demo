package online.goudan.consumer.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author chenglongliu
 * @date 2021/3/15 16:41
 * @desc RabbitMQListener
 */
@Component
public class RabbitMQListener {

    @RabbitListener(queues = "test_topic_queue")
    public void listenerQueue(Message message) {
        System.out.println(new String(message.getBody()));
    }
}
