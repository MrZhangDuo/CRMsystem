package com.hy.crmsystem.mrpan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crmsystem.mrpan.entity.Business;
import com.hy.crmsystem.mrpan.entity.BusinessBo;
import com.hy.crmsystem.mrpan.entity.BusinessCustBo;
import com.hy.crmsystem.mrpan.provider.selectProvider.customerManage;
import org.apache.ibatis.annotations.Mapper;
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
@Mapper
public interface BusinessMapper extends BaseMapper<Business> {

    /**
     * 查询商机名称
     * @return
     */
    List<Business> queryBusName();

    //点商机数时查询所有商机的对应信息
    @SelectProvider(type = customerManage.class,method = "selectBusInfo")
    public List<BusinessBo> selectBusInfo(BusinessBo businessBo);

    //查询商机中所有的商机信息
    @SelectProvider(type =customerManage.class ,method = "selectAllBusInfo")
    public List<BusinessBo> selectAllBusInfo(BusinessBo businessBo);

    //查询我的商机中商机的信息
    @SelectProvider(type =customerManage.class ,method = "MyBusInfo")
    public List<BusinessBo> MyBusInfo(BusinessBo businessBo,String custName);

    //根据商机负责人查询我的商机信息
    @SelectProvider(type =customerManage.class ,method = "MyBusInfoByResponsiblePeople")
    public List<BusinessBo> MyBusInfoByResponsiblePeople(String custName);
    //查询我的商机中商机负责人是登陆人的商机条数
    @Select("SELECT COUNT(busId) FROM business  WHERE busDutyPeople=#{custName}")
    public Integer BusResponsiblePeopleNumber(String custName);
    //查询我的商机中商机参与人是登陆人的商机条数
    @Select("SELECT COUNT(busId) FROM business   WHERE busJoinPeople=#{value}")
    public Integer BusJoinPeopleNumber(String custName);
    //查询我的商机中商机关注人是登陆人的商机条数
    @Select("SELECT COUNT(busId) FROM business WHERE busFollowPeople=#{value}")
    public Integer BusCarePeopleNumber(String custName);
    //根据商机参与人查询我的商机信息
    @SelectProvider(type =customerManage.class ,method = "MyBusInfoByJoinPeople")
    public List<BusinessBo> MyBusInfoByJoinPeople(String custName);

    //根据商机关注人查询我的商机信息
    @SelectProvider(type =customerManage.class ,method = "MyBusInfoByCarePeople")
    public List<BusinessBo> MyBusInfoByCarePeople(String custName);

    /*根据商机ID查询客户的客户名称，所属行业，所在城市，详细地址*/
    @SelectProvider(type = customerManage.class,method = "custByBusId")
    public BusinessCustBo custByBusId(Integer busId);

    /*查询进行中的商机*/
    @Select("SELECT cb.busId, cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b  WHERE busStage != '成交' AND busStage != '丢单')AS cb  LEFT JOIN \n" +
            "                   (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId)AS bd  ON cb.`busId`=bd.busId LEFT JOIN  \n" +
            "                  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId ")
    public List<BusinessBo> proceedBus();
    /*查询进行中的商机数量*/
    @Select("SELECT COUNT(busId) FROM `business`  WHERE busStage != '成交' AND busStage != '丢单'")
    public Integer proceedBusNumber();

    /*已成交商机*/
    @Select("SELECT cb.busId, cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b  WHERE busStage ='成交')AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId)AS bd  ON cb.`busId`=bd.busId LEFT JOIN  \n" +
            "(SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId ")
    public List<BusinessBo> tradedBus();
    /*已成交商机数量*/
    @Select("SELECT COUNT(busId) FROM `business`  WHERE busStage = '成交'")
    public Integer tradedBusNumber();

    /*已丢单商机*/
    @Select("SELECT cb.busId,  cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b  WHERE busStage ='丢单')AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId)AS bd  ON cb.`busId`=bd.busId LEFT JOIN  \n" +
            "(SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId ")
    public List<BusinessBo> throwBus();
    /*已丢单商机数量*/
    @Select("SELECT COUNT(busId) FROM `business`  WHERE busStage = '丢单'")
    public Integer throwBusNumber();

    /*已搁置商机*/
    @Select("SELECT cb.busId,  cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b  WHERE busStage ='搁置')AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId)AS bd  ON cb.`busId`=bd.busId LEFT JOIN  \n" +
            "(SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId ")
    public List<BusinessBo> shelveBus();
    /*已搁置商机数量*/
    @Select("SELECT COUNT(busId) FROM `business`  WHERE busStage = '搁置'")
    public Integer shelveBusNumber();

