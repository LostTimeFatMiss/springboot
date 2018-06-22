package com.sym.springboot.domain;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/6/22
 */
@Mapper
public interface SysUserResposity {
    @Select(" select * from sys_user where id = #{id}")
    SysUser get(@Param("id") Long id);
}
