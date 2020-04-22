package com.hy.crmsystem.mrpan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 * 商机表*/


@TableName(value = "business")
public class Business implements Serializable {

    private static final long serialVersionUID = 1L;

   //商机id
    @TableId(value = "busId", type = IdType.AUTO)
    private Integer busId;
    @TableField("custId")
    private Integer custId;
    //商机名称
    @TableField("busName")
    private String busName;
    //商机来源
    @TableField("busSource")
    private String busSource;

    //预成交金额
    @TableField("busBeforeMoney")
    private Float busBeforeMoney;
   //预结单日期
   @TableField("busBeforedate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date busBeforedate;
    @TableField(exist = false)
    private String beForedate;
    //联系人
    @TableField("busBlinkMan")
    private String busBlinkMan;
    //部门
    @TableField("busDept")
    private String busDept;
    //职务
    @TableField("busJob")
    private String busJob;
    //固定电话
    @TableField("busFixnum")
    private String busFixnum;
    //移动电话
    @TableField("busPhone")
    private String busPhone;
    //邮件/QQ
    @TableField("busEmail")
    private String busEmail;
    //主要业务需求
    @TableField("busNeed")
    private String busNeed;
    //相关附件
    @TableField("busFile")
    private String busFile;
    //商机负责人
    @TableField("busDutyPeople")
    private String busDutyPeople;
    //商机产与人
    @TableField("busJoinPeople")
    private String busJoinPeople;
    //商机关注人
    @TableField("busFollowPeople")
    private String busFollowPeople;
    //商机阶段
    @TableField("busStage")
    private String busStage;
   // 添加商机的时间
   @TableField("busTime")
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date busTime;

   //商机的优先级
   @TableField("busPriority")
   private String busPriority;

    public String getBeForedate() {
        if(busBeforedate!=null){
            return new SimpleDateFormat("yyyy-MM-dd").format(busBeforedate);
        }
        return beForedate;
    }

    public Date getBusTime() {
        return busTime;
    }

    public void setBusTime(Date busTime) {
        this.busTime = busTime;
    }

    public void setBeForedate(String beForedate) {
        this.beForedate = beForedate;
    }

    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }


    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getBusSource() {
        return busSource;
    }

    public void setBusSource(String busSource) {
        this.busSource = busSource;
    }

    public Float getBusBeforeMoney() {
        return busBeforeMoney;
    }

    public void setBusBeforeMoney(Float busBeforeMoney) {
        this.busBeforeMoney = busBeforeMoney;
    }

    public Date getBusBeforedate() {
        return busBeforedate;
    }

    public void setBusBeforedate(Date busBeforedate) {
        this.busBeforedate = busBeforedate;
    }

    public String getBusBlinkMan() {
        return busBlinkMan;
    }

    public void setBusBlinkMan(String busBlinkMan) {
        this.busBlinkMan = busBlinkMan;
    }

    public String getBusDept() {
        return busDept;
    }

    public void setBusDept(String busDept) {
        this.busDept = busDept;
    }

    public String getBusJob() {
        return busJob;
    }

    public void setBusJob(String busJob) {
        this.busJob = busJob;
    }

    public String getBusFixnum() {
        return busFixnum;
    }

    public void setBusFixnum(String busFixnum) {
        this.busFixnum = busFixnum;
    }

    public String getBusPhone() {
        return busPhone;
    }

    public void setBusPhone(String busPhone) {
        this.busPhone = busPhone;
    }

    public String getBusEmail() {
        return busEmail;
    }

    public void setBusEmail(String busEmail) {
        this.busEmail = busEmail;
    }

    public String getBusNeed() {
        return busNeed;
    }

    public void setBusNeed(String busNeed) {
        this.busNeed = busNeed;
    }

    public String getBusFile() {
        return busFile;
    }

    public void setBusFile(String busFile) {
        this.busFile = busFile;
    }

    public String getBusDutyPeople() {
        return busDutyPeople;
    }

    public void setBusDutyPeople(String busDutyPeople) {
        this.busDutyPeople = busDutyPeople;
    }

    public String getBusJoinPeople() {
        return busJoinPeople;
    }

    public void setBusJoinPeople(String busJoinPeople) {
        this.busJoinPeople = busJoinPeople;
    }

    public String getBusFollowPeople() {
        return busFollowPeople;
    }

    public void setBusFollowPeople(String busFollowPeople) {
        this.busFollowPeople = busFollowPeople;
    }

    public String getBusStage() {
        return busStage;
    }

    public void setBusStage(String busStage) {
        this.busStage = busStage;
    }


    public String getBusPriority() {
        return busPriority;
    }

    public void setBusPriority(String busPriority) {
        this.busPriority = busPriority;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    @Override
    public String toString() {
        return "Business{" +
                "busId=" + busId +
                ", custId=" + custId +
                ", busName='" + busName + '\'' +
                ", busSource='" + busSource + '\'' +
                ", busBeforeMoney=" + busBeforeMoney +
                ", busBeforedate=" + busBeforedate +
                ", beForedate='" + beForedate + '\'' +
                ", busBlinkMan='" + busBlinkMan + '\'' +
                ", busDept='" + busDept + '\'' +
                ", busJob='" + busJob + '\'' +
                ", busFixnum='" + busFixnum + '\'' +
                ", busPhone='" + busPhone + '\'' +
                ", busEmail='" + busEmail + '\'' +
                ", busNeed='" + busNeed + '\'' +
                ", busFile='" + busFile + '\'' +
                ", busDutyPeople='" + busDutyPeople + '\'' +
                ", busJoinPeople='" + busJoinPeople + '\'' +
                ", busFollowPeople='" + busFollowPeople + '\'' +
                ", busStage='" + busStage + '\'' +
                ", busTime=" + busTime +
                ", busPriority='" + busPriority + '\'' +
                '}';
    }
}
