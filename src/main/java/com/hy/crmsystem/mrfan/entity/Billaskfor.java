package com.hy.crmsystem.mrfan.entity;

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
 */
@TableName("billaskfor")
public class Billaskfor implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "billId", type = IdType.AUTO)
    private Integer billId;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date Endtime;

    private String Address;

    private String AskForName;

    private String BillDept;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date AskFortime;

    private String BillTechnical;

    private String unitName;

    private String relevancyContract;

    private String billSort;

    private String taxpayernum;

    private String account;

    private String AdderssPhone;

    private String billMoney;

    private String MoneyBigwriter;

    private String billTime;

    private String billNum;

    private String file;

    public Date getEndtime() {
        return Endtime;
    }

    public void setEndtime(Date endtime) {
        Endtime = endtime;
    }

    public Date getAskFortime() {
        return AskFortime;
    }

    public void setAskFortime(Date askFortime) {
        AskFortime = askFortime;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }
    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    public String getAskForName() {
        return AskForName;
    }

    public void setAskForName(String AskForName) {
        this.AskForName = AskForName;
    }
    public String getBillDept() {
        return BillDept;
    }

    public void setBillDept(String BillDept) {
        this.BillDept = BillDept;
    }
    public String getBillTechnical() {
        return BillTechnical;
    }

    public void setBillTechnical(String BillTechnical) {
        this.BillTechnical = BillTechnical;
    }
    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
    public String getRelevancyContract() {
        return relevancyContract;
    }

    public void setRelevancyContract(String relevancyContract) {
        this.relevancyContract = relevancyContract;
    }
    public String getBillSort() {
        return billSort;
    }

    public void setBillSort(String billSort) {
        this.billSort = billSort;
    }
    public String getTaxpayernum() {
        return taxpayernum;
    }

    public void setTaxpayernum(String taxpayernum) {
        this.taxpayernum = taxpayernum;
    }
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
    public String getAdderssPhone() {
        return AdderssPhone;
    }

    public void setAdderssPhone(String AdderssPhone) {
        this.AdderssPhone = AdderssPhone;
    }
    public String getBillMoney() {
        return billMoney;
    }

    public void setBillMoney(String billMoney) {
        this.billMoney = billMoney;
    }
    public String getMoneyBigwriter() {
        return MoneyBigwriter;
    }

    public void setMoneyBigwriter(String MoneyBigwriter) {
        this.MoneyBigwriter = MoneyBigwriter;
    }
    public String getBillTime() {
        return billTime;
    }

    public void setBillTime(String billTime) {
        this.billTime = billTime;
    }
    public String getBillNum() {
        return billNum;
    }

    public void setBillNum(String billNum) {
        this.billNum = billNum;
    }
    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Billaskfor{" +
        "billId=" + billId +
        ", Endtime=" + Endtime +
        ", Address=" + Address +
        ", AskForName=" + AskForName +
        ", BillDept=" + BillDept +
        ", AskFortime=" + AskFortime +
        ", BillTechnical=" + BillTechnical +
        ", unitName=" + unitName +
        ", relevancyContract=" + relevancyContract +
        ", billSort=" + billSort +
        ", taxpayernum=" + taxpayernum +
        ", account=" + account +
        ", AdderssPhone=" + AdderssPhone +
        ", billMoney=" + billMoney +
        ", MoneyBigwriter=" + MoneyBigwriter +
        ", billTime=" + billTime +
        ", billNum=" + billNum +
        ", file=" + file +
        "}";
    }
}
