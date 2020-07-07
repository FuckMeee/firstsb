package com.hope.firstsb.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig2 {
    public static final String ORDER_EXCHANGE = "my.exchange.order2";
    public static final String ORDER_QUEUE = "my.queue.order2";
    public static final String ORDER_ROUTING_KEY = "my.routing-key.order2";


    @Bean
    public DirectExchange orderExchange2() {
        return new DirectExchange(ORDER_EXCHANGE);
    }

    @Bean
    public Queue orderQueue2() {
        return new Queue(ORDER_QUEUE, true);
    }

    @Bean
    public Binding orderBinding2() {
        return BindingBuilder.bind(orderQueue2()).to(orderExchange2()).with(ORDER_ROUTING_KEY);
    }
}
