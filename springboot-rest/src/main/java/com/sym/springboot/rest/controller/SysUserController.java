package com.sym.springboot.rest.controller;

import com.sym.springboot.domain.entity.User;
import com.sym.springboot.service.UserServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/6/22
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {

    @Autowired
    private UserServie userServie;

    @GetMapping("get")
    public User get(){
        return userServie.get();
    }

}
