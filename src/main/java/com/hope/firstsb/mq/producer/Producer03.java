package com.hope.firstsb.mq.producer;

import com.hope.firstsb.config.RabbitMqConfigDelay;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
@Slf4j
public class Producer03 {
    @Resource
    private RabbitTemplate rabbitTemplate;

    public void send(String tradeNo) {
        rabbitTemplate.convertAndSend(RabbitMqConfigDelay.ORDER_EXCHANGE, RabbitMqConfigDelay.ORDER_ROUTING_KEY, tradeNo, message -> {
            message.getMessageProperties().setDelay(10000);
            return message;
        });
    }
}