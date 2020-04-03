package com.hy.crmsystem.mrfan.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;


import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
@TableName("invitation")
public class Invitation implements Serializable {
    private static final long serialVersionUID = 1L;
    //帖子主键
    @TableId(value = "InvitationId")
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
    // 帖子回复日期
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date InvitationTime;

    public Integer getInvitationId() {
        return InvitationId;
    }

    public void setInvitationId(Integer InvitationId) {
        this.InvitationId = InvitationId;
    }
    public Integer getReolyId() {
        return ReolyId;
    }

    public void setReolyId(Integer ReolyId) {
        this.ReolyId = ReolyId;
    }
    public String getInvitationTag() {
        return InvitationTag;
    }

    public void setInvitationTag(String InvitationTag) {
        this.InvitationTag = InvitationTag;
    }
    public String getInvitationSubject() {
        return InvitationSubject;
    }

    public void setInvitationSubject(String InvitationSubject) {
        this.InvitationSubject = InvitationSubject;
    }
    public String getInvitationFile() {
        return InvitationFile;
    }

    public void setInvitationFile(String InvitationFile) {
        this.InvitationFile = InvitationFile;
    }
    public String getInvitationContent() {
        return InvitationContent;
    }

    public void setInvitationContent(String InvitationContent) {
        this.InvitationContent = InvitationContent;
    }
    public Integer getInvitationClick() {
        return InvitationClick;
    }

    public void setInvitationClick(Integer InvitationClick) {
        this.InvitationClick = InvitationClick;
    }
    public Integer getInvitationReply() {
        return InvitationReply;
    }

    public void setInvitationReply(Integer InvitationReply) {
        this.InvitationReply = InvitationReply;
    }

    public Date getInvitationTime() {
        return InvitationTime;
    }

    public void setInvitationTime(Date invitationTime) {
        InvitationTime = invitationTime;
    }

    @Override
    public String toString() {
        return "Invitation{" +
        "InvitationId=" + InvitationId +
        ", ReolyId=" + ReolyId +
        ", InvitationTag=" + InvitationTag +
        ", InvitationSubject=" + InvitationSubject +
        ", InvitationFile=" + InvitationFile +
        ", InvitationContent=" + InvitationContent +
        ", InvitationClick=" + InvitationClick +
        ", InvitationReply=" + InvitationReply +
        ", InvitationTime=" + InvitationTime +
        "}";
    }
}
