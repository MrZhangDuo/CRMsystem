package com.hy.crmsystem.mrli.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * @author licheng
 * @date 2020/4/16 10:08
 */
public class ShiroGetUserUtil {

    /**
     * shiro工具类 获取当前登录人
     */
    public static ActivierUser getUser() {
        Subject subject = SecurityUtils.getSubject();
        ActivierUser activierUser = (ActivierUser) subject.getPrincipal();
        return activierUser;
    }


}
