package com.hope.firstsb.service.impl;

import com.hope.firstsb.dao.OrderMapper;
import com.hope.firstsb.domain.po.Order;
import com.hope.firstsb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order getOrderById(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public Order getOrderByTradeNo(String tradeNo) {
        return orderMapper.selectByTradeNo(tradeNo);
    }

    @Override
    public int createOrder(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public List<Order> getOrderList() {
        return orderMapper.selectOrderList();
    }
}