    /*七天未跟单*/
    @Select("SELECT cb.busId,  cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId WHERE DATEDIFF(NOW(),docTime)<7")
    public List<BusinessBo> docTimeLessSeven();
    /*七天未跟单数量*/
    @Select("SELECT COUNT(b.busId) FROM `business` b,`documentary` d  WHERE b.busId=d.busId AND DATEDIFF(NOW(),docTime)<7")
    public Integer docTimeLessSevenNumber();

    /*三十天未跟单*/
    @Select("SELECT cb.busId,  cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId WHERE DATEDIFF(NOW(),docTime)>7 and DATEDIFF(NOW(),docTime)<30")
    public List<BusinessBo> docTimeLessThirty();
    /*三十天未跟单数量*/
    @Select("SELECT COUNT(b.busId) FROM `business` b,`documentary` d  WHERE b.busId=d.busId AND DATEDIFF(NOW(),docTime)>7 AND DATEDIFF(NOW(),docTime)<30")
    public Integer docTimeLessThirtyNumber();

    /*九十天未跟单*/
    @Select("SELECT cb.busId,  cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId WHERE DATEDIFF(NOW(),docTime)>30 and DATEDIFF(NOW(),docTime)<90")
    public List<BusinessBo> docTimeLessNinety();
    /*九十天未跟单数量*/
    @Select("SELECT COUNT(b.busId) FROM `business` b,`documentary` d  WHERE b.busId=d.busId AND DATEDIFF(NOW(),docTime)>30 and DATEDIFF(NOW(),docTime)<90")
    public Integer docTimeLessNinetyNumber();

    /*本周新增*/
    @Select("SELECT cb.busId,  cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busTime`,b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId \n" +
            " WHERE YEARWEEK(DATE_FORMAT(busTime,'%Y-%m-%d')) = YEARWEEK(NOW())")
    public List<BusinessBo> weekAdd();
    /*本周新增数量*/
    @Select("SELECT COUNT(busId) FROM `business` where YEARWEEK(DATE_FORMAT(busTime,'%Y-%m-%d')) = YEARWEEK(NOW())")
    public Integer weekAddNumber();

    /*上周新增*/
    @Select("SELECT cb.busId,  cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busTime`,b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId \n" +
            "WHERE YEARWEEK(DATE_FORMAT(busTime,'%Y-%m-%d')) = YEARWEEK(NOW())-1 ")
    public List<BusinessBo> lastWeekAdd();
    /*上周新增数量*/
    @Select("SELECT COUNT(busId) FROM `business` where YEARWEEK(DATE_FORMAT(busTime,'%Y-%m-%d')) = YEARWEEK(NOW())-1")
    public Integer lastWeekAddNumber();

    /*本月新增*/
    @Select("SELECT cb.busId,  cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busTime`,b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId \n" +
            "WHERE DATE_FORMAT( busTime, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )")
    public List<BusinessBo> monthAdd();
    /*本月新增数量*/
    @Select("SELECT COUNT(busId) FROM `business` WHERE DATE_FORMAT( busTime, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )")
    public Integer monthAddNumber();

    /*上月新增*/
    @Select("SELECT cb.busId,  cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busTime`,b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId \n" +
            "WHERE PERIOD_DIFF( DATE_FORMAT( NOW( ) , '%Y%m' ) , DATE_FORMAT( busTime, '%Y%m' ) ) =1")
    public List<BusinessBo> lastMonthAdd();
    /*上月新增数量*/
    @Select("SELECT COUNT(busId) FROM `business` WHERE PERIOD_DIFF( DATE_FORMAT( NOW( ) , '%Y%m' ) , DATE_FORMAT( busTime, '%Y%m' ) ) =1")
    public Integer lastMonthAddNumber();


    /*本季度新增*/
    @Select("SELECT cb.busId,  cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busTime`,b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId \n" +
            "WHERE QUARTER(busTime)=QUARTER(NOW())")
    public List<BusinessBo> quarterAdd();
    /*本季度新增数量*/
    @Select("SELECT COUNT(busId) FROM `business` WHERE QUARTER(busTime)=QUARTER(NOW())")
    public Integer quarterAddNumber();

