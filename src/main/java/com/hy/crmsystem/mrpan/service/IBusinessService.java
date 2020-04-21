package com.hy.crmsystem.mrpan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crmsystem.mrpan.entity.Business;
import com.hy.crmsystem.mrpan.entity.BusinessBo;
import com.hy.crmsystem.mrpan.entity.BusinessCustBo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
public interface IBusinessService extends IService<Business> {


 /**
  * 查询商机名称
  * @return
  */
 List<Business> queryBusName();

        //点商机数时查询所有商机的对应信息
        public List<BusinessBo> selectBusInfo(@Param("businessBo") BusinessBo businessBo, Integer currentPage, Integer pageSize);
       //查询所有商机的信息
       public List<BusinessBo> selectAllBusInfo(@Param("businessBo") BusinessBo businessBo,Integer currentPage, Integer pageSize);
       //查询我的商机中商机的信息
        public List<BusinessBo> MyBusInfo(@Param("businessBo") BusinessBo businessBo,@Param("custName") String custName,Integer currentPage, Integer pageSize);
     //根据商机负责人查询我的商机信息
     public List<BusinessBo> MyBusInfoByResponsiblePeople(String custName,Integer currentPage, Integer pageSize);
     //根据商机参与人查询我的商机信息
     public List<BusinessBo> MyBusInfoByJoinPeople(String custName,Integer currentPage, Integer pageSize);
     //根据商机关注人查询我的商机信息
     public List<BusinessBo> MyBusInfoByCarePeople(String custName,Integer currentPage, Integer pageSize);
    //查询我的商机中商机负责人是登陆人的商机条数
    public Integer BusResponsiblePeopleNumber(String custName);
    //查询我的商机中商机参与人是登陆人的商机条数
    public Integer BusJoinPeopleNumber(String custName);
    //查询我的商机中商机关注人是登陆人的商机条数
    public Integer BusCarePeopleNumber(String custName);
 /*根据商机ID查询客户的客户名称，所属行业，所在城市，详细地址*/
    public BusinessCustBo custByBusId(Integer custId);
    /*查询进行中的商机*/
    public List<BusinessBo> proceedBus(Integer currentPage, Integer pageSize);
    /*查询进行中的商机数量*/
    public Integer proceedBusNumber();
    /*已成交商机*/
    public List<BusinessBo> tradedBus(Integer currentPage, Integer pageSize);
    /*查询已成交商机数量*/
    public Integer tradedBusNumber();
    /*已丢单商机*/
    public List<BusinessBo> throwBus(Integer currentPage, Integer pageSize);
   /*已丢单商机数量*/
    public Integer throwBusNumber();
    /*已搁置商机*/
    public List<BusinessBo> shelveBus(Integer currentPage, Integer pageSize);
   /*已搁置商机数量*/
    public Integer shelveBusNumber();
    /*七天未跟单*/
    public List<BusinessBo> docTimeLessSeven(Integer currentPage, Integer pageSize);
    /*七天未跟单数量*/
    public Integer docTimeLessSevenNumber();
    /*三十天未跟单*/
    public List<BusinessBo> docTimeLessThirty(Integer currentPage, Integer pageSize);
    /*三十天未跟单数量*/
    public Integer docTimeLessThirtyNumber();
    /*九十天未跟单*/
    public List<BusinessBo> docTimeLessNinety(Integer currentPage, Integer pageSize);
    /*九十天未跟单数量*/
    public Integer docTimeLessNinetyNumber();
 /*本周新增*/
 public List<BusinessBo> weekAdd(Integer currentPage, Integer pageSize);
 /*本周新增数量*/
 public Integer weekAddNumber();
 /*上周新增*/
 public List<BusinessBo> lastWeekAdd(Integer currentPage, Integer pageSize);
 /*上周新增数量*/
 public Integer lastWeekAddNumber();
 /*本月新增*/
 public List<BusinessBo> monthAdd(Integer currentPage, Integer pageSize);
 /*本月新增数量*/
 public Integer monthAddNumber();
 /*上月新增*/
 public List<BusinessBo> lastMonthAdd(Integer currentPage, Integer pageSize);
 /*上月新增数量*/
 public Integer lastMonthAddNumber();
 /*本季度新增*/
 public List<BusinessBo> quarterAdd(Integer currentPage, Integer pageSize);
 /*本季度新增数量*/
 public Integer quarterAddNumber();
 /*上季度新增*/
 public List<BusinessBo> lastQuarterAdd(Integer currentPage, Integer pageSize);
 /*上季度新增数量*/
 public Integer lastQuarterAddNumber();

 /*111111111111111111111111我的商机信息11111111111111111111111111111*/
    /*成交商机*/
    public List<BusinessBo> successBus(String custName,Integer currentPage, Integer pageSize);
    /*丢单商机*/
    public  List<BusinessBo> myThrow(String custName,Integer currentPage, Integer pageSize);
    /*搁置商机*/
    public List<BusinessBo> myShelve(String custName,Integer currentPage, Integer pageSize);
    /*进行中的商机*/
    public List<BusinessBo> myBusProceed(String custName,Integer currentPage, Integer pageSize);
    /*7天未跟单*/
    public List<BusinessBo> myBusSeven(String custName,Integer currentPage, Integer pageSize);
    /*30天未跟单*/
    public List<BusinessBo> myBusthirty(String custName,Integer currentPage, Integer pageSize);
    /*90天未跟单*/
    public List<BusinessBo> myBusNenity(String custName,Integer currentPage, Integer pageSize);
    /*本周新增*/
    public List<BusinessBo> myBusWeek(String custName,Integer currentPage, Integer pageSize);
    /*上周新增*/
    public List<BusinessBo> myBusLassWeek(String custName,Integer currentPage, Integer pageSize);
    /*本月新增*/
    public List<BusinessBo> myBusMonth(String custName,Integer currentPage, Integer pageSize);
    /*上月新增*/
    public List<BusinessBo> myBusLassMonth(String custName,Integer currentPage, Integer pageSize);
    /*本季度新增*/
    public List<BusinessBo> myBusQuarter(String custName,Integer currentPage, Integer pageSize);
    /*上季度新增*/
    public List<BusinessBo> myBusLassQuarter(String custName,Integer currentPage, Integer pageSize);

    /*成交商机的数量*/
    public  Integer successBusNumber(String custName);
    /*丢单商机的数量*/
    public  Integer myThrowNumber(String custName);
    /*搁置商机的数量*/
    public  Integer myShelveNumber(String custName);
    /*进行中的商机数量*/
    public Integer proceedNumber(String custName);
    /*7天未跟单数量*/
    public Integer sevenNumber(String custName);
    /*30天未跟单数量*/
    public Integer thrityNumber(String custName);
    /*90天未跟单数量*/
    public Integer nenityNumber(String custName);
    /*本周新增数量*/
    public Integer weekNumber(String custName);
    /*上周新增数量*/
    public Integer weekLastNumber(String custName);
    /*本月新增数量*/
    public Integer monthNumber(String custName);
    /*上月新增数量*/
    public Integer monthLastNumber(String custName);
    /*本季度新增数量*/
    public Integer quarterNumber(String custName);
    /*上季度新增数量*/
    public Integer quarterLassNumber(String custName);
}
