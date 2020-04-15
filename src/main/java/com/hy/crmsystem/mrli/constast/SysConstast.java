package com.hy.crmsystem.mrli.constast;

/**
 * @author licheng
 * @date 2020/4/9 9:11
 */
public interface SysConstast {

    /**
     * 默认密码配置
     */
    String USER_DEFAULT_PWD = "123456";

    /**
     * 可用类型
     */
    public static final Integer AVAILABLE_TRUE=1;
    public static final Integer AVAILABLE_FALSE=0;

    /**
     * 用户类型
     */
    Integer USER_TYPE_SUPER = 1;
    Integer USER_TYPE_NORMAL= 2;

    /**
     * 操作状态
     */
    String ADD_SUCCESS = "保存成功";
    String ADD_ERROR = "保存失败";

    String UPDATE_SUCCESS="更新成功";
    String UPDATE_ERROR="更新失败";

    String DELETE_SUCCESS="删除成功";
    String DELETE_ERROR="删除失败";

    String DISPATCH_SUCCESS="分配成功";
    String DISPATCH_ERROR="分配失败";


    /**
     * 操作成功
     */
    Integer CODE_SUCCESS = 0;
    /**
     * 失败
     */
    Integer CODE_ERROR = -1;

}
