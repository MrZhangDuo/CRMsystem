package com.hy.crmsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-02
 */
public class Documentary implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "DocId", type = IdType.AUTO)
    private Integer DocId;

    private Integer baseId;

    private LocalDateTime DocTime;

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
    public LocalDateTime getDocTime() {
        return DocTime;
    }

    public void setDocTime(LocalDateTime DocTime) {
        this.DocTime = DocTime;
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
