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
    //开票主键
    @TableId(value = "billId", type = IdType.AUTO)
    private Integer billId;
    //合同外键
    private Integer contractId;
    //结束时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endtime;
    //详细地址
    private String address;
    //申请人姓名
    private String askForName;
    //所属部门
    private String BillDept;
    //申请日期
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date askFortime;
    //主要技术条款
    private String billTechnical;
    //对方单位全称
    private String unitName;
    //关联合同图片
    private String relevancyContract;
    //开票种类
    private String billSort;
    //纳税人识别号
    private String taxpayernum;
    //开户银行及账号
    private String account;
    //地址电话
    private String adderssPhone;
    //开票金额
    private String billMoney;
    //金额大写
    private String moneyBigwriter;
    //开票日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date billTime;
    //发票号码
    private String billNum;
    //相关附件
    private String file;

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAskForName() {
        return askForName;
    }

    public void setAskForName(String askForName) {
        this.askForName = askForName;
    }

    public String getBillDept() {
        return BillDept;
    }

    public void setBillDept(String billDept) {
        BillDept = billDept;
    }

    public Date getAskFortime() {
        return askFortime;
    }

    public void setAskFortime(Date askFortime) {
        this.askFortime = askFortime;
    }

    public String getBillTechnical() {
        return billTechnical;
    }

    public void setBillTechnical(String billTechnical) {
        this.billTechnical = billTechnical;
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
        return adderssPhone;
    }

    public void setAdderssPhone(String adderssPhone) {
        this.adderssPhone = adderssPhone;
    }

    public String getBillMoney() {
        return billMoney;
    }

    public void setBillMoney(String billMoney) {
        this.billMoney = billMoney;
    }

    public String getMoneyBigwriter() {
        return moneyBigwriter;
    }

    public void setMoneyBigwriter(String moneyBigwriter) {
        this.moneyBigwriter = moneyBigwriter;
    }

    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
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
                ", contractId=" + contractId +
                ", endtime=" + endtime +
                ", address='" + address + '\'' +
                ", askForName='" + askForName + '\'' +
                ", BillDept='" + BillDept + '\'' +
                ", askFortime=" + askFortime +
                ", billTechnical='" + billTechnical + '\'' +
                ", unitName='" + unitName + '\'' +
                ", relevancyContract='" + relevancyContract + '\'' +
                ", billSort='" + billSort + '\'' +
                ", taxpayernum='" + taxpayernum + '\'' +
                ", account='" + account + '\'' +
                ", adderssPhone='" + adderssPhone + '\'' +
                ", billMoney='" + billMoney + '\'' +
                ", moneyBigwriter='" + moneyBigwriter + '\'' +
                ", billTime=" + billTime +
                ", billNum='" + billNum + '\'' +
                ", file='" + file + '\'' +
                '}';
    }
}
