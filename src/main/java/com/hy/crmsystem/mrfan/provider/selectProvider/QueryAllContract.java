package com.hy.crmsystem.mrfan.provider.selectProvider;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.hy.crmsystem.mrfan.entity.Contract;
import com.hy.crmsystem.mrfan.entity.QueryType;
import com.hy.crmsystem.mrzhang.entity.Andition;
import org.apache.ibatis.annotations.Param;

public class QueryAllContract {
    public String queryAllContract(@Param("currentName")String currentName, @Param("contract") Contract contract, @Param("queryType") QueryType queryType){
        StringBuffer sql=new StringBuffer("SELECT con.*,cm.incomesMoney,cb.billMoney FROM  contract con LEFT JOIN \n" +
                "                (SELECT c.contractId,SUM(m.`incomesMoney`)AS incomesMoney FROM contract c LEFT JOIN moneyregister m ON c.`contractId`=m.`contractId` GROUP BY m.`contractId`)\n" +
                "                AS cm ON cm.contractId=con.`contractId` LEFT JOIN \n" +
                "                (SELECT c.contractId,SUM(b.billMoney)AS billMoney FROM contract c LEFT JOIN billaskfor b ON c.`contractId`=b.`contractId` GROUP BY b.contractId)\n" +
                "                AS cb ON cb.contractId=con.`contractId` LEFT JOIN customer cust ON con.custId=cust.custId WHERE 1=1  ");
        if(StringUtils.isNotEmpty(currentName)){
            sql.append(" and con.relevancyPeople like '%"+currentName+"%'");
        }
        if(StringUtils.isNotEmpty(contract.getCustName())){
            sql.append(" AND cust.custName like'%"+contract.getCustName()+"%'");
        }
        if(null!=contract.getSignedTime()){
            sql.append(" AND con.signedTime >='"+contract.getSignedTime()+"'");
        }
        if(StringUtils.isNotEmpty(contract.getContractName())){
            sql.append(" AND con.contractName like '%"+contract.getContractName()+"%'");
        }
        if(StringUtils.isNotEmpty(queryType.getZhixing())&&queryType.getZhixing().equals("zhixing")){
            sql.append(" AND con.contractzhuangtai='执行'");
        }else if (StringUtils.isNotEmpty(queryType.getChechu())&&queryType.getChechu().equals("chechu")){
            sql.append(" AND con.contractzhuangtai='撤除'");
        }else if (StringUtils.isNotEmpty(queryType.getGuanbi())&&queryType.getGuanbi().equals("guanbi")){
            sql.append(" AND con.contractzhuangtai='关闭'");
        }else if (StringUtils.isNotEmpty(queryType.getGezhi())&&queryType.getGezhi().equals("gezhi")){
            sql.append(" AND con.contractzhuangtai='搁置'");
        }else if (StringUtils.isNotEmpty(queryType.getBenzhou())&&queryType.getBenzhou().equals("benzhou")){
            sql.append(" AND con.signedTime=YEARWEEK(NOW())");
        }else if (StringUtils.isNotEmpty(queryType.getShangzhou())&&queryType.getShangzhou().equals("shangzhou")){
            sql.append(" AND con.signedTime=YEARWEEK(NOW())-1");
        }else if (StringUtils.isNotEmpty(queryType.getBenyue())&&queryType.getBenyue().equals("benyue")){
            sql.append(" AND DATE_FORMAT(con.signedTime,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')");
        }else if (StringUtils.isNotEmpty(queryType.getShangyue())&&queryType.getShangyue().equals("shangyue")){
            sql.append(" AND DATE_FORMAT(con.signedTime,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')");
        }else if (StringUtils.isNotEmpty(queryType.getBenji())&&queryType.getBenji().equals("benji")){
            sql.append(" AND QUARTER(con.signedTime)=QUARTER(NOW())");
        }else if (StringUtils.isNotEmpty(queryType.getShangji())&&queryType.getShangji().equals("shangji")){
            sql.append(" AND QUARTER(con.signedTime)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))");
        }
        return sql.toString();
    }

    public String queryContractById(String contractId){
        return new StringBuffer("SELECT con.*,cust.* FROM contract con,customer cust WHERE con.`custId`=cust.`custId` AND con.contractId="+Integer.parseInt(contractId)+"").toString();
    }

}
