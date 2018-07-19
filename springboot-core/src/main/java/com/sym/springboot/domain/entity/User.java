package com.sym.springboot.domain.entity;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
@Table(name = "sys_user")
public class User extends Base<Long> {


    /**
     * 鐢ㄦ埛鍚?
     */
    private String username;

    /**
     * 鎵嬫満鍙风爜
     */
    private String phone;

    /**
     * 閭
     */
    private String email;

    /**
     * 瀵嗙爜
     */
    private String password;

    /**
     * 瀵嗙爜鐩?
     */
    private String salt;

    /**
     * 鐢ㄦ埛鐘舵??
     */
    private Integer status;

    /**
     * 鍒涘缓浜篒D
     */
    private Long creatorId;

    /**
     * 鍒涘缓鏃堕棿
     */
    private Date createdTime;

    /**
     * 淇敼浜篒D
     */
    private Long modifierId;

    /**
     * 淇敼鏃堕棿
     */
    private Date modifiedTime;

    private static final long serialVersionUID = 1L;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getModifierId() {
        return modifierId;
    }

    public void setModifierId(Long modifierId) {
        this.modifierId = modifierId;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(getId());
        sb.append(", username=").append(username);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", password=").append(password);
        sb.append(", salt=").append(salt);
        sb.append(", status=").append(status);
        sb.append(", creatorId=").append(creatorId);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierId=").append(modifierId);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}