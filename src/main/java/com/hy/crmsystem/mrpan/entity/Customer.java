package com.hy.crmsystem.mrpan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 * 客户表
 */
@TableName(value = "customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

   //客户id
    @TableId(value = "custId", type = IdType.AUTO)
    private Integer custId;


    @TableField("moneyId")
    private Integer moneyId;

    @TableField("custName")
    private String custName;

    @TableField("custSpell")
    private String custSpell;

    @TableField("custClassify")
    private String custClassify;

    @TableField("custSource")
    private String custSource;

    @TableField("custTrade")
    private String custTrade;

    @TableField("custUrl")
    private String custUrl;

    @TableField("custCountry")
    private String custCountry;

    @TableField("custCity")
    private String custCity;

    @TableField("custAddress")
    private String custAddress;

    @TableField("custPostCode")
    private String custPostCode;

    @TableField("custFax")
    private String custFax;

    @TableField("custLinkMan")
    private String custLinkMan;

    @TableField("custDept")
    private String custDept;

    @TableField("custJob")
    private String custJob;

    @TableField("custOfficeTel")
    private String custOfficeTel;

    @TableField("custPhone")
    private String custPhone;

    @TableField("custEmail")
    private String custEmail;

    @TableField("custCorporation")
    private String custCorporation;

    @TableField("custCapital")
    private String custCapital;

    @TableField("custExplain")
    private String custExplain;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public Integer getMoneyId() {
        return moneyId;
    }

    public void setMoneyId(Integer moneyId) {
        this.moneyId = moneyId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSpell() {
        return custSpell;
    }

    public void setCustSpell(String custSpell) {
        this.custSpell = custSpell;
    }

    public String getCustClassify() {
        return custClassify;
    }

    public void setCustClassify(String custClassify) {
        this.custClassify = custClassify;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustTrade() {
        return custTrade;
    }

    public void setCustTrade(String custTrade) {
        this.custTrade = custTrade;
    }

    public String getCustUrl() {
        return custUrl;
    }

    public void setCustUrl(String custUrl) {
        this.custUrl = custUrl;
    }

    public String getCustCountry() {
        return custCountry;
    }

    public void setCustCountry(String custCountry) {
        this.custCountry = custCountry;
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

    public String getCustPostCode() {
        return custPostCode;
    }

    public void setCustPostCode(String custPostCode) {
        this.custPostCode = custPostCode;
    }

    public String getCustFax() {
        return custFax;
    }

    public void setCustFax(String custFax) {
        this.custFax = custFax;
    }

    public String getCustLinkMan() {
        return custLinkMan;
    }

    public void setCustLinkMan(String custLinkMan) {
        this.custLinkMan = custLinkMan;
    }

    public String getCustDept() {
        return custDept;
    }

    public void setCustDept(String custDept) {
        this.custDept = custDept;
    }

    public String getCustJob() {
        return custJob;
    }

    public void setCustJob(String custJob) {
        this.custJob = custJob;
    }

    public String getCustOfficeTel() {
        return custOfficeTel;
    }

    public void setCustOfficeTel(String custOfficeTel) {
        this.custOfficeTel = custOfficeTel;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getCustCorporation() {
        return custCorporation;
    }

    public void setCustCorporation(String custCorporation) {
        this.custCorporation = custCorporation;
    }

    public String getCustCapital() {
        return custCapital;
    }

    public void setCustCapital(String custCapital) {
        this.custCapital = custCapital;
    }

    public String getCustExplain() {
        return custExplain;
    }

    public void setCustExplain(String custExplain) {
        this.custExplain = custExplain;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", moneyId=" + moneyId +
                ", custName='" + custName + '\'' +
                ", custSpell='" + custSpell + '\'' +
                ", custClassify='" + custClassify + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custTrade='" + custTrade + '\'' +
                ", custUrl='" + custUrl + '\'' +
                ", custCountry='" + custCountry + '\'' +
                ", custCity='" + custCity + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custPostCode='" + custPostCode + '\'' +
                ", custFax='" + custFax + '\'' +
                ", custLinkMan='" + custLinkMan + '\'' +
                ", custDept='" + custDept + '\'' +
                ", custJob='" + custJob + '\'' +
                ", custOfficeTel='" + custOfficeTel + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", custEmail='" + custEmail + '\'' +
                ", custCorporation='" + custCorporation + '\'' +
                ", custCapital='" + custCapital + '\'' +
                ", custExplain='" + custExplain + '\'' +
                '}';
    }
}