    /*上季度新增*/
    @Select(" SELECT cb.busId,  cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busTime`,b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId \n" +
            "WHERE QUARTER(busTime)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))")
    public List<BusinessBo> lastQuarterAdd();
    /*上季度新增数量*/
    @Select("SELECT COUNT(busId) FROM `business` WHERE QUARTER(busTime)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))")
    public Integer lastQuarterAddNumber();

               /*111111111111111111111111我的商机信息11111111111111111111111111111*/

    /*成交商机*/
    @Select("SELECT cb.busId,  cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b  WHERE busStage ='成交')AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId)AS bd  ON cb.`busId`=bd.busId LEFT JOIN \n" +
            "(SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId WHERE busDutyPeople=#{value}")
     public List<BusinessBo> successBus(String custName);

    /*丢单商机*/
    @Select("SELECT cb.busId,  cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b  WHERE busStage ='丢单')AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId)AS bd  ON cb.`busId`=bd.busId LEFT JOIN \n" +
            "(SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId WHERE busDutyPeople=#{value}")
    public  List<BusinessBo> myThrow(String custName);
    /*搁置商机*/
    @Select("SELECT cb.busId,  cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b  WHERE busStage ='搁置')AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId)AS bd  ON cb.`busId`=bd.busId LEFT JOIN  \n" +
            "(SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId where busDutyPeople=#{value}")
    public List<BusinessBo> myShelve(String custName);

    /*进行中的商机*/
    @Select("SELECT bi.invitationId, cb.busId,  cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b  WHERE busStage != '成交' AND busStage != '丢单')AS cb  LEFT JOIN \n" +
            " (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId)AS bd  ON cb.`busId`=bd.busId LEFT JOIN  \n" +
            "(SELECT i.invitationId, i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId WHERE busDutyPeople=#{value}")
    public List<BusinessBo> myBusProceed(String custName);
    /*7天未跟单*/
    @Select("SELECT cb.busId,  cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId WHERE DATEDIFF(NOW(),docTime)>=7 AND DATEDIFF(NOW(),docTime)<30 AND busDutyPeople=#{value}")
    public List<BusinessBo> myBusSeven(String custName);
    /*30天未跟单*/
    @Select("SELECT cb.busId,  cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId WHERE DATEDIFF(NOW(),docTime)>=30 AND DATEDIFF(NOW(),docTime)<60 AND busDutyPeople=#{value}")
    public List<BusinessBo> myBusthirty(String custName);
    /*90天未跟单*/
    @Select("SELECT cb.busId,  cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId WHERE DATEDIFF(NOW(),docTime)>=90 AND busDutyPeople=#{value}")
    public List<BusinessBo> myBusNenity(String custName);
    /*本周新增*/
    @Select("SELECT cb.busId,  cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busTime`,b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId \n" +
            "WHERE YEARWEEK(DATE_FORMAT(busTime,'%Y-%m-%d')) = YEARWEEK(NOW()) AND busDutyPeople=#{value}")
    public List<BusinessBo> myBusWeek(String custName);
    /*上周新增*/
    @Select("SELECT cb.busId,  cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busTime`,b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId \n" +
            "WHERE YEARWEEK(DATE_FORMAT(busTime,'%Y-%m-%d')) = YEARWEEK(NOW())-1 AND busDutyPeople=#{value}")
    public List<BusinessBo> myBusLassWeek(String custName);
    /*本月新增*/
    @Select("SELECT cb.busId,  cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busTime`,b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId \n" +
            "WHERE DATE_FORMAT( busTime, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) AND busDutyPeople=#{value}")
    public List<BusinessBo> myBusMonth(String custName);
    /*上月新增*/
    @Select("SELECT cb.busId,  cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busTime`,b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId \n" +
            "WHERE PERIOD_DIFF( DATE_FORMAT( NOW( ) , '%Y%m' ) , DATE_FORMAT( busTime, '%Y%m' ) ) =1 AND busDutyPeople=#{value}")
    public List<BusinessBo> myBusLassMonth(String custName);
    /*本季度新增*/
    @Select("SELECT cb.busId,  cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busTime`,b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId \n" +
            "WHERE QUARTER(busTime)=QUARTER(NOW()) AND busDutyPeople=#{value}")
    public List<BusinessBo> myBusQuarter(String custName);
    /*上季度新增*/
    @Select("SELECT cb.busId,  cb.`busName` AS busName,cb.`busStage` AS busStage,cb.`busBeforeMoney` AS busBeforeMoney,cb.`busDutyPeople` AS busDutyPeople,bd.docTime AS docTime,bi.tlbs AS invitationId  FROM \n" +
            "(SELECT b.`busTime`,b.`busId`,b.busName,b.`busStage`,b.`busBeforeMoney`,b.`busDutyPeople`  FROM  business b )AS cb  LEFT JOIN (SELECT b.busId, MAX(d.docTime)AS docTime  FROM business b\n" +
            "LEFT JOIN documentary d ON b.`busId`=d.busId GROUP BY b.busId )AS bd  ON cb.`busId`=bd.busId LEFT JOIN  (SELECT i.`busId`,COUNT(i.busId)AS tlbs FROM business b LEFT JOIN invitation i ON b.`busId`=i.busId GROUP BY b.busId)AS bi ON cb.`busId`=bi.busId\n" +
            "WHERE QUARTER(busTime)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER)) AND busDutyPeople=#{value}")
    public List<BusinessBo> myBusLassQuarter(String custName);


