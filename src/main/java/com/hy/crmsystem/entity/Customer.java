package com.hy.crmsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "CustId", type = IdType.AUTO)
    private Integer CustId;

    private Integer BusId;

    private Integer ContractId;

    private Integer ServiceId;

    private Integer MoneyId;

    private String CustName;

    private String CustSpell;

    private Integer CustClassify;

    private Integer CustSource;

    private String CustTrade;

    private String CustUrl;

    private String CustCountry;

    private String CustCity;

    private String CustAddress;

    private String CustPostCode;

    private String CustFax;

    private String CustLinkMan;

    private String CustDept;

    /**
     * ְ
     */
    private String CustJob;

    private String CustOfficeTel;

    private String CustPhone;

    private String CustEmail;

    private String CustCorporation;

    /**
     * ע
     */
    private String CustCapital;

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
    public Integer getCustClassify() {
        return CustClassify;
    }

    public void setCustClassify(Integer CustClassify) {
        this.CustClassify = CustClassify;
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
