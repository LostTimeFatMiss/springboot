package com.sym.springboot.domain;

import java.util.Date;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/6/12
 */
public class Order extends Base<Integer>{


    private String mobile;

    private Integer goodsId;

    private Integer num;

    private Date createTime;

    private Boolean delFlag;


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
}
