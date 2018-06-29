package com.sym.springboot.provider;

import com.sym.springboot.domain.SysUser;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/6/29
 */
public class PermissionProvider {
    public String getResource(int id){
        return new SQL(){
            {
                SELECT("p.url");
                FROM("sys_user u ");
                INNER_JOIN("sys_role_user ru ON ru.sys_user_id = u.id ");
                INNER_JOIN("sys_permission_role spr ON spr.role_id = ru.sys_role_id ");
                INNER_JOIN("sys_permission p ON p.id = spr.permission_id");
                WHERE("id=#{id}");
            }
        }.toString();
    }
}
