package online.goudan.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
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
    public void testHelloWorld() {
        rabbitTemplate.convertAndSend("spring_queue", "hello world spring......");
    }

    @Test
    public void testFanout() {
        rabbitTemplate.convertAndSend("spring_fanout_exchange", "", "fanout ......");
    }

    @Test
    public void testTopic() {
        rabbitTemplate.convertAndSend("spring_topic_exchange", "goudan.dd", "goudan.dd....");
        rabbitTemplate.convertAndSend("spring_topic_exchange", "goudan.dd.aa", "goudan.dd.aa....");
        rabbitTemplate.convertAndSend("spring_topic_exchange", "goudan.dd.aa", "goudan.dd.aa....");
        rabbitTemplate.convertAndSend("spring_topic_exchange", "goudan.dd.aa", "goudan.dd.aa....");
        rabbitTemplate.convertAndSend("spring_topic_exchange", "piaoxianglou.dd.aa", "goudan.dd.aa....");

    }

}
