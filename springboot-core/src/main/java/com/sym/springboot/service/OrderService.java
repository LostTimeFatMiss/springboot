package com.sym.springboot.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sym.springboot.domain.entity.Order;
import com.sym.springboot.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/6/12
 */
@Service
@Transactional(readOnly = true,rollbackFor = Exception.class)
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order get(){
        Order order = orderRepository.get(1);
        return order;
    }

    public List<Order> findAll(){
        //分页
        Page<Order> page = PageHelper.startPage(0, 5);
        List<Order> orders = orderRepository.finAll();
        return orders;
    }

    public Order findOrderById(){
        Order order = orderRepository.findOrderById(1);
        return order;
    }
}
