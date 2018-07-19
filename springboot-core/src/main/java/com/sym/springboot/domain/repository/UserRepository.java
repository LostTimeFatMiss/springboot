package com.sym.springboot.domain.repository;

import com.sym.springboot.domain.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/6/22
 */
@Mapper
public interface UserRepository {
    @Select(" select * from sys_user where id = #{id}")
    User get(@Param("id") Long id);

    @Select(" select * from sys_user where username = #{username}")
    User getUser(@Param("username") String username);

    @Insert(" INSERT INTO springboot.sys_user ( username, PASSWORD, salt, status) VALUES(#{username}, #{password}, #{salt}, #{status})")
    @Options(useGeneratedKeys = true,keyColumn = "id")
    void register(User sysUser);
}
