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

    @TableId(value = "ServiceId", type = IdType.AUTO)
    private Integer ServiceId;

    @TableField("ServiceTheme")
    private String ServiceTheme;

    @TableField("ServiceCustName")
    private String ServiceCustName;

    @TableField("ServiceContractNum")
    private String ServiceContractNum;

    @TableField("ServiceContractInfor")
    private String ServiceContractInfor;

    @TableField("ServiceLinkMan")
    private String ServiceLinkMan;

    @TableField("FixNum")
    private String FixNum;

    @TableField("Phone")
    private String Phone;

    @TableField("Email")
    private String Email;

    @TableField("ServiceType")
    private String ServiceType;

    @TableField("ServiceMain")
    private String ServiceMain;

    @TableField("ServiceStartTime")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date ServiceStartTime;

    @TableField(exist = false)
    private String StartTime;

    @TableField("ServiceEndTime")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date ServiceEndTime;

    @TableField("ServiceContent")
    private String ServiceContent;

    @TableField("CustReturn")
    private String CustReturn;

    @TableField("ServicePeople")
    private String ServicePeople;

    @TableField("ServicesCore")
    private Integer ServicesCore;

    @TableField("File")
    private String File;

    public Afterservice(){}

    public String getStartTime() {
        if(ServiceStartTime!=null){
            return  new SimpleDateFormat( "yyyy-MM-dd ").format(ServiceStartTime);
        }else {
            return StartTime;
        }
    }

    public void setStartTime(Date ServiceStartTime) {
        StartTime = new SimpleDateFormat( "yyyy-MM-dd ").format(ServiceStartTime);
    }



    public String getServiceContent() {
        return ServiceContent;
    }

    public Integer getServiceId() {
        return ServiceId;
    }

    public void setServiceId(Integer ServiceId) {
        this.ServiceId = ServiceId;
    }

    public String getServiceTheme() {
        return ServiceTheme;
    }

    public void setServiceTheme(String serviceTheme) {
        ServiceTheme = serviceTheme;
    }

    public String getServiceCustName() {
        return ServiceCustName;
    }

    public void setServiceCustName(String serviceCustName) {
        ServiceCustName = serviceCustName;
    }

    public String getServiceContractNum() {
        return ServiceContractNum;
    }

    public void setServiceContractNum(String ServiceContractNum) {
        this.ServiceContractNum = ServiceContractNum;
    }
    public String getServiceContractInfor() {
        return ServiceContractInfor;
    }

    public void setServiceContractInfor(String ServiceContractInfor) {
        this.ServiceContractInfor = ServiceContractInfor;
    }
    public String getServiceLinkMan() {
        return ServiceLinkMan;
    }

    public void setServiceLinkMan(String ServiceLinkMan) {
        this.ServiceLinkMan = ServiceLinkMan;
    }
    public String getFixNum() {
        return FixNum;
    }

    public void setFixNum(String FixNum) {
        this.FixNum = FixNum;
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
    public String getServiceType() {
        return ServiceType;
    }

    public void setServiceType(String ServiceType) {
        this.ServiceType = ServiceType;
    }
    public String getServiceMain() {
        return ServiceMain;
    }

    public void setServiceMain(String ServiceMain) {
        this.ServiceMain = ServiceMain;
    }

    public Date getServiceStartTime() {
        return ServiceStartTime;
    }

    public void setServiceStartTime(Date serviceStartTime) {
        ServiceStartTime = serviceStartTime;
    }

    public Date getServiceEndTime() {
        return ServiceEndTime;
    }

    public void setServiceEndTime(Date serviceEndTime) {
        ServiceEndTime = serviceEndTime;
    }

    public void setServiceContent(String ServiceContent) {
        this.ServiceContent = ServiceContent;
    }
    public String getCustReturn() {
        return CustReturn;
    }

    public void setCustReturn(String CustReturn) {
        this.CustReturn = CustReturn;
    }
    public String getServicePeople() {
        return ServicePeople;
    }

    public void setServicePeople(String ServicePeople) {
        this.ServicePeople = ServicePeople;
    }
    public Integer getServicesCore() {
        return ServicesCore;
    }

    public void setServicesCore(Integer ServicesCore) {
        this.ServicesCore = ServicesCore;
    }
    public String getFile() {
        return File;
    }

    public void setFile(String File) {
        this.File = File;
    }

    @Override
    public String toString() {
        return "Afterservice{" +
        "ServiceId=" + ServiceId +
        ", ServiceTheme=" + ServiceTheme +
        ", ServiceCustName=" + ServiceCustName +
        ", ServiceContractNum=" + ServiceContractNum +
        ", ServiceContractInfor=" + ServiceContractInfor +
        ", ServiceLinkMan=" + ServiceLinkMan +
        ", FixNum=" + FixNum +
        ", Phone=" + Phone +
        ", Email=" + Email +
        ", ServiceType=" + ServiceType +
        ", ServiceMain=" + ServiceMain +
        ", ServiceStartTime=" + ServiceStartTime +
        ", ServiceEndTime=" + ServiceEndTime +
        ", ServiceContent=" + ServiceContent +
        ", CustReturn=" + CustReturn +
        ", ServicePeople=" + ServicePeople +
        ", ServicesCore=" + ServicesCore +
        ", File=" + File +
        "}";
    }

}
