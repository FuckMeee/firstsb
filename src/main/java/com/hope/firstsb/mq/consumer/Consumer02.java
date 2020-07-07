package com.hope.firstsb.mq.consumer;

import com.hope.firstsb.config.RabbitMqConfig2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RabbitListener(queues = RabbitMqConfig2.ORDER_QUEUE)
public class Consumer02 {
    @RabbitHandler
    public void process(String message) {
        log.info("消费者2收到消息：{}", message);
    }
}
