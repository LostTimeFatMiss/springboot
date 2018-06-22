package com.sym.springboot.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class SysPermission extends Base<Long> implements Serializable {

    private String name;

    private String description;

    private String url;

    private Long pid;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }


}