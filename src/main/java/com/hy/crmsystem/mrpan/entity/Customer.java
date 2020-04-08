package com.hy.crmsystem.mrpan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
    @TableId(value = "CustId", type = IdType.AUTO)
    private Integer CustId;
  //商机主键
    private Integer BusId;
  //合同主键
    private Integer ContractId;
    //售后主键
    private Integer ServiceId;
    //财务主键
    private Integer MoneyId;
    //客户姓名
    private String CustName;
    //客户姓名拼音
    private String CustSpell;
    //客户分类
    private String CustClassify;
    //客户来源
    private Integer CustSource;
    //客户行业
    private String CustTrade;
    //客户网址
    private String CustUrl;
    //客户国家/地区
    private String CustCountry;
    //客户城市
    private String CustCity;
    //客户详细地址
    private String CustAddress;
    //客户邮政编码
    private String CustPostCode;
    //客户传真
    private String CustFax;
    //客户联系人
    private String CustLinkMan;
    //客户部门
    private String CustDept;

    //客户职务
    private String CustJob;
    //客户办公电话
    private String CustOfficeTel;
    //客户移动电话
    private String CustPhone;
    //客户邮件/QQ
    private String CustEmail;
    //客户法人
    private String CustCorporation;
    //客户注册资本
    private String CustCapital;
   //附加说明
    private String CustExplain;

    public Integer getCustId() {
        return CustId;
    }

    public void setCustId(Integer CustId) {
        this.CustId = CustId;
    }
    public Integer getBusId() {
        return BusId;
    }

    public void setBusId(Integer BusId) {
        this.BusId = BusId;
    }
    public Integer getContractId() {
        return ContractId;
    }

    public void setContractId(Integer ContractId) {
        this.ContractId = ContractId;
    }
    public Integer getServiceId() {
        return ServiceId;
    }

    public void setServiceId(Integer ServiceId) {
        this.ServiceId = ServiceId;
    }
    public Integer getMoneyId() {
        return MoneyId;
    }

    public void setMoneyId(Integer MoneyId) {
        this.MoneyId = MoneyId;
    }
    public String getCustName() {
        return CustName;
    }

    public void setCustName(String CustName) {
        this.CustName = CustName;
    }
    public String getCustSpell() {
        return CustSpell;
    }

    public void setCustSpell(String CustSpell) {
        this.CustSpell = CustSpell;
    }

    public String getCustClassify() {
        return CustClassify;
    }

    public void setCustClassify(String custClassify) {
        CustClassify = custClassify;
    }

    public Integer getCustSource() {
        return CustSource;
    }

    public void setCustSource(Integer CustSource) {
        this.CustSource = CustSource;
    }
    public String getCustTrade() {
        return CustTrade;
    }

    public void setCustTrade(String CustTrade) {
        this.CustTrade = CustTrade;
    }
    public String getCustUrl() {
        return CustUrl;
    }

    public void setCustUrl(String CustUrl) {
        this.CustUrl = CustUrl;
    }
    public String getCustCountry() {
        return CustCountry;
    }

    public void setCustCountry(String CustCountry) {
        this.CustCountry = CustCountry;
    }
    public String getCustCity() {
        return CustCity;
    }

    public void setCustCity(String CustCity) {
        this.CustCity = CustCity;
    }
    public String getCustAddress() {
        return CustAddress;
    }

    public void setCustAddress(String CustAddress) {
        this.CustAddress = CustAddress;
    }
    public String getCustPostCode() {
        return CustPostCode;
    }

    public void setCustPostCode(String CustPostCode) {
        this.CustPostCode = CustPostCode;
    }
    public String getCustFax() {
        return CustFax;
    }

    public void setCustFax(String CustFax) {
        this.CustFax = CustFax;
    }
    public String getCustLinkMan() {
        return CustLinkMan;
    }

    public void setCustLinkMan(String CustLinkMan) {
        this.CustLinkMan = CustLinkMan;
    }
    public String getCustDept() {
        return CustDept;
    }

    public void setCustDept(String CustDept) {
        this.CustDept = CustDept;
    }
    public String getCustJob() {
        return CustJob;
    }

    public void setCustJob(String CustJob) {
        this.CustJob = CustJob;
    }
    public String getCustOfficeTel() {
        return CustOfficeTel;
    }

    public void setCustOfficeTel(String CustOfficeTel) {
        this.CustOfficeTel = CustOfficeTel;
    }
    public String getCustPhone() {
        return CustPhone;
    }

    public void setCustPhone(String CustPhone) {
        this.CustPhone = CustPhone;
    }
    public String getCustEmail() {
        return CustEmail;
    }

    public void setCustEmail(String CustEmail) {
        this.CustEmail = CustEmail;
    }
    public String getCustCorporation() {
        return CustCorporation;
    }

    public void setCustCorporation(String CustCorporation) {
        this.CustCorporation = CustCorporation;
    }
    public String getCustCapital() {
        return CustCapital;
    }

    public void setCustCapital(String CustCapital) {
        this.CustCapital = CustCapital;
    }
    public String getCustExplain() {
        return CustExplain;
    }

    public void setCustExplain(String CustExplain) {
        this.CustExplain = CustExplain;
    }

    @Override
    public String toString() {
        return "Customer{" +
        "CustId=" + CustId +
        ", BusId=" + BusId +
        ", ContractId=" + ContractId +
        ", ServiceId=" + ServiceId +
        ", MoneyId=" + MoneyId +
        ", CustName=" + CustName +
        ", CustSpell=" + CustSpell +
        ", CustClassify=" + CustClassify +
        ", CustSource=" + CustSource +
        ", CustTrade=" + CustTrade +
        ", CustUrl=" + CustUrl +
        ", CustCountry=" + CustCountry +
        ", CustCity=" + CustCity +
        ", CustAddress=" + CustAddress +
        ", CustPostCode=" + CustPostCode +
        ", CustFax=" + CustFax +
        ", CustLinkMan=" + CustLinkMan +
        ", CustDept=" + CustDept +
        ", CustJob=" + CustJob +
        ", CustOfficeTel=" + CustOfficeTel +
        ", CustPhone=" + CustPhone +
        ", CustEmail=" + CustEmail +
        ", CustCorporation=" + CustCorporation +
        ", CustCapital=" + CustCapital +
        ", CustExplain=" + CustExplain +
        "}";
    }
}
