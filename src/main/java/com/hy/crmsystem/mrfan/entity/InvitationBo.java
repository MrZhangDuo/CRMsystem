package com.hy.crmsystem.mrfan.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InvitationBo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer invitationId;
    //商机外键
    private Integer busId;
    //帖子主题
    private String invitationSubject;
    //帖子标签
    private String invitationTag;
    //相关附件
    private String invitationFile;
    //帖子内容
    private String invitationContent;
    //帖子点击量
    private Integer invitationClick=0;
    //帖子回复量
    private Integer invitationReply=0;
    // 帖子发表日期
    private Date invitationTime;
    //帖子分类
    private String invitationType;
    //帖子作者
    private String invitationAuthor;
    //商机名称
    private String busName;
    //最后回复时间
    private Date reolyTime;
    private String zuihouTime;

    public String getZuihouTime() {
        if(reolyTime!=null){
            return  new SimpleDateFormat( "yyyy-MM-dd ").format(reolyTime);
        }else {
            return zuihouTime;
        }
    }

    public void setZuihouTime(String zuihouTime) {
        this.zuihouTime = zuihouTime;
    }

    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(Integer invitationId) {
        this.invitationId = invitationId;
    }

    public String getInvitationSubject() {
        return invitationSubject;
    }

    public void setInvitationSubject(String invitationSubject) {
        this.invitationSubject = invitationSubject;
    }

    public String getInvitationTag() {
        return invitationTag;
    }

    public void setInvitationTag(String invitationTag) {
        this.invitationTag = invitationTag;
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
}
