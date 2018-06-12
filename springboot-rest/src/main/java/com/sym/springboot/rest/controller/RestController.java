package com.sym.springboot.rest.controller;

import com.alibaba.fastjson.JSON;
import com.sym.springboot.domain.Order;
import com.sym.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/6/11
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("test")
public class RestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private OrderService orderService;

    @Resource(name = "renrenJdbcTemp")
    private JdbcTemplate renrenjdbc;

    @GetMapping("/a")
    public Object a(){
        String sql = "SELECT mobile FROM `order` WHERE id = 1";
        String sql1 = " SELECT NAME FROM sys_menu WHERE  menu_id = 1 ";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql);
        Map<String, Object> map1 = renrenjdbc.queryForMap(sql1);
        Order order = orderService.get();

        /*return map.get("mobile").toString()+map1.get("name").toString();*/
        return JSON.toJSON(order);
    }
}
