package online.goudan.producer.rabbitmq.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @author chenglongliu
 * @date 2021/3/15 11:23
 * @desc FanoutListener1
 */
public class FanoutListener1 implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("fanout1," + new String(message.getBody()));

    }
}
