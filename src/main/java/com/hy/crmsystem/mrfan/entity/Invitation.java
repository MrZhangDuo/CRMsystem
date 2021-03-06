package com.hy.crmsystem.mrfan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;


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
@TableName("invitation")
public class Invitation implements Serializable {

    private static final long serialVersionUID = 1L;
    //帖子主键
    @TableId(value = "invitationId",type = IdType.AUTO)
    private Integer invitationId;
    //商机外键
    @TableField("busId")
    private Integer busId;
    //帖子主题
    @TableField("invitationSubject")
    private String invitationSubject;
    //帖子标签
    @TableField("invitationTag")
    private String invitationTag;
    //相关附件
    @TableField("invitationFile")
    private String invitationFile;
    //帖子内容
    @TableField("invitationContent")
    private String invitationContent;
    //帖子点击量
    @TableField("invitationClick")
    private Integer invitationClick=0;
    //帖子回复量
    @TableField("invitationReply")
    private Integer invitationReply=0;
    // 帖子发表日期
    @TableField("invitationTime")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date invitationTime;
    //帖子分类
    @TableField("invitationType")
    private String invitationType;
    //帖子作者
    @TableField("invitationAuthor")
    private String invitationAuthor;


    public Integer getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(Integer invitationId) {
        this.invitationId = invitationId;
    }

    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    public String getInvitationSubject() {
        return invitationSubject;
    }

    public void setInvitationSubject(String invitationSubject) {
        this.invitationSubject = invitationSubject;
    }

    public String getInvitationAuthor() {
        return invitationAuthor;
    }

    public void setInvitationAuthor(String invitationAuthor) {
        this.invitationAuthor = invitationAuthor;
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


    @Override
    public String toString() {
        return "Invitation{" +
                "invitationId=" + invitationId +
                ", invitationSubject=" + invitationSubject +
                ", invitationTag='" + invitationTag + '\'' +
                ", invitationFile='" + invitationFile + '\'' +
                ", invitationContent='" + invitationContent + '\'' +
                ", invitationClick=" + invitationClick +
                ", invitationReply=" + invitationReply +
                ", invitationTime=" + invitationTime +
                ", invitationType='" + invitationType + '\'' +
                ", invitationAuthor='" + invitationAuthor + '\'' +
                '}';
    }
}
