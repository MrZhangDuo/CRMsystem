package com.hy.crmsystem.mrli.utils;

import com.hy.crmsystem.mrli.constast.SysConstast;

/**
 * @author licheng
 * @date 2020/4/9 9:13
 */
public class ResultObj {

    private Integer code=0;
    private String msg;

    /**
     * 保存成功
     */
    public static final ResultObj ADD_SUCCESS = new ResultObj(SysConstast.CODE_SUCCESS,SysConstast.ADD_SUCCESS);

    /**
     * 保存失败
     */
    public static final ResultObj ADD_ERROR = new ResultObj(SysConstast.CODE_ERROR, SysConstast.ADD_ERROR);


    public ResultObj(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultObj(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
