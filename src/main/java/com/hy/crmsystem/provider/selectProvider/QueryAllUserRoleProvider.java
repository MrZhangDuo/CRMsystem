package com.hy.crmsystem.provider.selectProvider;

import com.mysql.jdbc.StringUtils;
import org.apache.ibatis.annotations.Param;

public class QueryAllUserRoleProvider {
    public String queryAllUserRoleProvider(@Param(value = "account") String account){
        StringBuffer stringBuffer = new StringBuffer("SELECT r.rolename FROM USER u,role r,user_role ur WHERE u.userid=ur.user_id AND r.roleid=ur.role_id AND 1=1 ");
        if(!StringUtils.isNullOrEmpty(account)){
            stringBuffer.append(" and u.account='"+account+"'");
        }
        return stringBuffer.toString();
    }
}
