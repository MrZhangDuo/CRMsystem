package com.hy.crmsystem.mrpan.entity;

import java.util.Date;

public class AfterServiceNum {
    //客户id
    private Integer custId;
    //服务主题
    private String serviceTheme;
    //服务类型
    private String serviceType;
    //服务时间
    private Date serviceStartTime;
    //服务人
    private String servicePeople;
    //服务评分
    private Double servicesCore;

    public String getServiceTheme() {
        return serviceTheme;
    }

    public void setServiceTheme(String serviceTheme) {
        this.serviceTheme = serviceTheme;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Date getServiceStartTime() {
        return serviceStartTime;
    }

    public void setServiceStartTime(Date serviceStartTime) {
        this.serviceStartTime = serviceStartTime;
    }

    public String getServicePeople() {
        return servicePeople;
    }

    public void setServicePeople(String servicePeople) {
        this.servicePeople = servicePeople;
    }

    public Double getServicesCore() {
        return servicesCore;
    }

    public void setServicesCore(Double servicesCore) {
        this.servicesCore = servicesCore;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    @Override
    public String toString() {
        return "AfterService{" +
                "custId=" + custId +
                ", serviceTheme='" + serviceTheme + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", serviceStartTime=" + serviceStartTime +
                ", servicePeople='" + servicePeople + '\'' +
                ", servicesCore=" + servicesCore +
                '}';
    }
}
