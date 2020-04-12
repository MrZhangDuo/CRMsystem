package com.hy.crmsystem.mrpan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 商机表
 */
@TableName(value = "business")
public class Business implements Serializable {

    private static final long serialVersionUID = 1L;

   //商机id
    @TableId(value = "busId", type = IdType.AUTO)
    private Integer busId;

    private Integer custId;


    private String busName;

    private String busSource;


    private Float busBeforeMoney;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date busBeforedate;

    private String busBlinkMan;

    private String busDept;

    private String busJob;

    private String busFixnum;

    private String busPhone;

    private String busEmail;

    private String busNeed;

    private String busFile;

    private String busDutyPeople;

    private String busJoinPeople;

    private String busFollowPeople;

    private String busStage;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date busTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getBusSource() {
        return busSource;
    }

    public void setBusSource(String busSource) {
        this.busSource = busSource;
    }

    public Float getBusBeforeMoney() {
        return busBeforeMoney;
    }

    public void setBusBeforeMoney(Float busBeforeMoney) {
        this.busBeforeMoney = busBeforeMoney;
    }

    public Date getBusBeforedate() {
        return busBeforedate;
    }

    public void setBusBeforedate(Date busBeforedate) {
        this.busBeforedate = busBeforedate;
    }

    public String getBusBlinkMan() {
        return busBlinkMan;
    }

    public void setBusBlinkMan(String busBlinkMan) {
        this.busBlinkMan = busBlinkMan;
    }

    public String getBusDept() {
        return busDept;
    }

    public void setBusDept(String busDept) {
        this.busDept = busDept;
    }

    public String getBusJob() {
        return busJob;
    }

    public void setBusJob(String busJob) {
        this.busJob = busJob;
    }

    public String getBusFixnum() {
        return busFixnum;
    }

    public void setBusFixnum(String busFixnum) {
        this.busFixnum = busFixnum;
    }

    public String getBusPhone() {
        return busPhone;
    }

    public void setBusPhone(String busPhone) {
        this.busPhone = busPhone;
    }

    public String getBusEmail() {
        return busEmail;
    }

    public void setBusEmail(String busEmail) {
        this.busEmail = busEmail;
    }

    public String getBusNeed() {
        return busNeed;
    }

    public void setBusNeed(String busNeed) {
        this.busNeed = busNeed;
    }

    public String getBusFile() {
        return busFile;
    }

    public void setBusFile(String busFile) {
        this.busFile = busFile;
    }

    public String getBusDutyPeople() {
        return busDutyPeople;
    }

    public void setBusDutyPeople(String busDutyPeople) {
        this.busDutyPeople = busDutyPeople;
    }

    public String getBusJoinPeople() {
        return busJoinPeople;
    }

    public void setBusJoinPeople(String busJoinPeople) {
        this.busJoinPeople = busJoinPeople;
    }

    public String getBusFollowPeople() {
        return busFollowPeople;
    }

    public void setBusFollowPeople(String busFollowPeople) {
        this.busFollowPeople = busFollowPeople;
    }

    public String getBusStage() {
        return busStage;
    }

    public void setBusStage(String busStage) {
        this.busStage = busStage;
    }

    public Date getBusTime() {
        return busTime;
    }

    public void setBusTime(Date busTime) {
        this.busTime = busTime;
    }

    @Override
    public String toString() {
        return "Business{" +
                "busId=" + busId +
                ", custId=" + custId +
                ", busName='" + busName + '\'' +
                ", busSource='" + busSource + '\'' +
                ", busBeforeMoney=" + busBeforeMoney +
                ", busBeforedate=" + busBeforedate +
                ", busBlinkMan='" + busBlinkMan + '\'' +
                ", busDept='" + busDept + '\'' +
                ", busJob='" + busJob + '\'' +
                ", busFixnum='" + busFixnum + '\'' +
                ", busPhone='" + busPhone + '\'' +
                ", busEmail='" + busEmail + '\'' +
                ", busNeed='" + busNeed + '\'' +
                ", busFile='" + busFile + '\'' +
                ", busDutyPeople='" + busDutyPeople + '\'' +
                ", busJoinPeople='" + busJoinPeople + '\'' +
                ", busFollowPeople='" + busFollowPeople + '\'' +
                ", busStage='" + busStage + '\'' +
                ", busTime=" + busTime +
                '}';
    }
}
