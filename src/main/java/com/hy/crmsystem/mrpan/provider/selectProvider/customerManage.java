package com.hy.crmsystem.mrpan.provider.selectProvider;

import com.hy.crmsystem.mrpan.entity.AfterServiceNum;
import com.hy.crmsystem.mrpan.entity.BusinessBo;
import com.hy.crmsystem.mrpan.entity.ContractBo;
import com.hy.crmsystem.mrpan.entity.CustomerBo;
import com.mysql.jdbc.StringUtils;

public class customerManage {


    /*客户管理页面联合查询*/
    public String customerselect(CustomerBo customer){

        StringBuffer sql=new StringBuffer("SELECT c.custId,c.custName, sj.sjs AS busId,sj.yje AS busBeforeMoney,ht.hts AS contractId, ht.contractMoney AS contractMoney,ht.hke AS incomesMoney ,sh.shs AS serviceId,sh.pjf AS servicesCore FROM  customer c LEFT JOIN \n" +
                "(SELECT b.`custId`,COUNT(b.`custId`)AS sjs,SUM(busBeforeMoney)AS yje FROM  customer c LEFT JOIN  business b   ON b.`custId`=c.custId GROUP BY c.custId)AS sj ON c.custId=sj.custId LEFT JOIN \n" +
                "(SELECT con.`custId`, COUNT(con.custId)AS hts ,con.contractMoney,SUM(mon.incomesMoney)AS hke FROM customer c LEFT JOIN contract con ON c.custId=con.`custId` LEFT JOIN moneyregister mon ON con.`contractId`=mon.`contractId`\n" +
                "GROUP BY c.custId) AS ht ON c.custId=ht.custId  LEFT JOIN\n" +
                "(SELECT a.`custId` ,COUNT(a.custId)AS shs ,AVG(servicesCore)AS pjf FROM customer c LEFT JOIN afterservice a ON c.custId=a.`custId` GROUP BY c.custId)sh ON c.custId=sh.custId where 1=1 ");

        if(!StringUtils.isNullOrEmpty(customer.getCustName())){
            sql.append(" and custName like '%"+customer.getCustName()+"%'");
        }
        if(!StringUtils.isNullOrEmpty(customer.getCustSpell())){
            sql.append(" and custSpell like '%"+customer.getCustSpell()+"%'");
        }
        if(!StringUtils.isNullOrEmpty(customer.getCustSource())){
            sql.append(" and custSource like '%"+customer.getCustSource()+"%'");
        }
        if(!StringUtils.isNullOrEmpty(customer.getCustCountry())){
            sql.append(" and custCountry like '%"+customer.getCustCountry()+"%'");
        }
        if(!StringUtils.isNullOrEmpty(customer.getCustCity())){
            sql.append(" and custCity like '%"+customer.getCustCity()+"%'");
        }
        if(!StringUtils.isNullOrEmpty(customer.getCustTrade())){
            sql.append(" and custTrade like '%"+customer.getCustTrade()+"%'");
        }
        return sql.toString();
    }


    public String selectCustAll(String custName){
        StringBuffer sql=new StringBuffer("SELECT c.custName, sj.sjs AS busId,sj.yje AS busBeforeMoney,ht.hts AS contractId, ht.contractMoney AS contractMoney,ht.hke AS incomesMoney ,sh.shs AS serviceId,sh.pjf AS servicesCore FROM  customer c LEFT JOIN \n" +
                "(SELECT b.`custId`,COUNT(b.`custId`)AS sjs,SUM(busBeforeMoney)AS yje FROM  customer c LEFT JOIN  business b   ON b.`custId`=c.custId GROUP BY c.custId)AS sj ON c.custId=sj.custId LEFT JOIN \n" +
                "(SELECT con.`custId`, COUNT(con.custId)AS hts ,con.contractMoney,SUM(mon.incomesMoney)AS hke FROM customer c LEFT JOIN contract con ON c.custId=con.`custId` LEFT JOIN moneyregister mon ON con.`contractId`=mon.`contractId`\n" +
                "GROUP BY c.custId) AS ht ON c.custId=ht.custId  LEFT JOIN\n" +
                "(SELECT a.`custId` ,COUNT(a.custId)AS shs ,AVG(servicesCore)AS pjf FROM customer c LEFT JOIN afterservice a ON c.custId=a.`custId` GROUP BY c.custId)sh ON c.custId=sh.custId where custName='"+custName+"'\n");
        return sql.toString();
    }

