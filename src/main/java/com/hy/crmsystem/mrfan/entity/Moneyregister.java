package com.hy.crmsystem.mrfan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId(value = "incomeId",type = IdType.AUTO)
    private Integer incomeId;
    //合同主键
    @TableField("contractId")
    private Integer contractId;
    //收入日期
    @TableField("incomeTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date incomeTime;
    //收入分类
    @TableField("incomesort")
    private String incomesort;
    //收入金额
    @TableField("incomesMoney")
    private String incomesMoney;
    //大写
    @TableField("moneyBigWrite")
    private String moneyBigWrite;
    //收款方式
    @TableField("incomeWay")
    private String incomeWay;
    //登记人
    @TableField("registerPeople")
    private String registerPeople;
    //关联人员
    @TableField("relevancyPeople")
    private String relevancyPeople;
    //关联部门
    @TableField("relevancyDept")
    private String relevancyDept;
    //对方单位
    @TableField("unit")
    private String unit;
    //关联合同
    @TableField("relevancyContract")
    private String relevancyContract;
    //收入说明
    @TableField("incomeldExplain")
    private String incomeldExplain;

    public String getIncomesort() {
        return incomesort;
    }

    public void setIncomesort(String incomesort) {
        this.incomesort = incomesort;
    }

    public String getIncomeWay() {
        return incomeWay;
    }

    public void setIncomeWay(String incomeWay) {
        this.incomeWay = incomeWay;
    }

    public String getRelevancyDept() {
        return relevancyDept;
    }

    public void setRelevancyDept(String relevancyDept) {
        this.relevancyDept = relevancyDept;
    }

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
