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
}
