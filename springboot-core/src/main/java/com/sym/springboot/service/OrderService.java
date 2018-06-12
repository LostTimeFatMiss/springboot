package com.sym.springboot.service;

import com.sym.springboot.domain.Order;
import com.sym.springboot.domain.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/6/12
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order get(){
        Order order = orderRepository.get(1);
        return order;
    }
}
