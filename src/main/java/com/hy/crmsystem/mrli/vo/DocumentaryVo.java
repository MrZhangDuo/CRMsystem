package com.hy.crmsystem.mrli.vo;

import com.hy.crmsystem.mrli.entity.Documentary;

/**
 * @author licheng
 * @date 2020/4/6 20:51
 */
public class DocumentaryVo extends Documentary {


    /**
     * 分页参数
     */
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
