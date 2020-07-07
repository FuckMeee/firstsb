package com.hope.firstsb.mq.consumer;

import com.hope.firstsb.config.RabbitMqConfigDelay;
import com.hope.firstsb.dao.OrderMapper;
import com.hope.firstsb.domain.po.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
@RabbitListener(queues = RabbitMqConfigDelay.ORDER_QUEUE)
public class Consumer03 {
    @Autowired
    private OrderMapper orderMapper;
    @RabbitHandler
    public void process(String tradeNo) {
        log.info("消费者3收到消息：{}, {}", tradeNo, new Date());
        Order order = new Order();
        order.setStatus(1);
        order.setTradeNo(tradeNo);
        int res = orderMapper.updateByTradeNoSelective(order);
        log.info("消费者3收到消息：{}", res);
    }
}
