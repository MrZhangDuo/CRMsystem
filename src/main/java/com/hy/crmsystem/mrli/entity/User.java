package com.hy.crmsystem.mrli.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("sys_user")
public class User implements Serializable {


    /**
     * 用户主键
     */
    @TableField(value = "userid")
    private Integer userid;


    /**
     * 登录名  *注意：是登陆的名字
     */
    @TableField(value = "loginname")
    private String loginname;

    /**
     * 身份证号
     */
    @TableField(value = "identity")
    private String identity;

    /**
     * 真实姓名
     */
    @TableField(value = "realname")
    private String realname;

    /**
     * 性别
     */
    @TableField(value = "sex")
    private Integer sex;

    /**
     * 地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 手机号码
     *
     * @return
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 密码
     *
     * @return
     */
    @TableField(value = "pwd")
    private String pwd;

    /**
     * 职位
     *
     * @return
     */
    @TableField(value = "position")
    private String position;

    /**
     * 类型
     *
     * @return
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 是否可用
     *
     * @return
     */
    @TableField(value = "available")
    private Integer available;


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }
}
