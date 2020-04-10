package com.hy.crmsystem.mrli.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hy.crmsystem.mrli.entity.BaseEntity;
import com.hy.crmsystem.mrli.entity.Documentary;
import org.springframework.format.annotation.DateTimeFormat;
import sun.plugin.dom.core.Document;

import java.util.Date;

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
