package com.hy.crmsystem.mrpan.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContractBo {
    //客户名称id
    private Integer custId;
    private Integer contractId;
    //合同名称
    private String contractName;
    //合同编号
    private String contractNum;
    //合同金额
    private String contractMoney;
    //签约日期
    private Date signedTime;
    //签约日期转换字符串
    private String timeSigned;
    //汇款额
    private Float incomesMoney;
    //开票额
    private Float billMoney;
    //所属部门
    private String ofdept;

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

    public String getContractMoney() {
        return contractMoney;
    }

    public void setContractMoney(String contractMoney) {
        this.contractMoney = contractMoney;
    }

    public Date getSignedTime() {
        return signedTime;
    }

    public void setSignedTime(Date signedTime) {
        this.signedTime = signedTime;
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

    public String getOfdept() {
        return ofdept;
    }

    public void setOfdept(String ofdept) {
        this.ofdept = ofdept;
    }

    public String getTimeSigned() {
        if(signedTime!=null){
            return new SimpleDateFormat("yyyy-MM-dd").format(signedTime);
        }

        return timeSigned;
    }

    public void setTimeSigned(String timeSigned) {
        this.timeSigned = timeSigned;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    @Override
    public String toString() {
        return "ContractBoi{" +
                "custId=" + custId +
                ", contractName='" + contractName + '\'' +
                ", contractNum='" + contractNum + '\'' +
                ", contractMoney='" + contractMoney + '\'' +
                ", signedTime=" + signedTime +
                ", timeSigned='" + timeSigned + '\'' +
                ", incomesMoney=" + incomesMoney +
                ", billMoney=" + billMoney +
                ", ofdept='" + ofdept + '\'' +
                '}';
    }
}
