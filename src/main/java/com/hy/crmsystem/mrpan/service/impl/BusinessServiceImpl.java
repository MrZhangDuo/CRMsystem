package com.hy.crmsystem.mrpan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crmsystem.mrpan.entity.Business;
import com.hy.crmsystem.mrpan.entity.BusinessBo;
import com.hy.crmsystem.mrpan.entity.BusinessCustBo;
import com.hy.crmsystem.mrpan.mapper.BusinessMapper;
import com.hy.crmsystem.mrpan.service.IBusinessService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
@Transactional
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements IBusinessService {
    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public List<Business> queryBusName() {
        return this.businessMapper.queryBusName();
    }

    //点商机数时查询所有商机的对应信息
    public List<BusinessBo> selectBusInfo(@Param("businessBo")BusinessBo businessBo, Integer currentPage, Integer pageSize) {
        Page page = PageHelper.startPage(currentPage,pageSize, true);
        return businessMapper.selectBusInfo(businessBo);
    }

    //查询所有的商机信息
    public List<BusinessBo> selectAllBusInfo(Integer currentPage, Integer pageSize){
        Page page = PageHelper.startPage(currentPage,pageSize, true);
        return businessMapper.selectAllBusInfo();
    }

    //查询我的商机中商机的信息
    public List<BusinessBo> MyBusInfo(String custName,Integer currentPage, Integer pageSize){
        Page page = PageHelper.startPage(currentPage,pageSize, true);
        return businessMapper.MyBusInfo(custName);
    }
    //根据商机负责人查询我的商机信息
    public List<BusinessBo> MyBusInfoByResponsiblePeople(String custName,Integer currentPage, Integer pageSize){
        Page page = PageHelper.startPage(currentPage,pageSize, true);
        return businessMapper.MyBusInfoByResponsiblePeople(custName);
    }
    //查询我的商机中商机负责人是登陆人的商机条数
    public Integer BusResponsiblePeopleNumber(String custName){
      return  businessMapper.BusResponsiblePeopleNumber(custName);
    }
    //查询我的商机中商机参与人是登陆人的商机条数
    public Integer BusJoinPeopleNumber(String custName){
        return businessMapper.BusJoinPeopleNumber(custName);
    }
    //查询我的商机中商机关注人是登陆人的商机条数
    public Integer BusCarePeopleNumber(String custName){
        return businessMapper.BusJoinPeopleNumber(custName);
    }
    //根据商机参与人查询我的商机信息
    public List<BusinessBo> MyBusInfoByJoinPeople(String custName,Integer currentPage, Integer pageSize){
        Page page = PageHelper.startPage(currentPage,pageSize, true);
        return businessMapper.MyBusInfoByJoinPeople(custName);
    }
    //根据商机关注人查询我的商机信息
    public List<BusinessBo> MyBusInfoByCarePeople(String custName,Integer currentPage, Integer pageSize){
        Page page = PageHelper.startPage(currentPage,pageSize, true);
        List<BusinessBo> bus=businessMapper.MyBusInfoByCarePeople(custName);
        for (int i = 0; i <bus.size(); i++) {
            System.out.println("244321235145353242432314232322222222222222222222");
            System.out.println("============================"+bus.get(i).getBusName()+bus.get(i).getBusStage());
        }
        return bus;

    }

    /*根据商机名查询客户的客户名称，所属行业，所在城市，详细地址*/
    public BusinessCustBo custByBusId(Integer busId){
       return  businessMapper.custByBusId(busId);
    };

    /*查询进行中的商机*/
    public List<BusinessBo> proceedBus(Integer currentPage, Integer pageSize){
        Page page = PageHelper.startPage(currentPage,pageSize, true);
        return  businessMapper.proceedBus();
    }

    /*查询进行中的商机数量*/
    public Integer proceedBusNumber(){
      return  businessMapper.proceedBusNumber();
    }

    /*已成交商机*/
    public List<BusinessBo> tradedBus(Integer currentPage, Integer pageSize){
        Page page = PageHelper.startPage(currentPage,pageSize, true);
        return businessMapper.tradedBus();
    }
    /*查询已成交商机数量*/
    public Integer tradedBusNumber(){
        return businessMapper.tradedBusNumber();
    }

    /*已丢单商机*/
    public List<BusinessBo> throwBus(Integer currentPage, Integer pageSize){
        Page page = PageHelper.startPage(currentPage,pageSize, true);
       return businessMapper.throwBus();
    }
    /*已丢单商机数量*/
    public Integer throwBusNumber(){
        return businessMapper.throwBusNumber();
    }

    /*已搁置商机*/
    public List<BusinessBo> shelveBus(Integer currentPage, Integer pageSize){
        Page page = PageHelper.startPage(currentPage,pageSize, true);
        return businessMapper.shelveBus();
    }
    /*已搁置商机数量*/
    public Integer shelveBusNumber(){
        return businessMapper.shelveBusNumber();
    }

    /*七天未跟单*/
    public List<BusinessBo> docTimeLessSeven(Integer currentPage, Integer pageSize){
        Page page = PageHelper.startPage(currentPage,pageSize, true);
        return businessMapper.docTimeLessSeven();
    }
    /*七天未跟单数量*/
    public Integer docTimeLessSevenNumber(){
        return businessMapper.docTimeLessSevenNumber();
    }

    /*三十天未跟单*/
    public List<BusinessBo> docTimeLessThirty(Integer currentPage, Integer pageSize){
        Page page = PageHelper.startPage(currentPage,pageSize, true);
        return businessMapper.docTimeLessThirty();
    }
    /*三十天未跟单数量*/
    public Integer docTimeLessThirtyNumber(){
        return businessMapper.docTimeLessThirtyNumber();
    }

    /*九十天未跟单*/
    public List<BusinessBo> docTimeLessNinety(Integer currentPage, Integer pageSize){
        Page page = PageHelper.startPage(currentPage,pageSize, true);
        return businessMapper.docTimeLessNinety();
    }
     /*九十天未跟单数量*/
     public Integer docTimeLessNinetyNumber(){
         return businessMapper.docTimeLessNinetyNumber();
     }

    /*本周新增*/
    public List<BusinessBo> weekAdd(Integer currentPage, Integer pageSize){
        Page page = PageHelper.startPage(currentPage,pageSize, true);
       return  businessMapper.weekAdd();
    }
    /*本周新增数量*/
    public Integer weekAddNumber(){
        return businessMapper.weekAddNumber();
    }
    /*上周新增*/
    public List<BusinessBo> lastWeekAdd(Integer currentPage, Integer pageSize){
        Page page = PageHelper.startPage(currentPage,pageSize, true);
        return businessMapper.lastWeekAdd();
    }
    /*上周新增数量*/
    public Integer lastWeekAddNumber(){
        return businessMapper.lastWeekAddNumber();
    }

    /*本月新增*/
    public List<BusinessBo> monthAdd(Integer currentPage, Integer pageSize){
        Page page = PageHelper.startPage(currentPage,pageSize, true);
        return businessMapper.monthAdd();
    }
    /*本月新增数量*/
    public Integer monthAddNumber(){
        return businessMapper.monthAddNumber();
    }
    /*上月新增*/
    public List<BusinessBo> lastMonthAdd(Integer currentPage, Integer pageSize){
        Page page = PageHelper.startPage(currentPage,pageSize, true);
        return businessMapper.lastMonthAdd();
    }
    /*上月新增数量*/
    public Integer lastMonthAddNumber(){
        return businessMapper.lastMonthAddNumber();
    }
    /*本季度新增*/
    public List<BusinessBo> quarterAdd(Integer currentPage, Integer pageSize){
        Page page = PageHelper.startPage(currentPage,pageSize, true);
        return businessMapper.quarterAdd();
    }
    /*本季度新增数量*/
    public Integer quarterAddNumber(){
        return businessMapper.quarterAddNumber();
    }
    /*上季度新增*/
    public List<BusinessBo> lastQuarterAdd(Integer currentPage, Integer pageSize){
        Page page = PageHelper.startPage(currentPage,pageSize, true);
        return businessMapper.lastQuarterAdd();
    }
    /*上季度新增数量*/
    public Integer lastQuarterAddNumber(){
        return businessMapper.lastQuarterAddNumber();
    }

    /*111111111111111111111111我的商机信息11111111111111111111111111111*/

    /*成交商机*/
    public List<BusinessBo> successBus(String custName,Integer currentPage, Integer pageSize){
        Page page = PageHelper.startPage(currentPage,pageSize, true);
        return businessMapper.successBus(custName);
    };
    /*成交商机的数量*/
    public  Integer successBusNumber(String custName){
        return businessMapper.successBusNumber(custName);
    };
}
