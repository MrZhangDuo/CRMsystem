package com.hy.crmsystem.mrli.utils;

import com.hy.crmsystem.mrli.constast.SysConstast;

/**
 * @author licheng
 * @date 2020/4/9 9:13
 */
public class ResultObj {

    private Integer code=200;
    private String msg;
    private String token = "";

    /**
     * 保存成功
     */
    public static final ResultObj ADD_SUCCESS = new ResultObj(SysConstast.CODE_SUCCESS,SysConstast.ADD_SUCCESS);

    /**
     * 保存失败
     */
    public static final ResultObj ADD_ERROR = new ResultObj(SysConstast.CODE_ERROR, SysConstast.ADD_ERROR);

    /**
     * 更新成功
     */
    public static final ResultObj UPDATE_SUCCESS=new ResultObj(SysConstast.CODE_SUCCESS, SysConstast.UPDATE_SUCCESS);
    /**
     * 更新失败
     */
    public static final ResultObj UPDATE_ERROR=new ResultObj(SysConstast.CODE_ERROR, SysConstast.UPDATE_ERROR);

    /**
     * 删除成功
     */
    public static final ResultObj DELETE_SUCCESS=new ResultObj(SysConstast.CODE_SUCCESS, SysConstast.DELETE_SUCCESS);
    /**
     * 删除失败
     */
    public static final ResultObj DELETE_ERROR=new ResultObj(SysConstast.CODE_ERROR, SysConstast.DELETE_ERROR);

    /**
     * 分配成功
     */
    public static final ResultObj DISPATCH_SUCCESS=new ResultObj(SysConstast.CODE_SUCCESS, SysConstast.DISPATCH_SUCCESS);
    /**
     * 分配失败
     */
    public static final ResultObj DISPATCH_ERROR=new ResultObj(SysConstast.CODE_ERROR, SysConstast.DISPATCH_ERROR);



    public ResultObj(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultObj(Integer code, String msg, String token) {
        this.code = code;
        this.msg = msg;
        this.token = token;
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
