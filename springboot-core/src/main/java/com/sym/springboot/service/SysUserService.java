package com.sym.springboot.service;

import com.sym.springboot.domain.entity.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/7/19
 */
@Service
public class SysUserService {

    /**
     * 获得当前登录用户信息
     * @return
     */
  public  User current(){
        return (User) SecurityUtils.getSubject().getPrincipal();
    }
}
