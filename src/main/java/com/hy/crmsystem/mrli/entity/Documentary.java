package com.hy.crmsystem.mrli.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
public class Documentary implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "DocId", type = IdType.AUTO)
    private Integer DocId;

    private Integer baseId;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date DocTime;

    private String DocPeople;

    private String DocContent;

    private String DocFile;

    public Integer getDocId() {
        return DocId;
    }

    public void setDocId(Integer DocId) {
        this.DocId = DocId;
    }
    public Integer getBaseId() {
        return baseId;
    }

    public void setBaseId(Integer baseId) {
        this.baseId = baseId;
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

    @Override
    public String toString() {
        return "Documentary{" +
        "DocId=" + DocId +
        ", baseId=" + baseId +
        ", DocTime=" + DocTime +
        ", DocPeople=" + DocPeople +
        ", DocContent=" + DocContent +
        ", DocFile=" + DocFile +
        "}";
    }
}
