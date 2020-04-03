package com.hy.crmsystem.mrfan.entity;

import java.time.LocalDate;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
public class Moneyregister implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer incomeId;

    private LocalDate incomeTime;

    private Integer incomesort;

    private String incomesMoney;

    private String MoneyBigWrite;

    private Integer incomeWay;

    private String RegisterPeople;

    private String relevancyPeople;

    private Integer relevancyDept;

    private String unit;

    private String relevancyContract;

    private String incomeldExplain;

    public Integer getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Integer incomeId) {
        this.incomeId = incomeId;
    }
    public LocalDate getIncomeTime() {
        return incomeTime;
    }

    public void setIncomeTime(LocalDate incomeTime) {
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
        return MoneyBigWrite;
    }

    public void setMoneyBigWrite(String MoneyBigWrite) {
        this.MoneyBigWrite = MoneyBigWrite;
    }
    public Integer getIncomeWay() {
        return incomeWay;
    }

    public void setIncomeWay(Integer incomeWay) {
        this.incomeWay = incomeWay;
    }
    public String getRegisterPeople() {
        return RegisterPeople;
    }

    public void setRegisterPeople(String RegisterPeople) {
        this.RegisterPeople = RegisterPeople;
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
        ", incomeTime=" + incomeTime +
        ", incomesort=" + incomesort +
        ", incomesMoney=" + incomesMoney +
        ", MoneyBigWrite=" + MoneyBigWrite +
        ", incomeWay=" + incomeWay +
        ", RegisterPeople=" + RegisterPeople +
        ", relevancyPeople=" + relevancyPeople +
        ", relevancyDept=" + relevancyDept +
        ", unit=" + unit +
        ", relevancyContract=" + relevancyContract +
        ", incomeldExplain=" + incomeldExplain +
        "}";
    }
}
