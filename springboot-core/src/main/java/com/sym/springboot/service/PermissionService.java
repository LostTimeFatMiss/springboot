package com.sym.springboot.service;

import com.sym.springboot.domain.SysPermissionResposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/6/29
 */
@Service
public class PermissionService {
    @Autowired
    private SysPermissionResposity sysPermissionResposity;

    public List<String> getResource(int id){

        return sysPermissionResposity.getResource(id);
    }

}
