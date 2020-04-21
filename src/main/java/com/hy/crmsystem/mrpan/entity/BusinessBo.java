package com.hy.crmsystem.mrpan.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BusinessBo {
    private Integer custId;
    private String custName;
    private Integer busId;
    private Integer tlbs;
    //跟单主键
    private Integer docId;
    //帖子主键
    private Integer invitationId;
    //商机名称
    private String busName;
    //预成交金额
    private Float busBeforeMoney;
    //商机负责人
    private String busDutyPeople;
    //商机阶段
    private String busStage;
    //部门
    private String busDept;
    //预结单日期
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date busBeforedate;
    //将预计结单日期转换字符串字段
    private String beforeDate;
     //最后跟单时间
   @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date docTime;
    private String gdTime;

    public Date getDocTime() {
        return docTime;
    }

    public Integer getTlbs() {
        return tlbs;
    }

    public void setTlbs(Integer tlbs) {
        this.tlbs = tlbs;
    }

    public void setDocTime(Date docTime) {
        this.docTime = docTime;
    }

    public String getGdTime() {
        if(docTime!=null){
            return new SimpleDateFormat("yyyy-MM-dd").format(docTime);
        }else {
            return gdTime;
        }

    }

    public void setGdTime(String gdTime) {
        this.gdTime = gdTime;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public Integer getInvitationId() {
        return invitationId;
    }

    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    public void setInvitationId(Integer invitationId) {
        this.invitationId = invitationId;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public Float getBusBeforeMoney() {
        return busBeforeMoney;
    }

    public void setBusBeforeMoney(Float busBeforeMoney) {
        this.busBeforeMoney = busBeforeMoney;
    }

    public String getBusDutyPeople() {
        return busDutyPeople;
    }

    public void setBusDutyPeople(String busDutyPeople) {
        this.busDutyPeople = busDutyPeople;
    }

    public String getBusStage() {
        return busStage;
    }

    public void setBusStage(String busStage) {
        this.busStage = busStage;
    }

    public String getBusDept() {
        return busDept;
    }

    public void setBusDept(String busDept) {
        this.busDept = busDept;
    }

    public Date getBusBeforedate() {
        return busBeforedate;
    }

    public void setBusBeforedate(Date busBeforedate) {
        this.busBeforedate = busBeforedate;
    }

    public String getBeforeDate() {
        if(beforeDate!=null){
            return new SimpleDateFormat("yyyy-MM-dd").format(beforeDate);
        }
        return beforeDate;
    }

    public void setBeforeDate(String beforeDate) {
        this.beforeDate = beforeDate;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Override
    public String toString() {
        return "BusinessBo{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", busId=" + busId +
                ", docId=" + docId +
                ", invitationId=" + invitationId +
                ", busName='" + busName + '\'' +
                ", busBeforeMoney='" + busBeforeMoney + '\'' +
                ", busDutyPeople='" + busDutyPeople + '\'' +
                ", busStage='" + busStage + '\'' +
                ", busDept='" + busDept + '\'' +
                ", busBeforedate=" + busBeforedate +
                ", beforeDate='" + beforeDate + '\'' +
                '}';
    }
}
