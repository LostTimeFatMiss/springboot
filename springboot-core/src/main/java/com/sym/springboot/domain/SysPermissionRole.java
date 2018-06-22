package com.sym.springboot.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class SysPermissionRole extends Base<Long> implements Serializable {

    private Long roleId;

    private Long permissionId;




    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }


}