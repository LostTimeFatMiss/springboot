package com.sym.springboot.erp.controller;

import com.sym.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/order",method = RequestMethod.GET)
    public String get(Model model){
        model.addAttribute("order",orderService.get());
        return "index";
    }
}
