package com.hy.crmsystem.mrli.entity;

/**
 * 桌面统计的实体类
 *
 * @author licheng
 * @date 2020/4/16 9:40
 */
public class BaseEntity {

    private String name;
    private Double value;


    public BaseEntity(String name, Double value) {
        super();
        this.name = name;
        this.value = value;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }


}
