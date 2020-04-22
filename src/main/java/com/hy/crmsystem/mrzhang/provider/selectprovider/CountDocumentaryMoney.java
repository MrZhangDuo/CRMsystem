package com.hy.crmsystem.mrzhang.provider.selectProvider;


public class CountDocumentaryMoney {

    /**
    * 统计跟单本周的预成交金额
    * */
    public String countDocumentaryMoneyBZ(){
        return  new StringBuffer("SELECT SUM(bus.`busBeforeMoney`)AS busBeforeMoney FROM \n" +
                "documentary doc LEFT JOIN business bus ON doc.`busId`=bus.`busId` WHERE YEARWEEK(DATE_FORMAT(doc.docTime,'%Y-%m-%d')) = YEARWEEK(NOW())\n").toString();
    }

    /**
     * 统计跟单上周的预成交金额
     * */
    public String countDocumentaryMoneySZ(){
        return new StringBuffer("SELECT SUM(bus.`busBeforeMoney`)AS busBeforeMoney FROM \n" +
                "documentary doc LEFT JOIN business bus ON doc.`busId`=bus.`busId` WHERE YEARWEEK(DATE_FORMAT(doc.docTime,'%Y-%m-%d')) = YEARWEEK(NOW())-1\n").toString();

    }

    /**
     * 统计跟单本月的预成交金额
     * */
    public String countDocumentaryMoneyBY(){
        return new StringBuffer("SELECT SUM(bus.`busBeforeMoney`)AS busBeforeMoney FROM \n" +
                "documentary doc LEFT JOIN business bus ON doc.`busId`=bus.`busId` WHERE DATE_FORMAT(doc.docTime,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')\n").toString();
    }

    /**
     * 统计跟单上月的预成交金额
     * */
    public String countDocumentaryMoneySY(){
        return new StringBuffer("SELECT SUM(bus.`busBeforeMoney`)AS busBeforeMoney FROM \n" +
                "documentary doc LEFT JOIN business bus ON doc.`busId`=bus.`busId` WHERE DATE_FORMAT(doc.docTime,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')\n").toString();
    }

    /**
     * 统计跟单本季度的预成交金额
     * */
    public String countDocumentaryMoneyBJ(){
        return new StringBuffer("SELECT SUM(bus.`busBeforeMoney`)AS busBeforeMoney FROM \n" +
                "documentary doc LEFT JOIN business bus ON doc.`busId`=bus.`busId` WHERE QUARTER(doc.docTime)=QUARTER(NOW())\n").toString();
    }

    /**
     * 统计跟单上季度的预成交金额
     * */
    public String countDocumentaryMoneySJ(){
        return new StringBuffer("SELECT SUM(bus.`busBeforeMoney`)AS busBeforeMoney FROM \n" +
                "documentary doc LEFT JOIN business bus ON doc.`busId`=bus.`busId` WHERE QUARTER(doc.docTime)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))\n").toString();
    }

    /**
     * 统计跟单本年度的预成交金额
     * */
    public String countDocumentaryMoneyBN(){
        return new StringBuffer("SELECT SUM(bus.`busBeforeMoney`)AS busBeforeMoney FROM \n" +
                "documentary doc LEFT JOIN business bus ON doc.`busId`=bus.`busId` WHERE YEAR(doc.docTime)=YEAR(NOW());\n").toString();
    }

    /**
     * 统计跟单上年度的预成交金额
     * */
    public String countDocumentaryMoneySN(){
        return new StringBuffer("SELECT SUM(bus.`busBeforeMoney`)AS busBeforeMoney FROM \n" +
                "documentary doc LEFT JOIN business bus ON doc.`busId`=bus.`busId` WHERE YEAR(doc.docTime)=YEAR(NOW())-1\n").toString();
    }

/************************* 本周统计 *************************************************************************************/
    /**
     * 统计用户本周商机金额
     * */
    public String countCustBusBZ(Integer custId){
        return new StringBuffer("SELECT COUNT(custId)as custIds,SUM(busBeforeMoney)as bzsj FROM business WHERE custId="+custId+" AND YEARWEEK(DATE_FORMAT(busTime,'%Y-%m-%d')) = YEARWEEK(NOW())").toString();
    }

