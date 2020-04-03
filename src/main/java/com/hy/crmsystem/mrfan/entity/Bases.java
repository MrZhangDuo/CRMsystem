package com.hy.crmsystem.mrfan.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
public class Bases implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer baseId;

    private String priority;

    private String familyName;

    private String familyvalue;

    public Integer getBaseId() {
        return baseId;
    }

    public void setBaseId(Integer baseId) {
        this.baseId = baseId;
    }
    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
    public String getFamilyvalue() {
        return familyvalue;
    }

    public void setFamilyvalue(String familyvalue) {
        this.familyvalue = familyvalue;
    }

    @Override
    public String toString() {
        return "Bases{" +
        "baseId=" + baseId +
        ", priority=" + priority +
        ", familyName=" + familyName +
        ", familyvalue=" + familyvalue +
        "}";
    }
}
