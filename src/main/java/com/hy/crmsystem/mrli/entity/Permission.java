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

    @TableField(value = "rolename")
    private String pername;

    @TableField(value = "rolename")
    private String percode;


    public Integer getPerid() {
        return perid;
    }

    public void setPerid(Integer perid) {
        this.perid = perid;
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
}
