package com.hy.crmsystem.provider.selectProvider;

import com.mysql.jdbc.StringUtils;
import org.apache.ibatis.annotations.Param;

public class QueryUserAllAuthority {

    public String queryUserAllAuthority(@Param(value = "account") String account){
        StringBuffer stringBuffer =
                new StringBuffer(" SELECT a.authorityaddress FROM  USER u,authority  a,user_authority ua " +
                        "WHERE u.userid=ua.user_id " +
                        " AND a.authorityid=ua.anthority_id  " +
                        " AND 1=1 ");
        if(!StringUtils.isNullOrEmpty(account)){
            stringBuffer.append(" and u.account='"+account+"' ");
        }
        return stringBuffer.toString();
    }
}
