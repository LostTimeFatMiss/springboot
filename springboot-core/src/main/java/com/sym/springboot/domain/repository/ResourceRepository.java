package com.sym.springboot.domain.repository;

import com.sym.springboot.domain.entity.Resource;
import com.sym.springboot.domain.entity.User;
import com.sym.springboot.provider.PermissionProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/6/22
 */
@Mapper
public interface ResourceRepository {
    @SelectProvider(type = PermissionProvider.class,method = "getResource")
    List<Resource> getResource(User user);
}
