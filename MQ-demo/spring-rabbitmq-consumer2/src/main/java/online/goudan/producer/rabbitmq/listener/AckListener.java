package online.goudan.producer.rabbitmq.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * @author chenglongliu
 * @date 2021/3/15 22:44
 * @desc AckListener
 */
@Component
public class AckListener implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        System.out.println(new String(message.getBody()));
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        /**
         * basicAck(long deliveryTag, boolean multiple)
         */
        channel.basicAck(deliveryTag,true);

        /**
         * basicNack(long deliveryTag, boolean multiple, boolean requeue)
         * requeue: 重回队列
         */
        channel.basicNack(deliveryTag,true,true);

    }

}
