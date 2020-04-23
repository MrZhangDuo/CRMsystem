package com.hy.crmsystem.mrli.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Integer DocId;

    @TableField("busId")
    private Integer busId;

    /**
     * 跟单时间
     */
    @TableField("docTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date DocTime;


    @TableField("uname")
    private String uname;

    /**
     * 跟单人
     */
    @TableField("docPeople")
    private String DocPeople;

    /**
     * 跟单标题
     */
    @TableField("docTitle")
    private String DocTitle;

    /**
     * 跟单内容
     */
    @TableField("docContent")
    private String DocContent;


    /**
     * 跟单分类
     */
    @TableField("docType")
    private String DocType;

    public String getDocType() {
        return DocType;
    }

    public void setDocType(String docType) {
        DocType = docType;
    }

    @TableField("docFile")
    private String DocFile;

    public Integer getDocId() {
        return DocId;
    }

    public void setDocId(Integer DocId) {
        this.DocId = DocId;
    }



    public String getDocTitle() {
        return DocTitle;
    }

    public void setDocTitle(String docTitle) {
        DocTitle = docTitle;
    }

    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    public Date getDocTime() {
        return DocTime;
    }

    public void setDocTime(Date docTime) {
        DocTime = docTime;
    }

    public String getDocPeople() {
        return DocPeople;
    }

    public void setDocPeople(String DocPeople) {
        this.DocPeople = DocPeople;
    }
    public String getDocContent() {
        return DocContent;
    }

    public void setDocContent(String DocContent) {
        this.DocContent = DocContent;
    }
    public String getDocFile() {
        return DocFile;
    }

    public void setDocFile(String DocFile) {
        this.DocFile = DocFile;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
