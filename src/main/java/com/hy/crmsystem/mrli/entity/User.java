package com.hy.crmsystem.mrli.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键
     */
    private Integer userId;

    /**
     * 部门主键
     */
    private Integer deptid;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户职位
     */
    private String userjob;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserjob() {
        return userjob;
    }

    public void setUserjob(String userjob) {
        this.userjob = userjob;
    }

    @Override
    public String toString() {
        return "User{" +
        "userId=" + userId +
        ", deptid=" + deptid +
        ", userName=" + userName +
        ", userjob=" + userjob +
        "}";
    }
}
