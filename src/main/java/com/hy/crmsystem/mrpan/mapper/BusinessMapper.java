package com.hy.crmsystem.mrpan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crmsystem.mrpan.entity.Business;
import com.hy.crmsystem.mrpan.entity.BusinessBo;
import com.hy.crmsystem.mrpan.entity.BusinessCustBo;
import com.hy.crmsystem.mrpan.provider.selectProvider.customerManage;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
public interface BusinessMapper extends BaseMapper<Business> {

    /**
     * 查询商机名称
     * @return
     */
    List<Business> queryBusName();

    //点商机数时查询所有商机的对应信息
    @SelectProvider(type = customerManage.class,method = "selectBusInfo")
    public List<BusinessBo> selectBusInfo(BusinessBo businessBo);

    //查询所有的商机信息
    @SelectProvider(type =customerManage.class ,method = "selectAllBusInfo")
    public List<BusinessBo> selectAllBusInfo();

    /*根据商机ID查询客户的客户名称，所属行业，所在城市，详细地址*/
    @SelectProvider(type = customerManage.class,method = "custByBusId")
    public BusinessCustBo custByBusId(Integer busId);

    /*查询进行中的商机*/
    @Select("SELECT cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docId,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b  WHERE busStage != '成交' AND busStage != '丢单')AS cb  LEFT JOIN \n" +
            "                   (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId)AS bd  ON cb.`busId`=bd.busId LEFT JOIN  \n" +
            "                  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId ")
    public List<BusinessBo> proceedBus();
    /*查询进行中的商机数量*/
    @Select("SELECT COUNT(busId) FROM `business`  WHERE busStage != '成交' AND busStage != '丢单'")
    public Integer proceedBusNumber();

    /*已成交商机*/
    @Select("SELECT cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docId,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b  WHERE busStage ='成交')AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId)AS bd  ON cb.`busId`=bd.busId LEFT JOIN  \n" +
            "(SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId ")
    public List<BusinessBo> tradedBus();
    /*已成交商机数量*/
    @Select("SELECT COUNT(busId) FROM `business`  WHERE busStage = '成交'")
    public Integer tradedBusNumber();

    /*已丢单商机*/
    @Select("SELECT cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docId,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b  WHERE busStage ='丢单')AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId)AS bd  ON cb.`busId`=bd.busId LEFT JOIN  \n" +
            "(SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId ")
    public List<BusinessBo> throwBus();
    /*已丢单商机数量*/
    @Select("SELECT COUNT(busId) FROM `business`  WHERE busStage = '丢单'")
    public Integer throwBusNumber();

    /*已搁置商机*/
    @Select("SELECT cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docId,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b  WHERE busStage ='搁置')AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId)AS bd  ON cb.`busId`=bd.busId LEFT JOIN  \n" +
            "(SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId ")
    public List<BusinessBo> shelveBus();
    /*已搁置商机数量*/
    @Select("SELECT COUNT(busId) FROM `business`  WHERE busStage = '搁置'")
    public Integer shelveBusNumber();

    /*七天未跟单*/
    @Select("SELECT cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docId,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId WHERE DATEDIFF(NOW(),docTime)<7")
    public List<BusinessBo> docTimeLessSeven();
    /*七天未跟单数量*/
    @Select("SELECT COUNT(b.busId) FROM `business` b,`documentary` d  WHERE b.busId=d.busId AND DATEDIFF(NOW(),docTime)<7")
    public Integer docTimeLessSevenNumber();

    /*三十天未跟单*/
    @Select("SELECT cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docId,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId WHERE DATEDIFF(NOW(),docTime)>7 and DATEDIFF(NOW(),docTime)<30")
    public List<BusinessBo> docTimeLessThirty();
    /*三十天未跟单数量*/
    @Select("SELECT COUNT(b.busId) FROM `business` b,`documentary` d  WHERE b.busId=d.busId AND DATEDIFF(NOW(),docTime)>7 AND DATEDIFF(NOW(),docTime)<30")
    public Integer docTimeLessThirtyNumber();

    /*九十天未跟单*/
    @Select("SELECT cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docId,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId WHERE DATEDIFF(NOW(),docTime)>30 and DATEDIFF(NOW(),docTime)<90")
    public List<BusinessBo> docTimeLessNinety();
    /*九十天未跟单数量*/
    @Select("SELECT COUNT(b.busId) FROM `business` b,`documentary` d  WHERE b.busId=d.busId AND DATEDIFF(NOW(),docTime)>30 and DATEDIFF(NOW(),docTime)<90")
    public Integer docTimeLessNinetyNumber();

    /*本周新增*/
    @Select("SELECT cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docId,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busNowTime`,b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId \n" +
            " WHERE YEARWEEK(DATE_FORMAT(busNowTime,'%Y-%m-%d')) = YEARWEEK(NOW())")
    public List<BusinessBo> weekAdd();
    /*本周新增数量*/
    @Select("SELECT COUNT(busId) FROM `business` where YEARWEEK(DATE_FORMAT(busNowTime,'%Y-%m-%d')) = YEARWEEK(NOW())")
    public Integer weekAddNumber();

    /*上周新增*/
    @Select("SELECT cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docId,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busNowTime`,b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId \n" +
            "WHERE YEARWEEK(DATE_FORMAT(busNowTime,'%Y-%m-%d')) = YEARWEEK(NOW())-1 ")
    public List<BusinessBo> lastWeekAdd();
    /*上周新增数量*/
    @Select("SELECT COUNT(busId) FROM `business` where YEARWEEK(DATE_FORMAT(busNowTime,'%Y-%m-%d')) = YEARWEEK(NOW())-1")
    public Integer lastWeekAddNumber();

    /*本月新增*/
    @Select("SELECT cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docId,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busNowTime`,b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId \n" +
            "WHERE DATE_FORMAT( busNowTime, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )")
    public List<BusinessBo> monthAdd();
    /*本月新增数量*/
    @Select("SELECT COUNT(busId) FROM `business` WHERE DATE_FORMAT( busNowTime, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )")
    public Integer monthAddNumber();

    /*上月新增*/
    @Select("SELECT cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docId,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busNowTime`,b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId \n" +
            "WHERE PERIOD_DIFF( DATE_FORMAT( NOW( ) , '%Y%m' ) , DATE_FORMAT( busNowTime, '%Y%m' ) ) =1")
    public List<BusinessBo> lastMonthAdd();
    /*上月新增数量*/
    @Select("SELECT COUNT(busId) FROM `business` WHERE PERIOD_DIFF( DATE_FORMAT( NOW( ) , '%Y%m' ) , DATE_FORMAT( busNowTime, '%Y%m' ) ) =1")
    public Integer lastMonthAddNumber();


    /*本季度新增*/
    @Select("SELECT cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docId,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busNowTime`,b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId \n" +
            "WHERE QUARTER(busNowTime)=QUARTER(NOW())")
    public List<BusinessBo> quarterAdd();
    /*本季度新增数量*/
    @Select("SELECT COUNT(busId) FROM `business` WHERE QUARTER(busNowTime)=QUARTER(NOW())")
    public Integer quarterAddNumber();

    /*上季度新增*/
    @Select(" SELECT cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docId,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busNowTime`,b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId \n" +
            "WHERE QUARTER(busNowTime)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))")
    public List<BusinessBo> lastQuarterAdd();
    /*上季度新增数量*/
    @Select("SELECT COUNT(busId) FROM `business` WHERE QUARTER(busNowTime)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))")
    public Integer lastQuarterAddNumber();



}
