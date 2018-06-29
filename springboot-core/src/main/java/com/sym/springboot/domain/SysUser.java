package com.sym.springboot.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class SysUser extends Base<Integer> implements Serializable {

    private String username;

    private String password;

    private String salt;

    private Boolean enabled;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}