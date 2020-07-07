package com.hope.firstsb.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMqConfigDelay {
    public static final String ORDER_EXCHANGE = "my.delay.exchange.order";
    public static final String ORDER_QUEUE = "my.delay.queue.order";
    public static final String ORDER_ROUTING_KEY = "my.delay.routing-key.order";


    @Bean
    public CustomExchange orderDelayExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        // 参数二为类型：必须是x-delayed-message
        return new CustomExchange(ORDER_EXCHANGE, "x-delayed-message", true, false, args);
    }

    @Bean
    public Queue orderDelayQueue() {
        return new Queue(ORDER_QUEUE, true);
    }

    @Bean
    public Binding orderDelayBinding() {
        return BindingBuilder.bind(orderDelayQueue()).to(orderDelayExchange()).with(ORDER_ROUTING_KEY).noargs();
    }
}
