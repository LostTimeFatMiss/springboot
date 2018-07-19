package com.sym.springboot.domain.entity;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
@Table(name = "sys_resource")
public class Resource extends Base<Long> {

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源代码
     */
    private String code;

    /**
     * 资源URL
     */
    private String url;

    /**
     * 资源配置
     */
    private String config;

    /**
     * 资源类型
     */
    private Integer type;

    /**
     * 组织状�??
     */
    private Integer status;

    /**
     * 上级资源
     */
    private Long parentId;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 创建人ID
     */
    private Long creatorId;

    /**
     * 修改时间
     */
    private Date modifiedTime;

    /**
     * 修改人Id
     */
    private Long modifierId;

    /**
     * 排列序号
     */
    private Integer orderNumber;

    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Long getModifierId() {
        return modifierId;
    }

    public void setModifierId(Long modifierId) {
        this.modifierId = modifierId;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(getId());
        sb.append(", name=").append(name);
        sb.append(", code=").append(code);
        sb.append(", url=").append(url);
        sb.append(", config=").append(config);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", parentId=").append(parentId);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", creatorId=").append(creatorId);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", modifierId=").append(modifierId);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}