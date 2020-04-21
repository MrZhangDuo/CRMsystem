package com.hy.crmsystem.mrli.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("sys_user")
public class User implements Serializable {


    /**
     * 用户主键
     */
    @TableId(type = IdType.AUTO ,value="userid")
    private Integer userid;


    /**
     * 登录名  *注意：是登陆的名字
     */
    @TableField("loginname")
    private String loginname;

    /**
     * 身份证号
     */
    @TableField("identity")
    private String identity;

    /**
     * 真实姓名
     */
    @TableField("realname")
    private String realname;

    /**
     * 性别
     */
    @TableField("sex")
    private Integer sex;

    /**
     * 地址
     */
    @TableField("address")
    private String address;

    /**
     * 手机号码
     *
     * @return
     */
    @TableField("phone")
    private String phone;

    /**
     * 密码
     *
     * @return
     */
    @TableField("pwd")
    private String pwd;

    /**
     * 职位
     *
     * @return
     */
    @TableField("position")
    private String position;

    /**
     * 类型
     *
     * @return
     */
    @TableField("type")
    private Integer type;

    /**
     * 是否可用
     *
     * @return
     */
    @TableField("available")
    private Integer available;
    @TableField("userimg")
    private String userimg;

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

    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg;
    }


}
