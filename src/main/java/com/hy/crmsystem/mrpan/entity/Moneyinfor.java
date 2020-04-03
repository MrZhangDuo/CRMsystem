package com.hy.crmsystem.mrpan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
public class Moneyinfor implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "MoneyId", type = IdType.AUTO)
    private Integer MoneyId;

    private String MoneyBankCard;

    private String MoneyBankName;

    private String Moneybank;

    /**
     * ˰
     */
    private String MoneyDutyNo;

    private String MoneyPhone;

    public Integer getMoneyId() {
        return MoneyId;
    }

    public void setMoneyId(Integer MoneyId) {
        this.MoneyId = MoneyId;
    }
    public String getMoneyBankCard() {
        return MoneyBankCard;
    }

    public void setMoneyBankCard(String MoneyBankCard) {
        this.MoneyBankCard = MoneyBankCard;
    }
    public String getMoneyBankName() {
        return MoneyBankName;
    }

    public void setMoneyBankName(String MoneyBankName) {
        this.MoneyBankName = MoneyBankName;
    }
    public String getMoneybank() {
        return Moneybank;
    }

    public void setMoneybank(String Moneybank) {
        this.Moneybank = Moneybank;
    }
    public String getMoneyDutyNo() {
        return MoneyDutyNo;
    }

    public void setMoneyDutyNo(String MoneyDutyNo) {
        this.MoneyDutyNo = MoneyDutyNo;
    }
    public String getMoneyPhone() {
        return MoneyPhone;
    }

    public void setMoneyPhone(String MoneyPhone) {
        this.MoneyPhone = MoneyPhone;
    }

    @Override
    public String toString() {
        return "Moneyinfor{" +
        "MoneyId=" + MoneyId +
        ", MoneyBankCard=" + MoneyBankCard +
        ", MoneyBankName=" + MoneyBankName +
        ", Moneybank=" + Moneybank +
        ", MoneyDutyNo=" + MoneyDutyNo +
        ", MoneyPhone=" + MoneyPhone +
        "}";
    }
}
