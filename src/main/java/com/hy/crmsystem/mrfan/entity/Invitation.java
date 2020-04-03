package com.hy.crmsystem.mrfan.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
public class Invitation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer InvitationId;

    private Integer ReolyId;

    private String InvitationTag;

    private String InvitationSubject;

    private String InvitationFile;

    private String InvitationContent;

    private Integer InvitationClick;

    private Integer InvitationReply;

    private LocalDateTime InvitationTime;

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
    public LocalDateTime getInvitationTime() {
        return InvitationTime;
    }

    public void setInvitationTime(LocalDateTime InvitationTime) {
        this.InvitationTime = InvitationTime;
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
