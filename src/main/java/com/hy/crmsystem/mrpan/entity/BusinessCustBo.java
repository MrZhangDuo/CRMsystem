package com.hy.crmsystem.mrpan.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BusinessCustBo {

    private Integer busId;
    private String custDept;
    //跟单主键
    private Integer docId;
    //帖子主键
    private Integer invitationId;
    //基础主键
    private Integer baseId;
    //商机名称
    private String busName;
    //商机来源
    private String busSource;

    //预成交金额
    private String busBeforeMoney;
    //预结单日期
    private Date busBeforedate;
    private String beForedate;
    //联系人
    private String busBlinkMan;
    //部门
    private String busDept;
    //职务
    private String busJob;
    //固定电话
    private String busFixnum;
    //移动电话
    private String busPhone;
    //邮件/QQ
    private String busEmail;
    //主要业务需求
    private String busNeed;
    //相关附件
    private String busFile;
    //商机负责人
    private String busDutyPeople;
    //商机产与人
    private String busJoinPeople;
    //商机关注人
    private String busFollowPeople;
    //商机阶段
    private String busStage;
    // 添加商机的时间
    private Date busTime;
    private String nowTime;
    //商机的优先级
    private String busPriority;

    private Integer custId;
    private String custName;
    private String custTrade;
    private String custCity;
    private String custAddress;
    private String custSource;

    public String getNowTime() {
        if(busTime!=null){
            return new SimpleDateFormat("yyyy-MM-dd").format(busTime);
        }
        return nowTime;
    }

    public void setNowTime(String nowTime) {
        this.nowTime = nowTime;
    }

    public Date getBusTime() {
        return busTime;
    }

    public void setBusTime(Date busTime) {
        this.busTime = busTime;
    }

    public String getBeForedate() {
        if(busBeforedate!=null){
            return new SimpleDateFormat("yyyy-MM-dd").format(busBeforedate);
        }
        return beForedate;
    }

    public Integer getCustId() {
        return custId;
    }

    public String getCustDept() {
        return custDept;
    }

    public void setCustDept(String custDept) {
        this.custDept = custDept;
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

    public String getCustTrade() {
        return custTrade;
    }

    public void setCustTrade(String custTrade) {
        this.custTrade = custTrade;
    }

    public String getCustCity() {
        return custCity;
    }

    public void setCustCity(String custCity) {
        this.custCity = custCity;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public void setBeForedate(String beForedate) {
        this.beForedate = beForedate;
    }

    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
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

    public void setInvitationId(Integer invitationId) {
        this.invitationId = invitationId;
    }

    public Integer getBaseId() {
        return baseId;
    }

    public void setBaseId(Integer baseId) {
        this.baseId = baseId;
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

    public String getBusBeforeMoney() {
        return busBeforeMoney;
    }

    public void setBusBeforeMoney(String busBeforeMoney) {
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


    public String getBusPriority() {
        return busPriority;
    }

    public void setBusPriority(String busPriority) {
        this.busPriority = busPriority;
    }
}
