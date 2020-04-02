package com.hy.crmsystem.entity;

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
public class Reolyinvitation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer ReolyId;

    private String ReolyPeople;

    private String QuiltReolyPeople;

    private String ReolyContent;

    private LocalDateTime ReolyTime;

    /**
     * ¥
     */
    private String LZ;

    public Integer getReolyId() {
        return ReolyId;
    }

    public void setReolyId(Integer ReolyId) {
        this.ReolyId = ReolyId;
    }
    public String getReolyPeople() {
        return ReolyPeople;
    }

    public void setReolyPeople(String ReolyPeople) {
        this.ReolyPeople = ReolyPeople;
    }
    public String getQuiltReolyPeople() {
        return QuiltReolyPeople;
    }

    public void setQuiltReolyPeople(String QuiltReolyPeople) {
        this.QuiltReolyPeople = QuiltReolyPeople;
    }
    public String getReolyContent() {
        return ReolyContent;
    }

    public void setReolyContent(String ReolyContent) {
        this.ReolyContent = ReolyContent;
    }
    public LocalDateTime getReolyTime() {
        return ReolyTime;
    }

    public void setReolyTime(LocalDateTime ReolyTime) {
        this.ReolyTime = ReolyTime;
    }
    public String getLZ() {
        return LZ;
    }

    public void setLZ(String LZ) {
        this.LZ = LZ;
    }

    @Override
    public String toString() {
        return "Reolyinvitation{" +
        "ReolyId=" + ReolyId +
        ", ReolyPeople=" + ReolyPeople +
        ", QuiltReolyPeople=" + QuiltReolyPeople +
        ", ReolyContent=" + ReolyContent +
        ", ReolyTime=" + ReolyTime +
        ", LZ=" + LZ +
        "}";
    }
}
