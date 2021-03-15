package online.goudan.producer.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenglongliu
 * @date 2021/3/15 16:08
 * @desc rabbitmq的配置
 */
@Configuration
public class RabbitMQConfig {

    public final static String EXCHANGE_NAME = "test_topic_exchange";
    public final static String QUEUE_NAME = "test_topic_queue";

    @Bean("exchange")
    public Exchange createExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME)
                .durable(true)
                .build();
    }

    @Bean("queue1")
    public Queue createQueue() {
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    @Bean
    public Binding bindingExchangAndQueue(@Qualifier("queue1") Queue queue, @Qualifier("exchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("boot.*").noargs();
    }
}
