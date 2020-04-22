package com.hy.crmsystem.mrpan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName()
public class AddUserEntity {
     @TableId(value = "userid", type = IdType.AUTO)
     private Integer userid;
     private String loginname;
     private String identity;
     private String realname;
     private Integer sex;
     private String address;
     private String phone;
     private String pwd;
     private String position;
     private Integer type;
     private Integer available;
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

     @Override
     public String toString() {
          return "AddUserEntity{" +
                  "userid=" + userid +
                  ", loginname='" + loginname + '\'' +
                  ", identity='" + identity + '\'' +
                  ", realname='" + realname + '\'' +
                  ", sex=" + sex +
                  ", address='" + address + '\'' +
                  ", phone='" + phone + '\'' +
                  ", pwd='" + pwd + '\'' +
                  ", position='" + position + '\'' +
                  ", type=" + type +
                  ", available=" + available +
                  ", userimg='" + userimg + '\'' +
                  '}';
     }
}
