package com.hy.crmsystem.mrli.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hy.crmsystem.mrli.entity.Loginfo;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author licheng
 * @date 2020/4/15 17:02
 */
public class LoginfoVo extends Loginfo {

    private String loginname;
    private String loginip;

    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date endTime;

    //接收多个id
    private Integer [] ids;


    @Override
    public String getLoginname() {
        return loginname;
    }

    @Override
    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    @Override
    public String getLoginip() {
        return loginip;
    }

    @Override
    public void setLoginip(String loginip) {
        this.loginip = loginip;
    }

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }
}
