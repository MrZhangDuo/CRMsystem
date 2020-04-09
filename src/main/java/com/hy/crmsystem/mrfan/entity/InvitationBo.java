package com.hy.crmsystem.mrfan.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InvitationBo implements Serializable {
        private static final long serialVersionUID = 1L;
        //帖子主键
        private Integer InvitationId;
        //回复主键
        private Integer ReolyId;
        //帖子标签
        private String InvitationTag;
        //帖子主题
        private String InvitationSubject;
        //相关附件
        private String InvitationFile;
        //帖子内容
        private String InvitationContent;
        //帖子点击量
        private Integer InvitationClick;
        //帖子回复量
        private Integer InvitationReply;
        // 帖子发表日期
        @DateTimeFormat(pattern="yyyy-MM-dd")
        private Date InvitationTime;
        @TableField(exist = false)
        private String fabiaoTime;

        //帖子作者
        private String Invitationauthor;
        //所属商机
        private String BusName;
        //最后回复日期
        @DateTimeFormat(pattern="yyyy-MM-dd")
        private Date ReolyTime;
        @TableField(exist = false)
        private String zuihouTime;

        //帖子分类
        private String Invitationclassification;

    public String getFabiaoTime() {
        if(InvitationTime!=null){
            return  new SimpleDateFormat( "yyyy-MM-dd").format(InvitationTime);
        }else {
            return fabiaoTime;
        }
    }

    public void setFabiaoTime(String fabiaoTime) {
        this.fabiaoTime = fabiaoTime;
    }

    public String getZuihouTime() {
        if(ReolyTime!=null){
            return  new SimpleDateFormat( "yyyy-MM-dd").format(ReolyTime);
        }else {
            return zuihouTime;
        }
    }

    public String getInvitationclassification() {
        return Invitationclassification;
    }

    public void setInvitationclassification(String invitationclassification) {
        Invitationclassification = invitationclassification;
    }

    public void setZuihouTime(String zuihouTime) {
        this.zuihouTime = zuihouTime;
    }

    public Integer getInvitationId() {
        return InvitationId;
    }

    public void setInvitationId(Integer invitationId) {
        InvitationId = invitationId;
    }

    public Integer getReolyId() {
        return ReolyId;
    }

    public void setReolyId(Integer reolyId) {
        ReolyId = reolyId;
    }

    public String getInvitationTag() {
        return InvitationTag;
    }

    public void setInvitationTag(String invitationTag) {
        InvitationTag = invitationTag;
    }

    public String getInvitationSubject() {
        return InvitationSubject;
    }

    public void setInvitationSubject(String invitationSubject) {
        InvitationSubject = invitationSubject;
    }

    public String getInvitationFile() {
        return InvitationFile;
    }

    public void setInvitationFile(String invitationFile) {
        InvitationFile = invitationFile;
    }

    public String getInvitationContent() {
        return InvitationContent;
    }

    public void setInvitationContent(String invitationContent) {
        InvitationContent = invitationContent;
    }

    public Integer getInvitationClick() {
        return InvitationClick;
    }

    public void setInvitationClick(Integer invitationClick) {
        InvitationClick = invitationClick;
    }

    public Integer getInvitationReply() {
        return InvitationReply;
    }

    public void setInvitationReply(Integer invitationReply) {
        InvitationReply = invitationReply;
    }

    public Date getInvitationTime() {
        return InvitationTime;
    }

    public void setInvitationTime(Date invitationTime) {
        InvitationTime = invitationTime;
    }

    public String getInvitationauthor() {
        return Invitationauthor;
    }

    public void setInvitationauthor(String invitationauthor) {
        Invitationauthor = invitationauthor;
    }

    public String getBusName() {
        return BusName;
    }

    public void setBusName(String busName) {
        BusName = busName;
    }

    public Date getReolyTime() {
        return ReolyTime;
    }

    public void setReolyTime(Date reolyTime) {
        ReolyTime = reolyTime;
    }


    @Override
    public String toString() {
        return "InvitationBo{" +
                "InvitationId=" + InvitationId +
                ", ReolyId=" + ReolyId +
                ", InvitationTag='" + InvitationTag + '\'' +
                ", InvitationSubject='" + InvitationSubject + '\'' +
                ", InvitationFile='" + InvitationFile + '\'' +
                ", InvitationContent='" + InvitationContent + '\'' +
                ", InvitationClick=" + InvitationClick +
                ", InvitationReply=" + InvitationReply +
                ", InvitationTime=" + InvitationTime +
                ", fabiaoTime='" + fabiaoTime + '\'' +
                ", Invitationauthor='" + Invitationauthor + '\'' +
                ", BusName='" + BusName + '\'' +
                ", ReolyTime=" + ReolyTime +
                ", zuihouTime='" + zuihouTime + '\'' +
                ", Invitationclassification='" + Invitationclassification + '\'' +
                '}';
    }
}
