package com.hy.crmsystem.mrfan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
@TableName(value = "reolyinvitation")
public class Reolyinvitation implements Serializable {

    private static final long serialVersionUID = 1L;
    //回复主键
    @TableId(value = "reolyId",type = IdType.AUTO)
    private Integer reolyId;
    //帖子外键
    @TableField("invitationId")
    private  Integer invitationId;
    //回复人
    @TableField("reolyPeople")
    private String reolyPeople;
    //被回复人
    @TableField("quiltReolyPeople")
    private String quiltReolyPeople;
    //回复内容
    @TableField("reolyContent")
    private String reolyContent;
    //回复时间
    @TableField("reolyTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date reolyTime;
    @TableField("erreoly")
    private String erreoly;

    public String getErreoly() {
        return erreoly;
    }

    public void setErreoly(String erreoly) {
        this.erreoly = erreoly;
    }

    public Integer getReolyId() {
        return reolyId;
    }

    public void setReolyId(Integer reolyId) {
        this.reolyId = reolyId;
    }

    public Integer getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(Integer invitationId) {
        this.invitationId = invitationId;
    }

    public String getReolyPeople() {
        return reolyPeople;
    }

    public void setReolyPeople(String reolyPeople) {
        this.reolyPeople = reolyPeople;
    }

    public String getQuiltReolyPeople() {
        return quiltReolyPeople;
    }

    public void setQuiltReolyPeople(String quiltReolyPeople) {
        this.quiltReolyPeople = quiltReolyPeople;
    }

    public String getReolyContent() {
        return reolyContent;
    }

    public void setReolyContent(String reolyContent) {
        this.reolyContent = reolyContent;
    }

    public Date getReolyTime() {
        return reolyTime;
    }

    public void setReolyTime(Date reolyTime) {
        this.reolyTime = reolyTime;
    }

    @Override
    public String toString() {
        return "Reolyinvitation{" +
                "reolyId=" + reolyId +
                ", invitationId=" + invitationId +
                ", reolyPeople='" + reolyPeople + '\'' +
                ", quiltReolyPeople='" + quiltReolyPeople + '\'' +
                ", reolyContent='" + reolyContent + '\'' +
                ", reolyTime=" + reolyTime +
                '}';
    }
}
