package com.hope.firstsb.mq.producer;

import com.hope.firstsb.config.RabbitMqConfig2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
public class Producer02 {
    @Resource
    private RabbitTemplate rabbitTemplate;

    public void send(int i) {
        String message = "hello2->" + i;
        this.rabbitTemplate.convertAndSend(RabbitMqConfig2.ORDER_EXCHANGE, RabbitMqConfig2.ORDER_ROUTING_KEY, message);
    }
}