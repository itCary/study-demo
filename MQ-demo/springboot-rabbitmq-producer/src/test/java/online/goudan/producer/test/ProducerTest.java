package online.goudan.producer.test;

import online.goudan.producer.rabbitmq.config.RabbitMQConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chenglongliu
 * @date 2021/3/15 16:20
 * @desc online.goudan.test.ProducerTest
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProducerTest {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    @Test
    public void testSend() {
        while (true) {
            System.out.println(queue.getName());
            rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, "boot.ere", "boot.afa ....");
        }
    }

}
