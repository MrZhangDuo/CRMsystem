package com.hy.crmsystem.mrzhang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface CountMmapper {

    /**
     * 统计跟单本周的预成交金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectProvider.CountDocumentaryMoney.class,method = "countDocumentaryMoneyBZ")
    public String countDocumentaryMoneyBZ();

    /**
     * 统计跟单上周的预成交金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectProvider.CountDocumentaryMoney.class,method = "countDocumentaryMoneySZ")
    public String countDocumentaryMoneySZ();

    /**
     * 统计跟单本月的预成交金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectProvider.CountDocumentaryMoney.class,method = "countDocumentaryMoneyBY")
    public String countDocumentaryMoneyBY();

    /**
     * 统计跟单上月的预成交金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectProvider.CountDocumentaryMoney.class,method = "countDocumentaryMoneySY")
    public String countDocumentaryMoneySY();

    /**
     * 统计跟单本季度的预成交金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectProvider.CountDocumentaryMoney.class,method = "countDocumentaryMoneyBJ")
    public String countDocumentaryMoneyBJ();

    /**
     * 统计跟单上季度的预成交金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectProvider.CountDocumentaryMoney.class,method = "countDocumentaryMoneySJ")
    public String countDocumentaryMoneySJ();

    /**
     * 统计跟单本年度的预成交金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectProvider.CountDocumentaryMoney.class,method = "countDocumentaryMoneyBN")
    public String countDocumentaryMoneyBN();

    /**
     * 统计跟单上年度的预成交金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectProvider.CountDocumentaryMoney.class,method = "countDocumentaryMoneySN")
    public String countDocumentaryMoneySN();


    /*******************************************  本周统计  *********************************************************************/
    /**
     *
     * */

    public String countCustBusBZ();


}
