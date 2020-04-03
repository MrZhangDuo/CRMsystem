package com.hy.crmsystem.mrfan.entity;

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
@TableName(value = "reolyinvitation")
public class Reolyinvitation implements Serializable {

    private static final long serialVersionUID = 1L;
    //回复主键
    @TableId(value = "ReolyId")
    private Integer ReolyId;
    //回复人
    private String ReolyPeople;
    //被回复人
    private String QuiltReolyPeople;
    //回复内容
    private String ReolyContent;
    //回复时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ReolyTime;
    //楼主
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

    public Date getReolyTime() {
        return ReolyTime;
    }

    public void setReolyTime(Date reolyTime) {
        ReolyTime = reolyTime;
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
                ", ReolyPeople='" + ReolyPeople + '\'' +
                ", QuiltReolyPeople='" + QuiltReolyPeople + '\'' +
                ", ReolyContent='" + ReolyContent + '\'' +
                ", ReolyTime=" + ReolyTime +
                ", LZ='" + LZ + '\'' +
                '}';
    }
}