    /*(客户)点商机数时查询所有商机的对应信息*/
    public String  selectBusInfo(BusinessBo businessBo){
        StringBuffer sql=new StringBuffer("SELECT cb.busId, cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS tlbs  FROM (SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b LEFT JOIN customer c ON b.`custId`=c.custId WHERE c.custId="+businessBo.getCustId()+")AS cb  LEFT JOIN" +
                "                    (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId)AS bd  ON cb.`busId`=bd.busId LEFT JOIN" +
                "                    (SELECT i.`invitationId` AS invitationId, i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId where 1=1");
        if(!StringUtils.isNullOrEmpty(businessBo.getBusName())){
            sql.append(" and busName like '%"+businessBo.getBusName()+"%'");
        }
        if(!StringUtils.isNullOrEmpty(businessBo.getBusStage())){
            sql.append(" and busStage like '%"+businessBo.getBusStage()+"%'");
        }
        if(!StringUtils.isNullOrEmpty(businessBo.getBusDutyPeople())){
            sql.append(" and busDutyPeople like '%"+businessBo.getBusDutyPeople()+"%'");
        }
        if(null!=businessBo.getBusBeforeMoney()){
            sql.append(" and busBeforeMoney="+businessBo.getBusBeforeMoney()+"");
        }
        return sql.toString();
    }

    /*（商机表中）查询所有的商机 */
    public String  selectAllBusInfo(BusinessBo businessBo){
        StringBuffer sql=new StringBuffer("SELECT cb.busId, cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM (SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`,b.`busBeforedate`  FROM  business b LEFT JOIN customer c ON b.`custId`=c.custId )AS cb  LEFT JOIN \n" +
                "(SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId)AS bd  ON cb.`busId`=bd.busId LEFT JOIN\n" +
                "(SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId where 1=1");
        System.out.println("-------------------------------------------------------");
        if(!org.springframework.util.StringUtils.isEmpty(businessBo.getBusName())){
            System.out.println("++++++++++++++++++++================================");
            sql.append(" and cb.busName='"+businessBo.getBusName()+"'");
        }
        if(!org.springframework.util.StringUtils.isEmpty(businessBo.getBusStage())){
            System.out.println("++++++++++++++++++++================================");
            sql.append(" and cb.busStage='"+businessBo.getBusStage()+"'");
        }
        if(!org.springframework.util.StringUtils.isEmpty(businessBo.getBusDutyPeople())){
            System.out.println("++++++++++++++++++++================================");
            sql.append(" and cb.busDutyPeople='"+businessBo.getBusDutyPeople()+"'");
        }
        if(!org.springframework.util.StringUtils.isEmpty(businessBo.getBusBeforeMoney())){
            System.out.println("++++++++++++++++++++================================");
            sql.append(" and cb.busBeforeMoney='"+businessBo.getBusBeforeMoney()+"'");
        }


        return sql.toString();
    }

    //点合同数时根据客户id查询客户下的所有合同
    public String selectContractInfo(ContractBo contractBo){
        StringBuffer sql=new StringBuffer("SELECT con.contractId AS contractId,con.contractName AS contractName,con.contractNum AS contractNum,con.contractMoney AS contractMoney,cm.incomesMoney AS incomesMoney,cb.billMoney AS billMoney,con.signedTime AS signedTime \n" +
                "FROM contract con LEFT JOIN (SELECT c.*, SUM(incomesMoney)AS incomesMoney   FROM contract c LEFT JOIN `moneyregister` m ON c.`contractId`=m. contractId GROUP BY m.contractId)AS cm ON con.contractId=cm.contractId LEFT JOIN \n" +
                "(SELECT c.*,SUM(billMoney)AS billMoney FROM contract c LEFT JOIN billaskfor b ON c.`contractId`=b.contractId GROUP BY b.contractId)AS cb ON con.contractId=cb.contractId WHERE 1=1 AND con.custId='"+contractBo.getCustId()+"'");

        if(!StringUtils.isNullOrEmpty(contractBo.getContractName())){
            sql.append(" and con.contractName='"+contractBo.getContractName()+"'");
        }
        if(!StringUtils.isNullOrEmpty(contractBo.getContractNum())){
            sql.append(" and con.contractNum='"+contractBo.getContractNum()+"'");
        }
        if(!StringUtils.isNullOrEmpty(contractBo.getOfdept())){
            sql.append(" and con.ofdept='"+contractBo.getOfdept()+"'");
        }
        if(null!=contractBo.getIncomesMoney() ){
            sql.append(" and incomesMoney='"+contractBo.getIncomesMoney()+"'");
        }
        if(null!=contractBo.getSignedTime()){
            sql.append(" and signedTime='"+contractBo.getSignedTime()+"'");
        }
        return sql.toString();
    }


    //点售后服务数时查询售后服务的信息
    public String selectServiceInfo(AfterServiceNum afterService){
        StringBuffer sql=new StringBuffer("SELECT serviceId,serviceTheme ,serviceType ,serviceStartTime as StartTime,servicePeople ,servicesCore FROM `afterservice` \n" +
                "   WHERE custId='"+afterService.getCustId()+"'");

        if(!StringUtils.isNullOrEmpty(afterService.getServiceTheme())){
            sql.append(" and serviceTheme like '%"+afterService.getServiceTheme()+"%'");
        }
        if(!StringUtils.isNullOrEmpty(afterService.getServiceType())){
            sql.append(" and serviceType like '%"+afterService.getServiceType()+"%'");
        }
        if(!StringUtils.isNullOrEmpty(afterService.getStartTime())){
            sql.append(" and serviceStartTime='"+afterService.getStartTime()+"'");
        }
        if(!StringUtils.isNullOrEmpty(afterService.getServicePeople())){
            sql.append(" and servicePeople like '"+afterService.getServicePeople()+"'");
        }
        if(null!=afterService.getServicesCore()){
            sql.append(" and servicesCore='"+afterService.getServicesCore()+"' ");
        }

        return sql.toString();
    }

