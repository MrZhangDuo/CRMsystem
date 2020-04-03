package com.hy.crmsystem.mrfan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

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
@TableName(value = "contract")
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;
    //合同主键
    @TableId(value = "ContractId", type = IdType.AUTO)
    private Integer ContractId;
    //收入登记主键
    private Integer incomeId;
    //开票主键
    private Integer billId;
    //基础主键
    private Integer baseId;
    //合同名称
    private String ContractName;
    //合同编号
    private String ContractNum;
    //合同金额
    private String ContractMoney;
    //签约日期
    private Date SignedTime;
    //生效时间
    private Date ContractStarTime;
    //服务期至
    private Date ContractEndTime;
    //对方联系人
    private String ContractLinkMan;
    //固定电话
    private String ContractFixNum;
    //移动电话
    private String Phone;
    //邮件/qq
    private String Email;
    //主要技术条款
    private String Technical;
    //主要商务条款
    private String Commerce;
    //相关附件
    private String Contractfile;
    //合同所属部门
    private Integer ofdept;
    //关联人员
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

    public void setContractMoney(String contractMoney) {
        ContractMoney = contractMoney;
    }

    public Date getSignedTime() {
        return SignedTime;
    }

    public void setSignedTime(Date signedTime) {
        SignedTime = signedTime;
    }

    public Date getContractStarTime() {
        return ContractStarTime;
    }

    public void setContractStarTime(Date contractStarTime) {
        ContractStarTime = contractStarTime;
    }

    public Date getContractEndTime() {
        return ContractEndTime;
    }

    public void setContractEndTime(Date contractEndTime) {
        ContractEndTime = contractEndTime;
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
