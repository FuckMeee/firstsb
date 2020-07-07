package com.hope.firstsb.dao;

import com.hope.firstsb.domain.po.Order;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectOrderList();

    Order selectByTradeNo(String tradeNo);

    int updateByTradeNoSelective(Order order);
}