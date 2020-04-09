package com.hy.crmsystem.mrzhang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
@TableName("afterservice")
public class Afterservice implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "serviceId", type = IdType.AUTO)
    private Integer serviceId;

    @TableField("custId")
    private Integer custId;

    @TableField("serviceTheme")
    private String serviceTheme;

    @TableField("serviceContractNum")
    private String serviceContractNum;

    @TableField("serviceContractInfor")
    private String serviceContractInfor;

    @TableField("serviceLinkMan")
    private String serviceLinkMan;

    @TableField("fixNum")
    private String fixNum;

    @TableField("phone")
    private String phone;

    @TableField("email")
    private String Email;

    @TableField("serviceType")
    private String serviceType;

    @TableField("serviceMain")
    private String serviceMain;

    @TableField("serviceStartTime")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date serviceStartTime;

    @TableField(exist = false)
    private String StartTime;

    @TableField("serviceEndTime")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date serviceEndTime;

    @TableField(exist = false)
    private String EndTime;

    @TableField("serviceContent")
    private String ServiceContent;

    @TableField("custReturn")
    private String custReturn;

    @TableField("ServicePeople")
    private String ServicePeople;

    @TableField("servicesCore")
    private Integer servicesCore;

    @TableField("file")
    private String file;


    public String getStartTime() {
        if(serviceStartTime!=null){
            return  new SimpleDateFormat( "yyyy-MM-dd ").format(serviceStartTime);
        }else {
            return StartTime;
        }
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        if(serviceEndTime!=null){
            return  new SimpleDateFormat( "yyyy-MM-dd ").format(serviceEndTime);
        }else {
            return EndTime;
        }
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getServiceContent() {
        return ServiceContent;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getServiceTheme() {
        return serviceTheme;
    }

    public void setServiceTheme(String serviceTheme) {
        this.serviceTheme = serviceTheme;
    }

    public String getServiceContractNum() {
        return serviceContractNum;
    }

    public void setServiceContractNum(String serviceContractNum) {
        this.serviceContractNum = serviceContractNum;
    }

    public String getServiceContractInfor() {
        return serviceContractInfor;
    }

    public void setServiceContractInfor(String serviceContractInfor) {
        this.serviceContractInfor = serviceContractInfor;
    }

    public String getServiceLinkMan() {
        return serviceLinkMan;
    }

    public void setServiceLinkMan(String serviceLinkMan) {
        this.serviceLinkMan = serviceLinkMan;
    }

    public String getFixNum() {
        return fixNum;
    }

    public void setFixNum(String fixNum) {
        this.fixNum = fixNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceMain() {
        return serviceMain;
    }

    public void setServiceMain(String serviceMain) {
        this.serviceMain = serviceMain;
    }

    public Date getServiceStartTime() {
        return serviceStartTime;
    }

    public void setServiceStartTime(Date serviceStartTime) {
        this.serviceStartTime = serviceStartTime;
    }

    public Date getServiceEndTime() {
        return serviceEndTime;
    }

    public void setServiceEndTime(Date serviceEndTime) {
        this.serviceEndTime = serviceEndTime;
    }

    public void setServiceContent(String serviceContent) {
        ServiceContent = serviceContent;
    }

    public String getCustReturn() {
        return custReturn;
    }

    public void setCustReturn(String custReturn) {
        this.custReturn = custReturn;
    }

    public String getServicePeople() {
        return ServicePeople;
    }

    public void setServicePeople(String servicePeople) {
        ServicePeople = servicePeople;
    }

    public Integer getServicesCore() {
        return servicesCore;
    }

    public void setServicesCore(Integer servicesCore) {
        this.servicesCore = servicesCore;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Afterservice{" +
                "serviceId=" + serviceId +
                ", custId=" + custId +
                ", serviceTheme='" + serviceTheme + '\'' +
                ", serviceContractNum='" + serviceContractNum + '\'' +
                ", serviceContractInfor='" + serviceContractInfor + '\'' +
                ", serviceLinkMan='" + serviceLinkMan + '\'' +
                ", fixNum='" + fixNum + '\'' +
                ", phone='" + phone + '\'' +
                ", Email='" + Email + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", serviceMain='" + serviceMain + '\'' +
                ", serviceStartTime=" + serviceStartTime +
                ", StartTime='" + StartTime + '\'' +
                ", serviceEndTime=" + serviceEndTime +
                ", EndTime='" + EndTime + '\'' +
                ", ServiceContent='" + ServiceContent + '\'' +
                ", custReturn='" + custReturn + '\'' +
                ", ServicePeople='" + ServicePeople + '\'' +
                ", servicesCore=" + servicesCore +
                ", file='" + file + '\'' +
                '}';
    }
}
