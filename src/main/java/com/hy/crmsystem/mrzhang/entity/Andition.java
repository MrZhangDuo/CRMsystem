package com.hy.crmsystem.mrzhang.entity;

public class Andition {
    private Integer chulizhong;
    private Integer chechu;
    private Integer jieshu;

    public Andition(Integer chulizhong, Integer chechu, Integer jieshu) {
        this.chulizhong = chulizhong;
        this.chechu = chechu;
        this.jieshu = jieshu;
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
