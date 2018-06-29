package com.sym.springboot.domain;

import org.apache.ibatis.annotations.*;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/6/22
 */
@Mapper
public interface SysUserResposity {
    @Select(" select * from sys_user where id = #{id}")
    SysUser get(@Param("id") Long id);

    @Select(" select * from sys_user where username = #{username}")
    SysUser getUser(@Param("username") String username);

    @Insert(" insert into  sys_user ")
    @Options
    SysUser register(@Param("username") String username);
}
