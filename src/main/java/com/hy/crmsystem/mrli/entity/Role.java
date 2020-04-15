package com.hy.crmsystem.mrli.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 *@author licheng
 *@date 2020/4/12 15:59
 */
@TableName(value = "sys_role")
public class Role implements Serializable {
    @TableId(value = "roleid", type = IdType.AUTO)
    private Integer roleid;

    @TableField(value = "rolename")
    private String rolename;

    @TableField(value = "roledesc")
    private String roledesc;

    @TableField(value = "available")
    private Integer available;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }
}