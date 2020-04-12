package com.hy.crmsystem.mrfan.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class InvitationBo implements Serializable {
        private static final long serialVersionUID = 1L;
        //帖子主键
        private Integer invitationId;
        //回复主键
        private Integer reolyId;
        //帖子标签
        private String invitationTag;
        //帖子主题
        private String invitationSubject;
        //相关附件
        private String invitationFile;
        //帖子内容
        private String invitationContent;
        //帖子点击量
        private Integer invitationClick;
        //帖子回复量
        private Integer invitationReply;
        // 帖子发表日期
        @DateTimeFormat(pattern="yyyy-MM-dd")
        private Date invitationTime;
        @TableField(exist = false)
        private String fabiaoTime;
        //帖子分类
        private String invitationType;
        //帖子作者
        private String invitationAuthor;
        //所属商机
        private String busName;
        //最后回复日期
        @DateTimeFormat(pattern="yyyy-MM-dd")
        private Date reolyTime;
        @TableField(exist = false)
        private String zuihouTime;

    public Integer getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(Integer invitationId) {
        this.invitationId = invitationId;
    }

    public Integer getReolyId() {
        return reolyId;
    }

    public void setReolyId(Integer reolyId) {
        this.reolyId = reolyId;
    }

    public String getInvitationTag() {
        return invitationTag;
    }

    public void setInvitationTag(String invitationTag) {
        this.invitationTag = invitationTag;
    }

    public String getInvitationSubject() {
        return invitationSubject;
    }

    public void setInvitationSubject(String invitationSubject) {
        this.invitationSubject = invitationSubject;
    }

    public String getInvitationFile() {
        return invitationFile;
    }

    public void setInvitationFile(String invitationFile) {
        this.invitationFile = invitationFile;
    }

    public String getInvitationContent() {
        return invitationContent;
    }

    public void setInvitationContent(String invitationContent) {
        this.invitationContent = invitationContent;
    }

    public Integer getInvitationClick() {
        return invitationClick;
    }

    public void setInvitationClick(Integer invitationClick) {
        this.invitationClick = invitationClick;
    }

    public Integer getInvitationReply() {
        return invitationReply;
    }

    public void setInvitationReply(Integer invitationReply) {
        this.invitationReply = invitationReply;
    }

    public Date getInvitationTime() {
        return invitationTime;
    }

    public void setInvitationTime(Date invitationTime) {
        this.invitationTime = invitationTime;
    }

    public String getFabiaoTime() {
        return fabiaoTime;
    }

    public void setFabiaoTime(String fabiaoTime) {
        this.fabiaoTime = fabiaoTime;
    }

    public String getInvitationType() {
        return invitationType;
    }

    public void setInvitationType(String invitationType) {
        this.invitationType = invitationType;
    }

    public String getInvitationAuthor() {
        return invitationAuthor;
    }

    public void setInvitationAuthor(String invitationAuthor) {
        this.invitationAuthor = invitationAuthor;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public Date getReolyTime() {
        return reolyTime;
    }

    public void setReolyTime(Date reolyTime) {
        this.reolyTime = reolyTime;
    }

    public String getZuihouTime() {
        return zuihouTime;
    }

    public void setZuihouTime(String zuihouTime) {
        this.zuihouTime = zuihouTime;
    }

    @Override
    public String toString() {
        return "InvitationBo{" +
                "invitationId=" + invitationId +
                ", reolyId=" + reolyId +
                ", invitationTag='" + invitationTag + '\'' +
                ", invitationSubject='" + invitationSubject + '\'' +
                ", invitationFile='" + invitationFile + '\'' +
                ", invitationContent='" + invitationContent + '\'' +
                ", invitationClick=" + invitationClick +
                ", invitationReply=" + invitationReply +
                ", invitationTime=" + invitationTime +
                ", fabiaoTime='" + fabiaoTime + '\'' +
                ", invitationType='" + invitationType + '\'' +
                ", invitationAuthor='" + invitationAuthor + '\'' +
                ", busName='" + busName + '\'' +
                ", reolyTime=" + reolyTime +
                ", zuihouTime='" + zuihouTime + '\'' +
                '}';
    }
}
