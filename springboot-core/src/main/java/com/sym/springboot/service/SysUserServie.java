package com.sym.springboot.service;

import com.sym.springboot.domain.SysUser;
import com.sym.springboot.domain.SysUserResposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/6/22
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysUserServie {
    @Autowired
    private SysUserResposity sysUserResposity;

    public SysUser get() {
        return sysUserResposity.get(1L);
    }

    public SysUser getUser(String username) {
        return sysUserResposity.getUser(username);
    }

    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Integer register(SysUser sysUser) {
        sysUserResposity.register(sysUser);
        return sysUser.getId();
    }
}