    /**
     * 统计用户上周商机金额
     * */
    public String countCustBusSZ(Integer custId){
        return new StringBuffer("SELECT COUNT(custId)as custIds,SUM(busBeforeMoney)as szsj FROM business WHERE custId="+custId+" AND YEARWEEK(DATE_FORMAT(busTime,'%Y-%m-%d')) = YEARWEEK(NOW())-1").toString();
    }

    /**
     * 统计用户本周成交金额
     * */
    public String countCustCJBZ(Integer custId){
        return new StringBuffer("SELECT COUNT(custId)as custIds,SUM(busBeforeMoney)AS cjbz FROM business WHERE YEARWEEK(DATE_FORMAT(busTime,'%Y-%m-%d')) = YEARWEEK(NOW()) AND busStage='成交'  AND custId="+custId+"").toString();
    }

    /**
     * 统计用户上周成交金额
     * */
    public String countCustCJSZ(Integer custId){
        return new StringBuffer("SELECT COUNT(custId)as custIds,SUM(busBeforeMoney)AS cjsz FROM business WHERE YEARWEEK(DATE_FORMAT(busTime,'%Y-%m-%d')) = YEARWEEK(NOW())-1 AND busStage='成交'  AND custId="+custId+"").toString();
    }

    /**
     * 统计用户本周跟单金额
     * */
    public String countCustDocBZ(Integer custId){
        return new StringBuffer("SELECT COUNT(bus.custId)as custIds,SUM(bus.`busBeforeMoney`)AS gdbz FROM documentary doc LEFT JOIN business bus ON doc.`busId`=bus.`busId` WHERE YEARWEEK(DATE_FORMAT(doc.docTime,'%Y-%m-%d')) = YEARWEEK(NOW()) AND bus.custId="+custId+"").toString();
    }

    /**
     * 统计用户上周跟单金额
     * */
    public String countCustDocSZ(Integer custId){
        return new StringBuffer("SELECT COUNT(bus.custId)as custIds,SUM(bus.`busBeforeMoney`)AS gdsz FROM documentary doc LEFT JOIN business bus ON doc.`busId`=bus.`busId` WHERE YEARWEEK(DATE_FORMAT(doc.docTime,'%Y-%m-%d')) = YEARWEEK(NOW()) AND bus.custId="+custId+"").toString();
    }

    /**
     * 统计用户本周合同金额
     * */
    public String countCustConBZ(Integer custId){
        return new StringBuffer("SELECT COUNT(con.custId)as custIds,SUM(contractMoney)AS htbz FROM contract con WHERE YEARWEEK(DATE_FORMAT(contractStarTime,'%Y-%m-%d')) = YEARWEEK(NOW()) AND con.custId ="+custId+"").toString();
    }

    /**
     * 统计用户上周合同金额
     * */
    public String countCustConSZ(Integer custId){
        return new StringBuffer("SELECT COUNT(con.custId)as custIds,SUM(contractMoney)AS htsz FROM contract con WHERE YEARWEEK(DATE_FORMAT(contractStarTime,'%Y-%m-%d')) = YEARWEEK(NOW()) AND con.custId ="+custId+"").toString();
    }

    /******************* 本月统计 *******************************************************************************/
    /**
     * 统计用户本月商机金额
     * */
    public String countCustBusBY(Integer custId){
        return new StringBuffer("SELECT COUNT(custId)as custIds,SUM(busBeforeMoney)as bysj FROM business WHERE custId="+custId+" AND DATE_FORMAT(busTime,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')").toString();
    }

    /**
     * 统计用户上月商机金额
     * */
    public String countCustBusSY(Integer custId){
        return new StringBuffer("SELECT COUNT(custId)as custIds,SUM(busBeforeMoney)as sysj FROM business WHERE custId="+custId+" AND DATE_FORMAT(busTime,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')").toString();
    }

