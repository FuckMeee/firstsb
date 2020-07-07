package com.hope.firstsb.mq.consumer;

import com.hope.firstsb.config.RabbitMqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RabbitListener(queues = RabbitMqConfig.ORDER_QUEUE)
public class Consumer01 {
    @RabbitHandler
    public void process(String message) {
        log.info("消费者1收到消息：{}", message);
    }
}
