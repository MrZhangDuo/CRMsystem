package com.hy.crmsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-02
 */
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ContractId", type = IdType.AUTO)
    private Integer ContractId;

    private Integer incomeId;

    private Integer billId;

    private Integer baseId;

    private String ContractName;

    private String ContractNum;

    private String ContractMoney;

    /**
     * ǩԼ
     */
    private LocalDate SignedTime;

    private LocalDate ContractStarTime;

    private LocalDate ContractEndTime;

    private String ContractLinkMan;

    private String ContractFixNum;

    private String Phone;

    private String Email;

    private String Technical;

    private String Commerce;

    private String Contractfile;

    private Integer ofdept;

    private String RelevancyPeople;

    public Integer getContractId() {
        return ContractId;
    }

    public void setContractId(Integer ContractId) {
        this.ContractId = ContractId;
    }
    public Integer getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Integer incomeId) {
        this.incomeId = incomeId;
    }
    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }
    public Integer getBaseId() {
        return baseId;
    }

    public void setBaseId(Integer baseId) {
        this.baseId = baseId;
    }
    public String getContractName() {
        return ContractName;
    }

    public void setContractName(String ContractName) {
        this.ContractName = ContractName;
    }
    public String getContractNum() {
        return ContractNum;
    }

    public void setContractNum(String ContractNum) {
        this.ContractNum = ContractNum;
    }
    public String getContractMoney() {
        return ContractMoney;
    }

    public void setContractMoney(String ContractMoney) {
        this.ContractMoney = ContractMoney;
    }
    public LocalDate getSignedTime() {
        return SignedTime;
    }

    public void setSignedTime(LocalDate SignedTime) {
        this.SignedTime = SignedTime;
    }
    public LocalDate getContractStarTime() {
        return ContractStarTime;
    }

    public void setContractStarTime(LocalDate ContractStarTime) {
        this.ContractStarTime = ContractStarTime;
    }
    public LocalDate getContractEndTime() {
        return ContractEndTime;
    }

    public void setContractEndTime(LocalDate ContractEndTime) {
        this.ContractEndTime = ContractEndTime;
    }
    public String getContractLinkMan() {
        return ContractLinkMan;
    }

    public void setContractLinkMan(String ContractLinkMan) {
        this.ContractLinkMan = ContractLinkMan;
    }
    public String getContractFixNum() {
        return ContractFixNum;
    }

    public void setContractFixNum(String ContractFixNum) {
        this.ContractFixNum = ContractFixNum;
    }
    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    public String getTechnical() {
        return Technical;
    }

    public void setTechnical(String Technical) {
        this.Technical = Technical;
    }
    public String getCommerce() {
        return Commerce;
    }

    public void setCommerce(String Commerce) {
        this.Commerce = Commerce;
    }
    public String getContractfile() {
        return Contractfile;
    }

    public void setContractfile(String Contractfile) {
        this.Contractfile = Contractfile;
    }
    public Integer getOfdept() {
        return ofdept;
    }

    public void setOfdept(Integer ofdept) {
        this.ofdept = ofdept;
    }
    public String getRelevancyPeople() {
        return RelevancyPeople;
    }

    public void setRelevancyPeople(String RelevancyPeople) {
        this.RelevancyPeople = RelevancyPeople;
    }

    @Override
    public String toString() {
        return "Contract{" +
        "ContractId=" + ContractId +
        ", incomeId=" + incomeId +
        ", billId=" + billId +
        ", baseId=" + baseId +
        ", ContractName=" + ContractName +
        ", ContractNum=" + ContractNum +
        ", ContractMoney=" + ContractMoney +
        ", SignedTime=" + SignedTime +
        ", ContractStarTime=" + ContractStarTime +
        ", ContractEndTime=" + ContractEndTime +
        ", ContractLinkMan=" + ContractLinkMan +
        ", ContractFixNum=" + ContractFixNum +
        ", Phone=" + Phone +
        ", Email=" + Email +
        ", Technical=" + Technical +
        ", Commerce=" + Commerce +
        ", Contractfile=" + Contractfile +
        ", ofdept=" + ofdept +
        ", RelevancyPeople=" + RelevancyPeople +
        "}";
    }
}