    /**
     * 统计用户本月成交金额
     * */
    public String countCustCJBY(Integer custId){
        return new StringBuffer("SELECT COUNT(custId)as custIds,SUM(busBeforeMoney)AS bycj FROM business WHERE DATE_FORMAT(busTime,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m') AND busStage='成交'  AND custId="+custId+"").toString();
    }

    /**
     * 统计用户上月成交金额
     * */
    public String countCustCJSY(Integer custId){
        return new StringBuffer("SELECT COUNT(custId)as custIds,SUM(busBeforeMoney)AS sycj FROM business WHERE DATE_FORMAT(busTime,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m') AND busStage='成交'  AND custId="+custId+"").toString();
    }

    /**
     * 统计用户本月跟单金额
     * */
    public String countCustDocBY(Integer custId){
        return new StringBuffer("SELECT COUNT(bus.custId)as custIds,SUM(bus.`busBeforeMoney`)AS bygd FROM documentary doc LEFT JOIN business bus ON doc.`busId`=bus.`busId` WHERE DATE_FORMAT(doc.docTime,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m') AND bus.custId="+custId+"").toString();
    }

    /**
     * 统计用户上月跟单金额
     * */
    public String countCustDocSY(Integer custId){
        return new StringBuffer("SELECT COUNT(bus.custId)as custIds,SUM(bus.`busBeforeMoney`)AS sygd FROM documentary doc LEFT JOIN business bus ON doc.`busId`=bus.`busId` WHERE DATE_FORMAT(doc.docTime,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m') AND bus.custId="+custId+"").toString();
    }

    /**
     * 统计用户本月合同金额
     * */
    public String countCustConBY(Integer custId){
        return new StringBuffer("SELECT COUNT(con.custId)as custIds,SUM(contractMoney)AS byht FROM contract con WHERE DATE_FORMAT(contractStarTime,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')  AND con.custId ="+custId+"").toString();
    }

    /**
     * 统计用户上月合同金额
     * */
    public String countCustConSY(Integer custId){
        return new StringBuffer("SELECT COUNT(con.custId)as custIds,SUM(contractMoney)AS syht FROM contract con WHERE DATE_FORMAT(contractStarTime,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')  AND con.custId ="+custId+"").toString();
    }
    /******************* 本季度统计 *******************************************************************************/
    /**
     * 统计用户本季度商机金额
     * */
    public String countCustBusBJ(Integer custId){
        return new StringBuffer("SELECT COUNT(custId)as custIds,SUM(busBeforeMoney)as bjsj FROM business WHERE custId="+custId+" AND QUARTER(busTime)=QUARTER(NOW())").toString();
    }

    /**
     * 统计用户上季度商机金额
     * */
    public String countCustBusSJ(Integer custId){
        return new StringBuffer("SELECT COUNT(custId)as custIds,SUM(busBeforeMoney)as sjsj FROM business WHERE custId="+custId+" AND QUARTER(busTime)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))").toString();
    }

    /**
     * 统计用户本季度成交金额
     * */
    public String countCustCJBJ(Integer custId){
        return new StringBuffer("SELECT COUNT(custId)as custIds,SUM(busBeforeMoney)AS bjcj FROM business WHERE QUARTER(busTime)=QUARTER(NOW()) AND busStage='成交'  AND custId="+custId+"").toString();
    }

    /**
     * 统计用户上季度成交金额
     * */
    public String countCustCJSJ(Integer custId){
        return new StringBuffer("SELECT COUNT(custId)as custIds,SUM(busBeforeMoney)AS sjcj FROM business WHERE QUARTER(busTime)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER)) AND busStage='成交'  AND custId="+custId+"").toString();
    }

    /**
     * 统计用户本季度跟单金额
     * */
    public String countCustDocBJ(Integer custId){
        return new StringBuffer("SELECT COUNT(bus.custId)as custIds,SUM(bus.`busBeforeMoney`)AS bjgd FROM documentary doc LEFT JOIN business bus ON doc.`busId`=bus.`busId` WHERE QUARTER(doc.docTime)=QUARTER(NOW()) AND bus.custId="+custId+"").toString();
    }

