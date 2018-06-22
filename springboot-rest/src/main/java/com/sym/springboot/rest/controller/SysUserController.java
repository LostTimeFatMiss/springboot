package com.sym.springboot.rest.controller;

import com.sym.springboot.domain.SysUser;
import com.sym.springboot.service.SysUserServie;
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
    private SysUserServie sysUserServie;

    @GetMapping("get")
    public SysUser get(){
        return sysUserServie.get();
    }

}
