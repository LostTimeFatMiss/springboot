package com.sym.springboot.domain.entity;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 
 */
@Table(name = "sys_user_role")
public class UserRole extends Base<Long> {

    /**
     * 用户ID
     */
    private Long sysUserId;

    /**
     * 角色ID
     */
    private Long sysRoleId;

    private static final long serialVersionUID = 1L;


    public Long getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Long getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(Long sysRoleId) {
        this.sysRoleId = sysRoleId;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(getId());
        sb.append(", sysUserId=").append(sysUserId);
        sb.append(", sysRoleId=").append(sysRoleId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}