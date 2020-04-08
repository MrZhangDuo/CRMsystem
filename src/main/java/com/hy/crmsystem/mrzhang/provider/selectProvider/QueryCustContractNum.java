package com.hy.crmsystem.mrzhang.provider.selectProvider;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.apache.ibatis.annotations.Param;

public class QueryCustContractNum {

    public String queryCustContractNum(String contractNum){
        StringBuffer stringBuffer = new StringBuffer("SELECT con.`ContractNum` FROM customer cust,contract con WHERE cust.`ContractId`=con.`ContractId` and  1=1 ");
        if(StringUtils.isNotEmpty(contractNum)){
            stringBuffer.append(" and  cust.`CustName`='"+contractNum+"'");
        }
        return stringBuffer.toString();
    }

}
