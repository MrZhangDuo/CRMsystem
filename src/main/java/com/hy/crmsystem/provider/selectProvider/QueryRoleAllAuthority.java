package com.hy.crmsystem.provider.selectProvider;

import com.mysql.jdbc.StringUtils;
import org.apache.ibatis.annotations.Param;

public class QueryRoleAllAuthority {

    public String queryRoleAllAuthority(@Param(value = "account") String account){
        StringBuffer stringBuffer =
                new StringBuffer(" SELECT a.authorityaddress FROM USER u,role r,authority a,user_role ur,role_authority ra " +
                        " WHERE u.userid=ur.user_id " +
                        " AND r.roleid=ur.role_id " +
                        " AND r.roleid=ra.role_id " +
                        " AND a.authorityid=ra.authority_id   " +
                        " AND 1=1 ");
        if(!StringUtils.isNullOrEmpty(account)){
            stringBuffer.append(" and u.account='"+account+"' ");
        }
        return stringBuffer.toString();
    }
}
