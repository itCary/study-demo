package online.goudan.consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chenglongliu
 * @date 2021/3/15 11:25
 * @desc ConsumerTest
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:spring-rabbitmq-consumer.xml")
public class ConsumerTest {


    @Test
    public void testSpringQueue() {
        while (true) {

        }
    }
}
