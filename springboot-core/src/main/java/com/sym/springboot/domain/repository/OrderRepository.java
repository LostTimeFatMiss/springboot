package com.sym.springboot.domain.repository;

import com.sym.springboot.domain.entity.Order;
import com.sym.springboot.provider.OrderProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/6/12
 */
@Mapper
public interface OrderRepository {

    @Select("select * from `order` where id = #{id}")
    Order get(@Param("id") Integer id);

    @Select("select * from `order` ")
    List<Order> finAll();

    @SelectProvider(type = OrderProvider.class,method = "findOrderById")
    Order findOrderById( Integer id);
}
