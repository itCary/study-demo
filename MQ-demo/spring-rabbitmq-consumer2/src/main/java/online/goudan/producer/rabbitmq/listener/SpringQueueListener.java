package online.goudan.producer.rabbitmq.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @author chenglongliu
 * @date 2021/3/15 11:21
 * @desc SpringQueueListener
 */
public class SpringQueueListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("spring_queue," + new String(message.getBody()));
    }
}
