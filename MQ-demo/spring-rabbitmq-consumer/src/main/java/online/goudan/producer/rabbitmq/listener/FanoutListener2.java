package online.goudan.producer.rabbitmq.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @author chenglongliu
 * @date 2021/3/15 11:23
 * @desc FanoutListener2
 */
public class FanoutListener2 implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("fanout2," + new String(message.getBody()));
    }
}
