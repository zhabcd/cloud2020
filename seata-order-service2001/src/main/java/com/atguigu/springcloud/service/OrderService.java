package com.atguigu.springcloud.service;


import com.atguigu.springcloud.entities.Order;

/**
 * @Author EiletXie
 * @Since 2020/3/18 21:17
 */
public interface OrderService {

    /**
     * 创建订单
     * @param order
     */
    void create(Order order);
}