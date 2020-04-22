package com.hy.crmsystem.mrli.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author licheng
 * @date 2020/4/13 16:03
 */
@TableName(value = "sys_permission")
public class Permission {

    @TableId(value = "perid", type = IdType.AUTO)
    private Integer perid;

    @TableField(value = "pid")
    private Integer pid;

    @TableField(value = "pername")
    private String pername;

    @TableField(value = "percode")
    private String percode;

    @TableField(value = "purl")
    private String purl;

    @TableField(value = "ordernumber")
    private Integer ordernumber;

    @TableField(value = "ptype")
    private String ptype;

    @TableField(value = "available")
    private String available;


    public Integer getPerid() {
        return perid;
    }

    public void setPerid(Integer perid) {
        this.perid = perid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPername() {
        return pername;
    }

    public void setPername(String pername) {
        this.pername = pername;
    }

    public String getPercode() {
        return percode;
    }

    public void setPercode(String percode) {
        this.percode = percode;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }

    public Integer getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(Integer ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }
}
