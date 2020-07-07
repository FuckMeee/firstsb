package com.hope.firstsb.mq.producer;

import com.hope.firstsb.config.RabbitMqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
public class Producer01 {
    @Resource
    private RabbitTemplate rabbitTemplate;

    public void send(int i) {
        String message = "hello->" + i;
        this.rabbitTemplate.convertAndSend(RabbitMqConfig.ORDER_EXCHANGE, RabbitMqConfig.ORDER_ROUTING_KEY, message);
    }
}