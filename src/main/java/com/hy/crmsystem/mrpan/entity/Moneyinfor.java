package com.hy.crmsystem.mrpan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
@TableName(value = "moneyinfor")
public class Moneyinfor implements Serializable {

    private static final long serialVersionUID = 1L;

    //财务主键
    @TableId(value = "moneyId", type = IdType.AUTO)
    private Integer moneyId;
    //银行卡号
    @TableField("moneyBankCard")
    private String moneyBankCard;
    //开户名称
    @TableField("moneyBankName")
    private String moneyBankName;
    //开户银行
    @TableField("moneybank")
    private String moneybank;
    //税号
    @TableField("moneyDutyNo")
    private String moneyDutyNo;
    //电话
    @TableField("moneyPhone")
    private String moneyPhone;

    //银行地址
    @TableField("moneyAddress")
    private String moneyAddress;

    public Integer getMoneyId() {
        return moneyId;
    }

    public void setMoneyId(Integer moneyId) {
        this.moneyId = moneyId;
    }

    public String getMoneyBankCard() {
        return moneyBankCard;
    }

    public void setMoneyBankCard(String moneyBankCard) {
        this.moneyBankCard = moneyBankCard;
    }

    public String getMoneyBankName() {
        return moneyBankName;
    }

    public void setMoneyBankName(String moneyBankName) {
        this.moneyBankName = moneyBankName;
    }

    public String getMoneybank() {
        return moneybank;
    }

    public void setMoneybank(String moneybank) {
        this.moneybank = moneybank;
    }

    public String getMoneyDutyNo() {
        return moneyDutyNo;
    }

    public void setMoneyDutyNo(String moneyDutyNo) {
        this.moneyDutyNo = moneyDutyNo;
    }

    public String getMoneyPhone() {
        return moneyPhone;
    }

    public void setMoneyPhone(String moneyPhone) {
        this.moneyPhone = moneyPhone;
    }

    public String getMoneyAddress() {
        return moneyAddress;
    }

    public void setMoneyAddress(String moneyAddress) {
        this.moneyAddress = moneyAddress;
    }

    @Override
    public String toString() {
        return "Moneyinfor{" +
                "moneyId=" + moneyId +
                ", moneyBankCard='" + moneyBankCard + '\'' +
                ", moneyBankName='" + moneyBankName + '\'' +
                ", moneybank='" + moneybank + '\'' +
                ", moneyDutyNo='" + moneyDutyNo + '\'' +
                ", moneyPhone='" + moneyPhone + '\'' +
                ", moneyAddress='" + moneyAddress + '\'' +
                '}';
    }
}
