package online.goudan.producer.rabbitmq.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author chenglongliu
 * @date 2021/3/15 22:44
 * @desc 限流
 */
@Component
@Scope("prototype")
public class QosListener implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        System.out.println(Thread.currentThread().getName());
        System.out.println(new String(message.getBody()));

//        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
    }

}
