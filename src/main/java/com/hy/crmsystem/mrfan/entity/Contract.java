package com.hy.crmsystem.mrfan.entity;

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
 */
@TableName(value = "contract")
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;
    //合同主键
    @TableId(value = "ContractId", type = IdType.AUTO)
    private Integer contractId;
    //客户外键
    private Integer custId;
    //合同名称
    private String contractName;
    //合同编号
    private String contractNum;
    //合同金额
    private Float contractMoney;
    //签约日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date signedTime;
    //生效时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date contractStarTime;
    //服务期至
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date contractEndTime;
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
    private Integer ofdept;
    //关联人员
    private String relevancyPeople;

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
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

    public Integer getOfdept() {
        return ofdept;
    }

    public void setOfdept(Integer ofdept) {
        this.ofdept = ofdept;
    }

    public String getRelevancyPeople() {
        return relevancyPeople;
    }

    public void setRelevancyPeople(String relevancyPeople) {
        this.relevancyPeople = relevancyPeople;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractId=" + contractId +
                ", custId=" + custId +
                ", contractName='" + contractName + '\'' +
                ", contractNum='" + contractNum + '\'' +
                ", contractMoney='" + contractMoney + '\'' +
                ", signedTime=" + signedTime +
                ", contractStarTime=" + contractStarTime +
                ", contractEndTime=" + contractEndTime +
                ", contractLinkMan='" + contractLinkMan + '\'' +
                ", contractFixNum='" + contractFixNum + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", technical='" + technical + '\'' +
                ", commerce='" + commerce + '\'' +
                ", contractfile='" + contractfile + '\'' +
                ", ofdept=" + ofdept +
                ", relevancyPeople='" + relevancyPeople + '\'' +
                '}';
    }
}
