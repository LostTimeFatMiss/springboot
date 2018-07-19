package com.sym.springboot.domain.entity;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 
 */
@Table(name = "sys_role_resource")
public class RoleResource extends Base<Long> {

    /**
     * 角色ID
     */
    private Long sysRoleId;

    /**
     * 资源ID
     */
    private Long sysResourceId;

    private static final long serialVersionUID = 1L;


    public Long getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(Long sysRoleId) {
        this.sysRoleId = sysRoleId;
    }

    public Long getSysResourceId() {
        return sysResourceId;
    }

    public void setSysResourceId(Long sysResourceId) {
        this.sysResourceId = sysResourceId;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(getId());
        sb.append(", sysRoleId=").append(sysRoleId);
        sb.append(", sysResourceId=").append(sysResourceId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}