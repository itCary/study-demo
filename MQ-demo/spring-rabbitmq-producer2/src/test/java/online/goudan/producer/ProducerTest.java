package online.goudan.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.ReceiveAndReplyCallback;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chenglongliu
 * @date 2021/3/15 11:07
 * @desc 生产者的Test
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:spring-rabbitmq-producer.xml")
public class ProducerTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Test
    public void testConfirm() {
        /**
         * 确认模式：
         * 步骤：
         *  1.确认模式开启:connectionFactory中开启
         *  2.在rabbittemplate中设置回调函数
         */

        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            /**
             *
             * @param correlationData
             * @param ack 交换机是否收到消息
             * @param cause 失败原因，ack 为 true 时为null
             */
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                System.out.println(ack ? "发送成功" : cause);
            }
        });
        for (int i = 0; i < Integer.MAX_VALUE; i++) {

            rabbitTemplate.convertAndSend("test_exchange_confirm", "confirm", i + "confirm...");
        }
    }

    @Test
    public void testReturn() {
        /**
         * 回退模式：
         * 步骤：
         *  1.回退模式开启:connectionFactory中开启
         *  2.在rabbittemplate中设置回调函数
         */

        //交换机-》queue失败，将消息返回给生产者
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            /**
             *
             * @param message 消息对象
             * @param replyCode 错误码
             * @param replyText 错误信息
             * @param exchange
             * @param routingKey
             */
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println(new String(message.getBody()));
                System.out.println(replyCode);
                System.out.println(replyText);
                System.out.println(exchange);
                System.out.println(routingKey);
            }
        });

        rabbitTemplate.convertAndSend("test_exchange_confirm", "confirm", "confirm...");
    }
}
