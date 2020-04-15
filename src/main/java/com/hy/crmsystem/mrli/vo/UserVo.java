package com.hy.crmsystem.mrli.vo;

import com.hy.crmsystem.mrli.entity.User;

/**
 * @author licheng
 * @date 2020/4/11 9:02
 */
public class UserVo extends User {

    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;

    private String code;

    /**
     * 接受多个角色id
     */
    private Integer[] ids;


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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }
}
