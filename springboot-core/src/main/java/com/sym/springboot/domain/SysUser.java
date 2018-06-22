package com.sym.springboot.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class SysUser extends Base<Long> implements Serializable {

    private String username;

    private String password;


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