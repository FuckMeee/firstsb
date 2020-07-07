package com.hope.firstsb.service;

import com.hope.firstsb.domain.po.Order;

import java.util.List;

public interface OrderService {
    Order getOrderById(Integer id);

    Order getOrderByTradeNo(String tradeNo);

    int createOrder(Order order);

    List<Order> getOrderList();
}
