package com.hy.crmsystem.mrli.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hy.crmsystem.mrli.utils.ShiroGetUserUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
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
@TableName(value = "documentary")
public class Documentary implements Serializable  {

    private static final long serialVersionUID = 1L;

    @TableId(value = "docId", type = IdType.AUTO)
    private Integer docId;

    @TableField("busId")
    private Integer busId;

    /**
     * 跟单时间
     */
    @TableField("docTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date docTime;


    @TableField("uname")
    private String uname;

    /**
     * 跟单人
     */
    @TableField("docPeople")
    private String docPeople;

    /**
     * 跟单标题
     */
    @TableField("docTitle")
    private String docTitle;

    /**
     * 跟单内容
     */
    @TableField("docContent")
    private String docContent;

    @TableField(exist = false)
    private String realname=ShiroGetUserUtil.UserObject().getUser().getRealname();

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * 跟单分类
     */
    @TableField("docType")
    private String docType;

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    @TableField("docFile")
    private String docFile;



    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public Date getDocTime() {
        return docTime;
    }

    public void setDocTime(Date docTime) {
        this.docTime = docTime;
    }

    public String getDocPeople() {
        return docPeople;
    }

    public void setDocPeople(String docPeople) {
        this.docPeople = docPeople;
    }

    public String getDocTitle() {
        return docTitle;
    }

    public void setDocTitle(String docTitle) {
        this.docTitle = docTitle;
    }

    public String getDocContent() {
        return docContent;
    }

    public void setDocContent(String docContent) {
        this.docContent = docContent;
    }

    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    public String getDocFile() {
        return docFile;
    }

    public void setDocFile(String docFile) {
        this.docFile = docFile;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
