package com.hy.crmsystem.mrfan.provider.selectProvider;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.hy.crmsystem.mrfan.entity.InvitationBo;
import org.apache.ibatis.annotations.Param;

public class QueryMyContract {
    public String querymy(){
        StringBuffer sql=new StringBuffer("SELECT c.contractName,c.contractNum,c.contractMoney,m.incomesMoney,b.billMoney,c.signedTime FROM contract c,moneyregister m,billaskfor b WHERE m.incomeId=c.custId AND b.contractId=c.contractId");
        return sql.toString();
    }
}

