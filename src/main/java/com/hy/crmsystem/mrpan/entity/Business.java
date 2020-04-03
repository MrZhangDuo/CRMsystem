package com.hy.crmsystem.mrpan.entity;

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
 * 商机表
 */
@TableName(value = "business")
public class Business implements Serializable {

    private static final long serialVersionUID = 1L;

   //商机id
    @TableId(value = "BusId", type = IdType.AUTO)
    private Integer BusId;

    private Integer DocId;

    private Integer InvitationId;

    private Integer baseId;

    private byte[] BusName;

    private Integer BusSource;


    private String BusBeforeMoney;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date BusBeforedate;

    private String BusBlinkMan;

    private String BusDept;

    private String BusJob;

    private String BusFixnum;

    private String BusPhone;

    private String BusEmail;

    private String BusNeed;

    private String BusFile;

    private String BusDutyPeople;

    private String BusJoinPeople;

    private String BusFollowPeople;

    private String BusStage;

    public Integer getBusId() {
        return BusId;
    }

    public void setBusId(Integer BusId) {
        this.BusId = BusId;
    }
    public Integer getDocId() {
        return DocId;
    }

    public void setDocId(Integer DocId) {
        this.DocId = DocId;
    }
    public Integer getInvitationId() {
        return InvitationId;
    }

    public void setInvitationId(Integer InvitationId) {
        this.InvitationId = InvitationId;
    }
    public Integer getBaseId() {
        return baseId;
    }

    public void setBaseId(Integer baseId) {
        this.baseId = baseId;
    }
    public byte[] getBusName() {
        return BusName;
    }

    public void setBusName(byte[] BusName) {
        this.BusName = BusName;
    }
    public Integer getBusSource() {
        return BusSource;
    }

    public void setBusSource(Integer BusSource) {
        this.BusSource = BusSource;
    }
    public String getBusBeforeMoney() {
        return BusBeforeMoney;
    }

    public Date getBusBeforedate() {
        return BusBeforedate;
    }

    public void setBusBeforedate(Date busBeforedate) {
        BusBeforedate = busBeforedate;
    }

    public void setBusBlinkMan(String BusBlinkMan) {
        this.BusBlinkMan = BusBlinkMan;
    }
    public String getBusDept() {
        return BusDept;
    }

    public void setBusDept(String BusDept) {
        this.BusDept = BusDept;
    }
    public String getBusJob() {
        return BusJob;
    }

    public void setBusJob(String BusJob) {
        this.BusJob = BusJob;
    }
    public String getBusFixnum() {
        return BusFixnum;
    }

    public void setBusFixnum(String BusFixnum) {
        this.BusFixnum = BusFixnum;
    }
    public String getBusPhone() {
        return BusPhone;
    }

    public void setBusPhone(String BusPhone) {
        this.BusPhone = BusPhone;
    }
    public String getBusEmail() {
        return BusEmail;
    }

    public void setBusEmail(String BusEmail) {
        this.BusEmail = BusEmail;
    }
    public String getBusNeed() {
        return BusNeed;
    }

    public void setBusNeed(String BusNeed) {
        this.BusNeed = BusNeed;
    }
    public String getBusFile() {
        return BusFile;
    }

    public void setBusFile(String BusFile) {
        this.BusFile = BusFile;
    }
    public String getBusDutyPeople() {
        return BusDutyPeople;
    }

    public void setBusDutyPeople(String BusDutyPeople) {
        this.BusDutyPeople = BusDutyPeople;
    }
    public String getBusJoinPeople() {
        return BusJoinPeople;
    }

    public void setBusJoinPeople(String BusJoinPeople) {
        this.BusJoinPeople = BusJoinPeople;
    }
    public String getBusFollowPeople() {
        return BusFollowPeople;
    }

    public void setBusFollowPeople(String BusFollowPeople) {
        this.BusFollowPeople = BusFollowPeople;
    }
    public String getBusStage() {
        return BusStage;
    }

    public void setBusStage(String BusStage) {
        this.BusStage = BusStage;
    }

    @Override
    public String toString() {
        return "Business{" +
        "BusId=" + BusId +
        ", DocId=" + DocId +
        ", InvitationId=" + InvitationId +
        ", baseId=" + baseId +
        ", BusName=" + BusName +
        ", BusSource=" + BusSource +
        ", BusBeforeMoney=" + BusBeforeMoney +
        ", BusBeforedate=" + BusBeforedate +
        ", BusBlinkMan=" + BusBlinkMan +
        ", BusDept=" + BusDept +
        ", BusJob=" + BusJob +
        ", BusFixnum=" + BusFixnum +
        ", BusPhone=" + BusPhone +
        ", BusEmail=" + BusEmail +
        ", BusNeed=" + BusNeed +
        ", BusFile=" + BusFile +
        ", BusDutyPeople=" + BusDutyPeople +
        ", BusJoinPeople=" + BusJoinPeople +
        ", BusFollowPeople=" + BusFollowPeople +
        ", BusStage=" + BusStage +
        "}";
    }
}
