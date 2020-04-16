package com.hy.crmsystem.mrpan.entity;

public class CustomerBo {
    private Integer custId;
    private String custName;
    private Integer busId;
    private Double busBeforeMoney;
    private Integer contractId;
    private Double contractMoney;
    private Double incomesMoney;
    private Integer serviceId;
    private Float servicesCore;
    //客户分类
    private String custClassify;
    //客户姓名拼音
    private String custSpell;
    //客户来源
    private String custSource;
    //客户行业
    private String custTrade;
    //客户国家/地区
    private String custCountry;
    //客户城市
    private String custCity;

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    public Double getBusBeforeMoney() {
        return busBeforeMoney;
    }

    public void setBusBeforeMoney(Double busBeforeMoney) {
        this.busBeforeMoney = busBeforeMoney;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Double getContractMoney() {
        return contractMoney;
    }

    public void setContractMoney(Double contractMoney) {
        this.contractMoney = contractMoney;
    }

    public Double getIncomesMoney() {
        return incomesMoney;
    }

    public void setIncomesMoney(Double incomesMoney) {
        this.incomesMoney = incomesMoney;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Float getServicesCore() {
        return servicesCore;
    }

    public void setServicesCore(Float servicesCore) {
        this.servicesCore = servicesCore;
    }
    public String getCustSpell() {
        return custSpell;
    }

    public void setCustSpell(String custSpell) {
        this.custSpell = custSpell;
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

    public String getCustClassify() {
        return custClassify;
    }

    public void setCustClassify(String custClassify) {
        this.custClassify = custClassify;
    }
}
