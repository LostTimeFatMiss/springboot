package com.sym.springboot.provider;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/6/22
 */
public class OrderProvider {
    public String findOrderById(Integer id){
        return new SQL(){
            {
                SELECT("*");
                FROM(" `order` ");
                if(id!=null){
                    WHERE("id = #{id}");
                }
            }
        }.toString();
    }
}
