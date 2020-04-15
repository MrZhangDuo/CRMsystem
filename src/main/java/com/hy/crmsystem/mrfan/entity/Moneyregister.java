package com.hy.crmsystem.mrfan.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
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
@TableName(value = "moneyregister")
public class Moneyregister implements Serializable {

    private static final long serialVersionUID = 1L;
    //收入登记主键
    private Integer incomeId;
    //合同主键
    private Integer contractId;
    //收入日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date incomeTime;
    //收入分类
    private Integer incomesort;
    //收入金额
    private String incomesMoney;
    //大写
    private String moneyBigWrite;
    //收款方式
    private Integer incomeWay;
    //登记人
    private String registerPeople;
    //关联人员
    private String relevancyPeople;
    //关联部门
    private Integer relevancyDept;
    //对方单位
    private String unit;
    //关联合同
    private String relevancyContract;
    //收入说明
    private String incomeldExplain;

    public Integer getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Integer incomeId) {
        this.incomeId = incomeId;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Date getIncomeTime() {
        return incomeTime;
    }

    public void setIncomeTime(Date incomeTime) {
        this.incomeTime = incomeTime;
    }

    public Integer getIncomesort() {
        return incomesort;
    }

    public void setIncomesort(Integer incomesort) {
        this.incomesort = incomesort;
    }

    public String getIncomesMoney() {
        return incomesMoney;
    }

    public void setIncomesMoney(String incomesMoney) {
        this.incomesMoney = incomesMoney;
    }

    public String getMoneyBigWrite() {
        return moneyBigWrite;
    }

    public void setMoneyBigWrite(String moneyBigWrite) {
        this.moneyBigWrite = moneyBigWrite;
    }

    public Integer getIncomeWay() {
        return incomeWay;
    }

    public void setIncomeWay(Integer incomeWay) {
        this.incomeWay = incomeWay;
    }

    public String getRegisterPeople() {
        return registerPeople;
    }

    public void setRegisterPeople(String registerPeople) {
        this.registerPeople = registerPeople;
    }

    public String getRelevancyPeople() {
        return relevancyPeople;
    }

    public void setRelevancyPeople(String relevancyPeople) {
        this.relevancyPeople = relevancyPeople;
    }

    public Integer getRelevancyDept() {
        return relevancyDept;
    }

    public void setRelevancyDept(Integer relevancyDept) {
        this.relevancyDept = relevancyDept;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRelevancyContract() {
        return relevancyContract;
    }

    public void setRelevancyContract(String relevancyContract) {
        this.relevancyContract = relevancyContract;
    }

    public String getIncomeldExplain() {
        return incomeldExplain;
    }

    public void setIncomeldExplain(String incomeldExplain) {
        this.incomeldExplain = incomeldExplain;
    }

    @Override
    public String toString() {
        return "Moneyregister{" +
                "incomeId=" + incomeId +
                ", contractId=" + contractId +
                ", incomeTime=" + incomeTime +
                ", incomesort=" + incomesort +
                ", incomesMoney='" + incomesMoney + '\'' +
                ", moneyBigWrite='" + moneyBigWrite + '\'' +
                ", incomeWay=" + incomeWay +
                ", registerPeople='" + registerPeople + '\'' +
                ", relevancyPeople='" + relevancyPeople + '\'' +
                ", relevancyDept=" + relevancyDept +
                ", unit='" + unit + '\'' +
                ", relevancyContract='" + relevancyContract + '\'' +
                ", incomeldExplain='" + incomeldExplain + '\'' +
                '}';
    }
}
