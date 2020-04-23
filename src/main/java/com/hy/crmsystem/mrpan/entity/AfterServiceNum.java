package com.hy.crmsystem.mrpan.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AfterServiceNum {
    //客户id
    private Integer custId;
    //服务主题
    private Integer serviceId;
    private String serviceTheme;
    //服务类型
    private String serviceType;
    //服务时间
    @DateTimeFormat(pattern ="yyyy-MM-dd hh:mm:ss")
    private Date serviceStartTime;
    private String StartTime;
    //服务人
    private String servicePeople;
    //服务评分
    private Double servicesCore;

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

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

    public String getStartTime() {
        if(serviceStartTime!=null){
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(serviceStartTime);
        }else {
            return StartTime;
        }

    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
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

    @Override
    public String toString() {
        return "AfterServiceNum{" +
                "custId=" + custId +
                ", serviceTheme='" + serviceTheme + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", serviceStartTime=" + serviceStartTime +
                ", StartTime='" + StartTime + '\'' +
                ", servicePeople='" + servicePeople + '\'' +
                ", servicesCore=" + servicesCore +
                '}';
    }
}
