package com.sym.springboot.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class SysRoleUser extends Base<Long> implements Serializable {

    private Long sysUserId;

    private Long sysRoleId;



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


}