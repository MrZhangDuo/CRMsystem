package com.hy.crmsystem.mrzhang.entity;

public class Andition {
    private Integer chulizhong;
    private Integer jieshu;
    private Integer chechu;
    private Integer zhixing;
    private Integer guanbi;
    private Integer gezhi;
    private Integer benzhou;
    private Integer shangzhou;
    private Integer benyue;
    private Integer shangyue;
    private Integer benji;
    private Integer shangji;

    public Andition(Integer chechu, Integer zhixing, Integer guanbi, Integer gezhi, Integer benzhou, Integer shangzhou, Integer benyue, Integer shangyue, Integer benji, Integer shangji) {
        this.chechu = chechu;
        this.zhixing = zhixing;
        this.guanbi = guanbi;
        this.gezhi = gezhi;
        this.benzhou = benzhou;
        this.shangzhou = shangzhou;
        this.benyue = benyue;
        this.shangyue = shangyue;
        this.benji = benji;
        this.shangji = shangji;
    }


    public Andition(Integer chulizhong, Integer chechu, Integer jieshu, Integer benzhou, Integer shangzhou, Integer benyue, Integer shangyue, Integer benji, Integer shangji) {
        this.chulizhong = chulizhong;
        this.chechu = chechu;
        this.jieshu = jieshu;
        this.benzhou = benzhou;
        this.shangzhou = shangzhou;
        this.benyue = benyue;
        this.shangyue = shangyue;
        this.benji = benji;
        this.shangji = shangji;
    }

    public Integer getZhixing() {
        return zhixing;
    }

    public void setZhixing(Integer zhixing) {
        this.zhixing = zhixing;
    }

    public Integer getGuanbi() {
        return guanbi;
    }

    public void setGuanbi(Integer guanbi) {
        this.guanbi = guanbi;
    }

    public Integer getGezhi() {
        return gezhi;
    }

    public void setGezhi(Integer gezhi) {
        this.gezhi = gezhi;
    }

    public Integer getBenzhou() {
        return benzhou;
    }

    public void setBenzhou(Integer benzhou) {
        this.benzhou = benzhou;
    }

    public Integer getShangzhou() {
        return shangzhou;
    }

    public void setShangzhou(Integer shangzhou) {
        this.shangzhou = shangzhou;
    }

    public Integer getBenyue() {
        return benyue;
    }

    public void setBenyue(Integer benyue) {
        this.benyue = benyue;
    }

    public Integer getShangyue() {
        return shangyue;
    }

    public void setShangyue(Integer shangyue) {
        this.shangyue = shangyue;
    }

    public Integer getBenji() {
        return benji;
    }

    public void setBenji(Integer benji) {
        this.benji = benji;
    }

    public Integer getShangji() {
        return shangji;
    }

    public void setShangji(Integer shangji) {
        this.shangji = shangji;
    }

    public Integer getChulizhong() {
        return chulizhong;
    }

    public void setChulizhong(Integer chulizhong) {
        this.chulizhong = chulizhong;
    }

    public Integer getChechu() {
        return chechu;
    }

    public void setChechu(Integer chechu) {
        this.chechu = chechu;
    }

    public Integer getJieshu() {
        return jieshu;
    }

    public void setJieshu(Integer jieshu) {
        this.jieshu = jieshu;
    }
}