    /*成交商机的数量*/
    @Select("SELECT  COUNT(busId) FROM business  WHERE busStage = '成交' AND busDutyPeople=#{value}")
    public  Integer successBusNumber(String custName);
    /*丢单商机的数量*/
    @Select("SELECT COUNT(busId) FROM business  WHERE busStage = '丢单' AND busDutyPeople=#{value}")
    public  Integer myThrowNumber(String custName);
    /*搁置商机的数量*/
    @Select("SELECT COUNT(busId) FROM business  WHERE busStage = '搁置' AND busDutyPeople=#{value}")
    public  Integer myShelveNumber(String custName);
    /*进行中的商机数量*/
    @Select("SELECT COUNT(busId) FROM `business`  WHERE busStage != '成交' AND busStage != '丢单' AND busDutyPeople=#{value}")
    public Integer proceedNumber(String custName);
    /*7天未跟单数量*/
    @Select("SELECT COUNT(b.busId) FROM `business` b,`documentary` d  WHERE b.busId=d.busId AND DATEDIFF(NOW(),docTime)>7 AND DATEDIFF(NOW(),docTime)<30 AND busDutyPeople=#{value}")
    public Integer sevenNumber(String custName);
    /*30天未跟单数量*/
    @Select("SELECT COUNT(b.busId) FROM `business` b,`documentary` d  WHERE b.busId=d.busId AND DATEDIFF(NOW(),docTime)>=30 AND DATEDIFF(NOW(),docTime)<60 AND busDutyPeople=#{value}")
    public Integer thrityNumber(String custName);
    /*90天未跟单数量*/
    @Select("SELECT COUNT(b.busId),d.docTime FROM `business` b,`documentary` d  WHERE b.busId=d.busId AND DATEDIFF(NOW(),docTime)>90 AND busDutyPeople=#{value}")
    public Integer nenityNumber(String custName);
    /*本周新增数量*/
    @Select("SELECT COUNT(busId) FROM `business` WHERE YEARWEEK(DATE_FORMAT(busTime,'%Y-%m-%d')) = YEARWEEK(NOW())AND busDutyPeople=#{value}")
    public Integer weekNumber(String custName);
    /*上周新增数量*/
    @Select("SELECT COUNT(busId) FROM `business` WHERE YEARWEEK(DATE_FORMAT(busTime,'%Y-%m-%d')) = YEARWEEK(NOW())-1 AND busDutyPeople=#{value}")
    public Integer weekLastNumber(String custName);
    /*本月新增数量*/
    @Select("SELECT COUNT(busId) FROM `business` WHERE DATE_FORMAT( busTime, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) AND busDutyPeople=#{value}")
    public Integer monthNumber(String custName);
    /*上月新增数量*/
    @Select("SELECT COUNT(busId) FROM `business` WHERE PERIOD_DIFF( DATE_FORMAT( NOW( ) , '%Y%m' ) , DATE_FORMAT( busTime, '%Y%m' ) ) =1 AND busDutyPeople=#{value}")
    public Integer monthLastNumber(String custName);
    /*本季度新增数量*/
    @Select("SELECT COUNT(busId) FROM `business` WHERE QUARTER(busTime)=QUARTER(NOW()) AND busDutyPeople=#{value}")
    public Integer quarterNumber(String custName);
    /*上季度新增数量*/
    @Select("SELECT COUNT(busId) FROM `business` WHERE QUARTER(busTime)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))AND busDutyPeople=#{value}")
    public Integer quarterLassNumber(String custName);

}
