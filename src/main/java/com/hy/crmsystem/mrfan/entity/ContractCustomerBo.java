package com.hy.crmsystem.mrfan.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContractCustomerBo {

    //客户外键
    private Integer custId;
    //客户姓名
    private String custName;
    private String custTrade;
    private String custCity;
    private String custAddress;

    //合同主键
    private Integer contractId;
    //合同名称
    private String contractName;
    //合同编号
    private String contractNum;
    //合同金额
    private Float contractMoney;
    //签约日期
    private Date signedTime;
    private String times;
    //生效时间
    private Date contractStarTime;
    private String starTime;
    //服务期至
    private Date contractEndTime;
    private String endTime;
    //对方联系人
    private String contractLinkMan;
    //固定电话
    private String contractFixNum;
    //移动电话
    private String phone;
    //邮件/qq
    private String email;
    //主要技术条款
    private String technical;
    //主要商务条款
    private String commerce;
    //相关附件
    private String contractfile;
    //合同所属部门
    private String ofdept;
    //关联人员
    private String relevancyPeople;
    //合同状态
    private String contractzhuangtai;
    //汇款额
    private Float incomesMoney;
    //开票额
    private Float billMoney;


    public String getTimes() {
        if(signedTime!=null){
            return new SimpleDateFormat( "yyyy-MM-dd ").format(signedTime);
        }else{
            return times;
        }
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getStarTime() {
        if(contractStarTime!=null){
            return new SimpleDateFormat( "yyyy-MM-dd ").format(contractStarTime);
        }else{
            return starTime;
        }
    }

    public void setStarTime(String starTime) {
        this.starTime = starTime;
    }

    public String getEndTime() {
        if(contractEndTime!=null){
            return new SimpleDateFormat( "yyyy-MM-dd ").format(contractEndTime);
        }else{
            return endTime;
        }
    }

    public Date getSignedTime() {
        return signedTime;
    }

    public void setSignedTime(Date signedTime) {
        this.signedTime = signedTime;
    }

    public Date getContractStarTime() {
        return contractStarTime;
    }

    public void setContractStarTime(Date contractStarTime) {
        this.contractStarTime = contractStarTime;
    }

    public Date getContractEndTime() {
        return contractEndTime;
    }

    public void setContractEndTime(Date contractEndTime) {
        this.contractEndTime = contractEndTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getContractNum() {
        return contractNum;
    }

    public void setContractNum(String contractNum) {
        this.contractNum = contractNum;
    }

    public Float getContractMoney() {
        return contractMoney;
    }

    public void setContractMoney(Float contractMoney) {
        this.contractMoney = contractMoney;
    }

    public String getContractLinkMan() {
        return contractLinkMan;
    }

    public void setContractLinkMan(String contractLinkMan) {
        this.contractLinkMan = contractLinkMan;
    }

    public String getContractFixNum() {
        return contractFixNum;
    }

    public void setContractFixNum(String contractFixNum) {
        this.contractFixNum = contractFixNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTechnical() {
        return technical;
    }

    public void setTechnical(String technical) {
        this.technical = technical;
    }

    public String getCommerce() {
        return commerce;
    }

    public void setCommerce(String commerce) {
        this.commerce = commerce;
    }

    public String getContractfile() {
        return contractfile;
    }

    public void setContractfile(String contractfile) {
        this.contractfile = contractfile;
    }

    public String getOfdept() {
        return ofdept;
    }

    public void setOfdept(String ofdept) {
        this.ofdept = ofdept;
    }

    public String getRelevancyPeople() {
        return relevancyPeople;
    }

    public void setRelevancyPeople(String relevancyPeople) {
        this.relevancyPeople = relevancyPeople;
    }

    public String getContractzhuangtai() {
        return contractzhuangtai;
    }

    public void setContractzhuangtai(String contractzhuangtai) {
        this.contractzhuangtai = contractzhuangtai;
    }

    public Float getIncomesMoney() {
        return incomesMoney;
    }

    public void setIncomesMoney(Float incomesMoney) {
        this.incomesMoney = incomesMoney;
    }

    public Float getBillMoney() {
        return billMoney;
    }

    public void setBillMoney(Float billMoney) {
        this.billMoney = billMoney;
    }
}
