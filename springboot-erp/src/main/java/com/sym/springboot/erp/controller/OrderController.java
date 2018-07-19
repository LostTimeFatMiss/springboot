package com.sym.springboot.erp.controller;

import com.sym.springboot.service.OrderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/6/13
 */
@RequestMapping("erp")
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;


    private Logger logger = LoggerFactory.getLogger(getClass());


    @RequestMapping(value = "/order",method = RequestMethod.GET)
    public String get(Model model){
        model.addAttribute("order",orderService.get());
        return "success";
    }
}
