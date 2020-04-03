package com.hy.crmsystem.mrfan.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
@TableName(value = "dept")
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门主键
     */
    @TableId(value = "deptid")
    private Integer deptid;

    /**
     * 部门名称
     */
    private String deptname;


    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }
    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }


    @Override
    public String toString() {
        return "Dept{" +
        "deptid=" + deptid +
        ", deptname=" + deptname +
        "}";
    }
}
