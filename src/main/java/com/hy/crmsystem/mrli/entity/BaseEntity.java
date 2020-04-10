package com.hy.crmsystem.mrli.entity;

/**
 * @author licheng
 * @date 2020/4/4 18:34
 */
public class BaseEntity {
    private Integer page;
    private Integer limit;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
