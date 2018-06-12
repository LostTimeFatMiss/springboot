package com.sym.springboot.domain;

import com.sun.tools.corba.se.idl.constExpr.Or;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/6/12
 */
@Mapper
public interface OrderRepository {

    @Select("select * from `order` where id = #{id}")
    Order get(@Param("id") Integer id);
}
