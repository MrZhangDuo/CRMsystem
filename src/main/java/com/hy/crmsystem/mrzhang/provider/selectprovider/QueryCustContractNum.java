package com.hy.crmsystem.mrzhang.provider.selectProvider;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

public class QueryCustContractNum {

    public String queryCustContractNum(String custName){
        StringBuffer stringBuffer = new StringBuffer("SELECT con.`contractNum` FROM customer cust,contract con WHERE cust.`custId`=con.`custId` and  1=1 ");
        if(StringUtils.isNotEmpty(custName)){
            stringBuffer.append(" and  cust.`custName`='"+custName+"'");
        }
        return stringBuffer.toString();
    }

    public String queryAfterServiceById(String serviceId){
        return new StringBuffer("SELECT a.*,c.`custName` FROM afterservice a,customer c WHERE a.`custId`=c.`custId` AND a.`serviceId`='"+Integer.parseInt(serviceId)+"'").toString();
    }

}
