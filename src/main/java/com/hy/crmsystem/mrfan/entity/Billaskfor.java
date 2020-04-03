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
    //结束时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date Endtime;
    //详细地址
    private String Address;
    //申请人姓名
    private String AskForName;
    //所属部门
    private String BillDept;
    //申请日期
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date AskFortime;
    //主要技术条款
    private String BillTechnical;
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
    private String AdderssPhone;
    //开票金额
    private String billMoney;
    //金额大写
    private String MoneyBigwriter;
    //开票日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date billTime;
    //发票号码
    private String billNum;
    //相关附件
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

    public void setMoneyBigwriter(String moneyBigwriter) {
        MoneyBigwriter = moneyBigwriter;
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
                ", Endtime=" + Endtime +
                ", Address='" + Address + '\'' +
                ", AskForName='" + AskForName + '\'' +
                ", BillDept='" + BillDept + '\'' +
                ", AskFortime=" + AskFortime +
                ", BillTechnical='" + BillTechnical + '\'' +
                ", unitName='" + unitName + '\'' +
                ", relevancyContract='" + relevancyContract + '\'' +
                ", billSort='" + billSort + '\'' +
                ", taxpayernum='" + taxpayernum + '\'' +
                ", account='" + account + '\'' +
                ", AdderssPhone='" + AdderssPhone + '\'' +
                ", billMoney='" + billMoney + '\'' +
                ", MoneyBigwriter='" + MoneyBigwriter + '\'' +
                ", billTime=" + billTime +
                ", billNum='" + billNum + '\'' +
                ", file='" + file + '\'' +
                '}';
    }
}
