package com.sym.springboot.provider;

import com.sym.springboot.domain.entity.User;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/6/29
 */
public class PermissionProvider {
    public String getResource(final User user){
        return new SQL(){
            {
                SELECT(" re.`code`,re.url ");
                FROM(" sys_user u ");
                INNER_JOIN("sys_user_role ur on u.id = ur.sys_user_id ");
                INNER_JOIN("sys_role_resource srr on ur.sys_role_id = srr.sys_role_id ");
                INNER_JOIN("sys_resource re on re.id = srr.sys_resource_id");
                WHERE("u.id=#{id}");
            }
        }.toString();
    }
}