    public String  selectCustMoney(Integer custId){
        return new StringBuffer("SELECT c.*,m.*  FROM  customer c,moneyinfor m WHERE c.`moneyId`=m.moneyId AND c.`custId`="+custId+"").toString();
    }

    public String custByBusId(Integer custd){
        return new StringBuffer("SELECT c.custId,c.custDept, c.custName,c.custTrade,c.custCity,c.custAddress,c.custSource,b.* FROM customer c,business b WHERE c.`custId`=b.custId AND b.busId="+custd+"").toString();
    }


    //根据用户名查询财务信息
    public String selectMoneyInfo(String CustName){
        StringBuffer sql=new StringBuffer("SELECT moneyId,moneyBankCard,moneyBankName,moneybank,moneyAddress,moneyDutyNo,moneyPhone" +
                " FROM moneyinfor WHERE moneyId=(SELECT DISTINCT moneyId FROM  customer WHERE custName='"+CustName+"')");

        return sql.toString();
    }

    //我的商机
    public String MyBusInfo(BusinessBo businessBo,String custName){
        StringBuffer sql=new StringBuffer("SELECT cb.busId, cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS tlbs,bi.invitationId \n" +
                "FROM (SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b LEFT JOIN customer c ON b.`custId`=c.custId WHERE b.busDutyPeople='"+custName+"' OR b.`busFollowPeople`='"+custName+"' OR b.`busJoinPeople`='"+custName+"')AS cb  LEFT JOIN \n" +
                "(SELECT b.`busDutyPeople`, b.busId, MAX(d.docTime)AS docTime  FROM business b LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId)AS bd  ON cb.`busId`=bd.busId LEFT JOIN (SELECT i.`busId`,COUNT(i.busId)AS tlbs ,i.`invitationId` FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId where 1=1");

        if(!org.springframework.util.StringUtils.isEmpty(businessBo.getBusName())){
            System.out.println("============================================================");
            sql.append(" and cb.busName='"+businessBo.getBusName()+"'");
        }
        if(!org.springframework.util.StringUtils.isEmpty(businessBo.getBusStage())){
            sql.append(" and cb.busStage='"+businessBo.getBusStage()+"'");
        }
        if(!org.springframework.util.StringUtils.isEmpty(businessBo.getBusDutyPeople())){
            sql.append(" and cb.busDutyPeople='"+businessBo.getBusDutyPeople()+"'");
        }
        if(!org.springframework.util.StringUtils.isEmpty(businessBo.getBusBeforeMoney())){
            sql.append(" and cb.busBeforeMoney='"+businessBo.getBusBeforeMoney()+"'");
        }
         return sql.toString();
    }


   //根据商机负责人查询我的商机信息
    public String MyBusInfoByResponsiblePeople(String custName){
        StringBuffer sql=new StringBuffer("SELECT cb.busId, cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId \n" +
                "FROM (SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`,b.`busJoinPeople`,b.`busFollowPeople`  FROM  business b LEFT JOIN customer c ON b.`custId`=c.custId)AS cb  LEFT JOIN \n" +
                "(SELECT b.`busDutyPeople`, b.busId, MAX(d.docTime)AS docTime  FROM business b LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId)AS bd  ON cb.`busId`=bd.busId LEFT JOIN\n" +
                "(SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId WHERE cb.busDutyPeople='"+custName+"'");
   return sql.toString();
    }
   //根据商机参与人查询我的商机信息
    public String MyBusInfoByJoinPeople(String custName){
        StringBuffer sql=new StringBuffer("SELECT cb.busId, cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId \n" +
                "FROM (SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`,b.`busJoinPeople`,b.`busFollowPeople`  FROM  business b LEFT JOIN customer c ON b.`custId`=c.custId)AS cb  LEFT JOIN \n" +
                "(SELECT b.`busDutyPeople`, b.busId, MAX(d.docTime)AS docTime  FROM business b LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId)AS bd  ON cb.`busId`=bd.busId LEFT JOIN\n" +
                "(SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId WHERE cb.busJoinPeople='"+custName+"'");
   return sql.toString();
    }
   //根据商机关注人查询我的商机信息
    public String MyBusInfoByCarePeople(String custName){
        StringBuffer sql=new StringBuffer("SELECT cb.busId, cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId \n" +
                "FROM (SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`,b.`busJoinPeople`,b.`busFollowPeople`  FROM  business b LEFT JOIN customer c ON b.`custId`=c.custId)AS cb  LEFT JOIN \n" +
                "(SELECT b.`busDutyPeople`, b.busId, MAX(d.docTime)AS docTime  FROM business b LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId)AS bd  ON cb.`busId`=bd.busId LEFT JOIN\n" +
                "(SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId WHERE cb.busFollowPeople='"+custName+"'");
   return sql.toString();
    }

}
