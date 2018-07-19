package com.sym.springboot.erp.controller;

import com.sym.springboot.domain.entity.Resource;
import com.sym.springboot.domain.entity.User;
import com.sym.springboot.service.OrderService;
import com.sym.springboot.service.ResourceService;
import com.sym.springboot.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ResourceService resourceService;

    private Logger logger = LoggerFactory.getLogger(getClass());


    @RequestMapping(value = "/order",method = RequestMethod.GET)
    @RequiresPermissions(value = "index")
    public String get(Model model){
        User current = sysUserService.current();
        Subject subject = SecurityUtils.getSubject();
        System.out.println("权限");
        List<Resource> resource = resourceService.getResource(current);
        model.addAttribute("order",orderService.get());
        return "success";
    }

    @RequestMapping(value = "/order1",method = RequestMethod.GET)
    @RequiresPermissions(value = "inde")
    public String get1(Model model){
        User current = sysUserService.current();
        Subject subject = SecurityUtils.getSubject();
        System.out.println("权限");
        List<Resource> resource = resourceService.getResource(current);
        model.addAttribute("order",orderService.get());
        return "success";
    }
}
