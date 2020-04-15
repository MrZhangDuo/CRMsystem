package com.hy.crmsystem.mrzhang.mapper;

import com.hy.crmsystem.mrzhang.entity.CountDocumetMoery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface CountMmapper {

    /**
     * 统计跟单本周的预成交金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countDocumentaryMoneyBZ")
    public String countDocumentaryMoneyBZ();

    /**
     * 统计跟单上周的预成交金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countDocumentaryMoneySZ")
    public String countDocumentaryMoneySZ();

    /**
     * 统计跟单本月的预成交金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countDocumentaryMoneyBY")
    public String countDocumentaryMoneyBY();

    /**
     * 统计跟单上月的预成交金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countDocumentaryMoneySY")
    public String countDocumentaryMoneySY();

    /**
     * 统计跟单本季度的预成交金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countDocumentaryMoneyBJ")
    public String countDocumentaryMoneyBJ();

    /**
     * 统计跟单上季度的预成交金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countDocumentaryMoneySJ")
    public String countDocumentaryMoneySJ();

    /**
     * 统计跟单本年度的预成交金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countDocumentaryMoneyBN")
    public String countDocumentaryMoneyBN();

    /**
     * 统计跟单上年度的预成交金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countDocumentaryMoneySN")
    public String countDocumentaryMoneySN();

    /**
     * 统计用户本周商机金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustBusBZ")
    public CountDocumetMoery countCustBusBZ(Integer custId);

    /**
     * 统计用户上周商机金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustBusSZ")
    public CountDocumetMoery countCustBusSZ(Integer custId);


    /**
     * 统计用户本周成交金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustCJBZ")
    public CountDocumetMoery countCustCJBZ(Integer custId);

    /**
     * 统计用户上周成交金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustCJSZ")
    public CountDocumetMoery countCustCJSZ(Integer custId);

    /**
     * 统计用户本周跟单金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustDocBZ")
    public CountDocumetMoery countCustDocBZ(Integer custId);

    /**
     * 统计用户上周跟单金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustDocSZ")
    public CountDocumetMoery countCustDocSZ(Integer custId);

    /**
     * 统计用户本周合同金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustConBZ")
    public CountDocumetMoery countCustConBZ(Integer custId);

    /**
     * 统计用户上周合同金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustConSZ")
    public CountDocumetMoery countCustConSZ(Integer custId);


    /******************* 本月统计 *******************************************************************************/
    /**
     * 统计用户本月商机金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustBusBY")
    public CountDocumetMoery countCustBusBY(Integer custId);

    /**
     * 统计用户上月商机金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustBusSY")
    public CountDocumetMoery countCustBusSY(Integer custId);

    /**
     * 统计用户本月成交金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustCJBY")
    public CountDocumetMoery countCustCJBY(Integer custId);

    /**
     * 统计用户上月成交金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustCJSY")
    public CountDocumetMoery countCustCJSY(Integer custId);

    /**
     * 统计用户本月跟单金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustDocBY")
    public CountDocumetMoery countCustDocBY(Integer custId);

    /**
     * 统计用户上月跟单金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustDocSY")
    public CountDocumetMoery countCustDocSY(Integer custId);

    /**
     * 统计用户本月合同金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustConBY")
    public CountDocumetMoery countCustConBY(Integer custId);

    /**
     * 统计用户上月合同金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustConSY")
    public CountDocumetMoery countCustConSY(Integer custId);

    /******************* 本季度统计 *******************************************************************************/
    /**
     * 统计用户本季度商机金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustBusBJ")
    public CountDocumetMoery countCustBusBJ(Integer custId);

    /**
     * 统计用户上季度商机金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustBusSJ")
    public CountDocumetMoery countCustBusSJ(Integer custId);

    /**
     * 统计用户本季度成交金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustCJBJ")
    public CountDocumetMoery countCustCJBJ(Integer custId);

    /**
     * 统计用户上季度成交金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustCJSJ")
    public CountDocumetMoery countCustCJSJ(Integer custId);

    /**
     * 统计用户本季度跟单金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustDocBJ")
    public CountDocumetMoery countCustDocBJ(Integer custId);

    /**
     * 统计用户上季度跟单金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustDocSJ")
    public CountDocumetMoery countCustDocSJ(Integer custId);

    /**
     * 统计用户本季度合同金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustConBJ")
    public CountDocumetMoery countCustConBJ(Integer custId);

    /**
     * 统计用户上季度合同金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustConSJ")
    public CountDocumetMoery countCustConSJ(Integer custId);



    /******************* 本年度统计 *******************************************************************************/
    /**
     * 统计用户本年商机金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustBusBN")
    public CountDocumetMoery countCustBusBN(Integer custId);

    /**
     * 统计用户上年商机金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustBusSN")
    public CountDocumetMoery countCustBusSN(Integer custId);

    /**
     * 统计用户本年成交金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustCJBN")
    public CountDocumetMoery countCustCJBN(Integer custId);

    /**
     * 统计用户上年成交金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustCJSN")
    public CountDocumetMoery countCustCJSN(Integer custId);

    /**
     * 统计用户本年跟单金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustDocBN")
    public CountDocumetMoery countCustDocBN(Integer custId);

    /**
     * 统计用户上年跟单金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustDocSN")
    public CountDocumetMoery countCustDocSN(Integer custId);

    /**
     * 统计用户本年合同金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustConBN")
    public CountDocumetMoery countCustConBN(Integer custId);

    /**
     * 统计用户上年合同金额
     * */
    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.CountDocumentaryMoney.class,method = "countCustConSN")
    public CountDocumetMoery countCustConSN(Integer custId);
}