    /**
     * 统计用户上季度跟单金额
     * */
    public String countCustDocSJ(Integer custId){
        return new StringBuffer("SELECT COUNT(bus.custId)as custIds,SUM(bus.`busBeforeMoney`)AS sjgd FROM documentary doc LEFT JOIN business bus ON doc.`busId`=bus.`busId` WHERE QUARTER(doc.docTime)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER)) AND bus.custId="+custId+"").toString();
    }

    /**
     * 统计用户本季度合同金额
     * */
    public String countCustConBJ(Integer custId){
        return new StringBuffer("SELECT COUNT(con.custId)as custIds,SUM(contractMoney)AS bjht FROM contract con WHERE QUARTER(contractStarTime)=QUARTER(NOW())  AND con.custId ="+custId+"").toString();
    }

    /**
     * 统计用户上季度合同金额
     * */
    public String countCustConSJ(Integer custId){
        return new StringBuffer("SELECT COUNT(con.custId)as custIds,SUM(contractMoney)AS sjht FROM contract con WHERE QUARTER(contractStarTime)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))  AND con.custId ="+custId+"").toString();
    }



    /******************* 本年度统计 *******************************************************************************/
    /**
     * 统计用户本年商机金额
     * */
    public String countCustBusBN(Integer custId){
        return new StringBuffer("SELECT COUNT(custId)as custIds,SUM(busBeforeMoney)as bnsj FROM business WHERE custId="+custId+" AND YEAR(busTime)=YEAR(NOW())").toString();
    }

    /**
     * 统计用户上年商机金额
     * */
    public String countCustBusSN(Integer custId){
        return new StringBuffer("SELECT COUNT(custId)as custIds,SUM(busBeforeMoney)as snsj FROM business WHERE custId="+custId+" AND YEAR(busTime)=YEAR(NOW())-1").toString();
    }

    /**
     * 统计用户本年成交金额
     * */
    public String countCustCJBN(Integer custId){
        return new StringBuffer("SELECT COUNT(custId)as custIds,SUM(busBeforeMoney)AS bncj FROM business WHERE YEAR(busTime)=YEAR(NOW()) AND busStage='成交'  AND custId="+custId+"").toString();
    }

    /**
     * 统计用户上年成交金额
     * */
    public String countCustCJSN(Integer custId){
        return new StringBuffer("SELECT COUNT(custId)as custIds,SUM(busBeforeMoney)AS sncj FROM business WHERE YEAR(busTime)=YEAR(NOW())-1 AND busStage='成交'  AND custId="+custId+"").toString();
    }

    /**
     * 统计用户本年跟单金额
     * */
    public String countCustDocBN(Integer custId){
        return new StringBuffer("SELECT COUNT(bus.custId)as custIds,SUM(bus.`busBeforeMoney`)AS bngd FROM documentary doc LEFT JOIN business bus ON doc.`busId`=bus.`busId` WHERE YEAR(doc.docTime)=YEAR(NOW()) AND bus.custId="+custId+"").toString();
    }

    /**
     * 统计用户上年跟单金额
     * */
    public String countCustDocSN(Integer custId){
        return new StringBuffer("SELECT COUNT(bus.custId)as custIds,SUM(bus.`busBeforeMoney`)AS sngd FROM documentary doc LEFT JOIN business bus ON doc.`busId`=bus.`busId` WHERE YEAR(doc.docTime)=YEAR(NOW())-1 AND bus.custId="+custId+"").toString();
    }

    /**
     * 统计用户本年合同金额
     * */
    public String countCustConBN(Integer custId){
        return new StringBuffer("SELECT COUNT(con.custId)as custIds,SUM(contractMoney)AS bnht FROM contract con WHERE YEAR(contractStarTime)=YEAR(NOW())  AND con.custId ="+custId+"").toString();
    }

    /**
     * 统计用户上年合同金额
     * */
    public String countCustConSN(Integer custId){
        return new StringBuffer("SELECT COUNT(con.custId)as custIds,SUM(contractMoney)AS snht FROM contract con WHERE YEAR(contractStarTime)=YEAR(NOW())-1  AND con.custId ="+custId+"").toString();
    }
}
