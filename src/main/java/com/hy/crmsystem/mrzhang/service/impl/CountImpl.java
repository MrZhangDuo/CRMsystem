package com.hy.crmsystem.mrzhang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crmsystem.mrpan.entity.Customer;
import com.hy.crmsystem.mrpan.mapper.CustomerMapper;
import com.hy.crmsystem.mrpan.service.impl.BusinessServiceImpl;
import com.hy.crmsystem.mrzhang.entity.CountDocumetMoery;
import com.hy.crmsystem.mrzhang.mapper.CountMmapper;
import com.hy.crmsystem.mrzhang.service.ICountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountImpl implements ICountService {
    @Autowired
    com.hy.crmsystem.mrfan.service.impl.ContractServiceImpl contractService;
    @Autowired
    BusinessServiceImpl businessService;
    @Autowired
    CountMmapper countMmapper;
    @Autowired
    CustomerMapper customerMapper;

    public Float countBusinessMoneryBZ(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("busBeforeMoney");
        queryWrapper.apply("YEARWEEK(DATE_FORMAT(busTime,'%Y-%m-%d')) = YEARWEEK(NOW())","");
        int count = businessService.count(queryWrapper);
        if(count != 0){
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.select("SUM(busBeforeMoney)as busBeforeMoney");
            queryWrapper1.apply("YEARWEEK(DATE_FORMAT(busTime,'%Y-%m-%d')) = YEARWEEK(NOW())","");
            return businessService.getOne(queryWrapper1).getBusBeforeMoney()/10000;
        }else{
            return 0f;
        }

    }

    public Float countBusinessMonerySZ(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("busBeforeMoney");
        queryWrapper.apply("YEARWEEK(DATE_FORMAT(busTime,'%Y-%m-%d')) = YEARWEEK(NOW())-1","");
        int count = businessService.count(queryWrapper);
        if(count != 0){
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.select("SUM(busBeforeMoney)as busBeforeMoney");
            queryWrapper1.apply("YEARWEEK(DATE_FORMAT(busTime,'%Y-%m-%d')) = YEARWEEK(NOW())-1","");
            return businessService.getOne(queryWrapper1).getBusBeforeMoney()/10000;
        }else{
            return 0f;
        }
    }

    public Float countBusinessMoneryBY(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("busBeforeMoney");
        queryWrapper.apply("DATE_FORMAT(busTime,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')","");
        int count = businessService.count(queryWrapper);
        if(count != 0){
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.select("SUM(busBeforeMoney)as busBeforeMoney");
            queryWrapper1.apply("DATE_FORMAT(busTime,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')","");
            return businessService.getOne(queryWrapper1).getBusBeforeMoney()/10000;
        }else{
            return 0f;
        }
    }

    public Float countBusinessMonerySY(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("busBeforeMoney");
        queryWrapper.apply("DATE_FORMAT(busTime,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')","");
        int count = businessService.count(queryWrapper);
        if(count != 0){
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.select("SUM(busBeforeMoney)as busBeforeMoney");
            queryWrapper1.apply("DATE_FORMAT(busTime,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')","");
            return businessService.getOne(queryWrapper1).getBusBeforeMoney()/10000;
        }else{
            return 0f;
        }
    }

    public Float countBusinessMoneryBJ(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("busBeforeMoney");
        queryWrapper.apply("QUARTER(busTime)=QUARTER(NOW())","");
        int count = businessService.count(queryWrapper);
        if(count != 0){
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.select("SUM(busBeforeMoney)as busBeforeMoney");
            queryWrapper1.apply("QUARTER(busTime)=QUARTER(NOW())","");
            return businessService.getOne(queryWrapper1).getBusBeforeMoney()/10000;
        }else{
            return 0f;
        }
    }

    public Float countBusinessMonerySJ(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("busBeforeMoney");
        queryWrapper.apply("QUARTER(busTime)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))","");
        int count = businessService.count(queryWrapper);
        if(count != 0){
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.select("SUM(busBeforeMoney)as busBeforeMoney");
            queryWrapper1.apply("QUARTER(busTime)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))","");
            return businessService.getOne(queryWrapper1).getBusBeforeMoney()/10000;
        }else{
            return 0f;
        }
    }

    public Float countBusinessMoneryBN(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("busBeforeMoney");
        queryWrapper.apply("YEAR(busTime)=YEAR(NOW())","");
        int count = businessService.count(queryWrapper);
        if(count != 0){
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.select("SUM(busBeforeMoney)as busBeforeMoney");
            queryWrapper1.apply("YEAR(busTime)=YEAR(NOW())","");
            return businessService.getOne(queryWrapper1).getBusBeforeMoney()/10000;
        }else{
            return 0f;
        }
    }

    public Float countBusinessMonerySN(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("busBeforeMoney");
        queryWrapper.apply("YEAR(busTime) = YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR))","");
        int count = businessService.count(queryWrapper);
        if(count != 0){
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.select("SUM(busBeforeMoney)as busBeforeMoney");
            queryWrapper1.apply("YEAR(busTime) = YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR))","");
            return businessService.getOne(queryWrapper1).getBusBeforeMoney()/10000;
        }else{
            return 0f;
        }
    }
    /**************************************** 统计商机金额 ***********************************************************/

    /**************************************** 统计合同金额 ******************************************************************************************************/

    public Float countContractMoneryBZ(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("contractMoney");
        queryWrapper.apply("YEARWEEK(DATE_FORMAT(contractStarTime,'%Y-%m-%d')) = YEARWEEK(NOW())","");
        int count = contractService.count(queryWrapper);
        if(count != 0){
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.select("SUM(contractMoney)as contractMoney");
            queryWrapper1.apply("YEARWEEK(DATE_FORMAT(contractStarTime,'%Y-%m-%d')) = YEARWEEK(NOW())","");
            return contractService.getOne(queryWrapper1).getContractMoney()/10000;
        }else{
            return 0f;
        }

    }

    public Float countContractMonerySZ(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("contractMoney");
        queryWrapper.apply("YEARWEEK(DATE_FORMAT(contractStarTime,'%Y-%m-%d')) = YEARWEEK(NOW())-1","");
        int count = contractService.count(queryWrapper);
        if(count != 0){
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.select("SUM(contractMoney)as contractMoney");
            queryWrapper1.apply("YEARWEEK(DATE_FORMAT(contractStarTime,'%Y-%m-%d')) = YEARWEEK(NOW())-1","");
            return contractService.getOne(queryWrapper1).getContractMoney()/10000;
        }else{
            return 0f;
        }
    }

    public Float countContractMoneryBY(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("contractMoney");
        queryWrapper.apply("DATE_FORMAT(contractStarTime,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')","");
        int count = contractService.count(queryWrapper);
        if(count != 0){
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.select("SUM(contractMoney)as contractMoney");
            queryWrapper1.apply("DATE_FORMAT(contractStarTime,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')","");
            return contractService.getOne(queryWrapper1).getContractMoney()/10000;
        }else{
            return 0f;
        }
    }

    public Float countContractMonerySY(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("contractMoney");
        queryWrapper.apply("DATE_FORMAT(contractStarTime,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')","");
        int count = contractService.count(queryWrapper);
        if(count != 0){
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.select("SUM(contractMoney)as contractMoney");
            queryWrapper1.apply("DATE_FORMAT(contractStarTime,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')","");
            return contractService.getOne(queryWrapper1).getContractMoney()/10000;
        }else{
            return 0f;
        }
    }

    public Float countContractMoneryBJ(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("contractMoney");
        queryWrapper.apply("QUARTER(contractStarTime)=QUARTER(NOW())","");
        int count = contractService.count(queryWrapper);
        if(count != 0){
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.select("SUM(contractMoney)as contractMoney");
            queryWrapper1.apply("QUARTER(contractStarTime)=QUARTER(NOW())","");
            return contractService.getOne(queryWrapper1).getContractMoney()/10000;
        }else{
            return 0f;
        }
    }

    public Float countContractMonerySJ(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("contractMoney");
        queryWrapper.apply("QUARTER(contractStarTime)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))","");
        int count = contractService.count(queryWrapper);
        if(count != 0){
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.select("SUM(contractMoney)as contractMoney");
            queryWrapper1.apply("QUARTER(contractStarTime)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))","");
            return contractService.getOne(queryWrapper1).getContractMoney()/10000;
        }else{
            return 0f;
        }
    }

    public Float countContractMoneryBN(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("contractMoney");
        queryWrapper.apply("YEAR(contractStarTime)=YEAR(NOW())","");
        int count = contractService.count(queryWrapper);
        if(count != 0){
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.select("SUM(contractMoney)as contractMoney");
            queryWrapper1.apply("YEAR(contractStarTime)=YEAR(NOW())","");
            return contractService.getOne(queryWrapper1).getContractMoney()/10000;
        }else{
            return 0f;
        }
    }

    public Float countContractMonerySN(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("contractMoney");
        queryWrapper.apply("YEAR(contractStarTime) = YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR))","");
        int count = contractService.count(queryWrapper);
        if(count != 0){
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.select("SUM(contractMoney)as contractMoney");
            queryWrapper1.apply("YEAR(contractStarTime) = YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR))","");
            return contractService.getOne(queryWrapper1).getContractMoney()/10000;
        }else{
            return 0f;
        }
    }
    /**************************************** 统计合同金额 ***********************************************************/

    /**************************************** 统计跟单金额 ***********************************************************/

    /**
     * 统计跟单本周的预成交金额
     * */
    public Float countDocumentaryMoneyBZ(){
        if(StringUtils.isNotEmpty(countMmapper.countDocumentaryMoneyBZ())){
            return Float.parseFloat(countMmapper.countDocumentaryMoneyBZ())/10000;
        }
        return 0.0f;
    }

    /**
     * 统计跟单上周的预成交金额
     * */
    public Float countDocumentaryMoneySZ(){
        if(StringUtils.isNotEmpty(countMmapper.countDocumentaryMoneySZ())){
            return Float.parseFloat(countMmapper.countDocumentaryMoneySZ())/10000;
        }
        return 0.0f;
    }

    /**
     * 统计跟单本月的预成交金额
     * */
    public Float countDocumentaryMoneyBY(){
        if(StringUtils.isNotEmpty(countMmapper.countDocumentaryMoneyBY())){
            return Float.parseFloat(countMmapper.countDocumentaryMoneyBY())/10000;
        }
        return 0.0f;
    }

    /**
     * 统计跟单上月的预成交金额
     * */
    public Float countDocumentaryMoneySY(){
        if(StringUtils.isNotEmpty(countMmapper.countDocumentaryMoneySY())){
            return Float.parseFloat(countMmapper.countDocumentaryMoneySY())/10000;
        }
        return 0.0f;
    }

    /**
     * 统计跟单本季度的预成交金额
     * */
    public Float countDocumentaryMoneyBJ(){
        if(StringUtils.isNotEmpty(countMmapper.countDocumentaryMoneyBJ())){
            return Float.parseFloat(countMmapper.countDocumentaryMoneyBJ())/10000;
        }
        return 0.0f;
    }

    /**
     * 统计跟单上季度的预成交金额
     * */
    public Float countDocumentaryMoneySJ(){
        if(StringUtils.isNotEmpty(countMmapper.countDocumentaryMoneySJ())){
            return Float.parseFloat(countMmapper.countDocumentaryMoneySJ())/10000;
        }
        return 0.0f;
    }

    /**
     * 统计跟单本年度的预成交金额
     * */
    public Float countDocumentaryMoneyBN(){
        if(StringUtils.isNotEmpty(countMmapper.countDocumentaryMoneyBN())){
            return Float.parseFloat(countMmapper.countDocumentaryMoneyBN())/10000;
        }
        return 0.0f;
    }

    /**
     * 统计跟单上年度的预成交金额
     * */
    public Float countDocumentaryMoneySN(){
        if(StringUtils.isNotEmpty(countMmapper.countDocumentaryMoneySN())){
            return Float.parseFloat(countMmapper.countDocumentaryMoneySN())/10000;
        }
        return 0.0f;
    }



    public Float countChengJMoneryBZ(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("busBeforeMoney");
        queryWrapper.eq("busStage","成交");
        queryWrapper.apply("YEARWEEK(DATE_FORMAT(busTime,'%Y-%m-%d')) = YEARWEEK(NOW())","");
        queryWrapper.groupBy("busStage");
        int count = businessService.count(queryWrapper);
        if(count != 0){
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.select("SUM(busBeforeMoney)as busBeforeMoney");
            queryWrapper.eq("busStage","成交");
            queryWrapper1.apply("YEARWEEK(DATE_FORMAT(busTime,'%Y-%m-%d')) = YEARWEEK(NOW())","");
            queryWrapper.groupBy("busStage");
            return businessService.getOne(queryWrapper1).getBusBeforeMoney()/10000;
        }else{
            return 0f;
        }

    }

    public Float countChengJMonerySZ(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("busBeforeMoney");
        queryWrapper.eq("busStage","成交");
        queryWrapper.apply("YEARWEEK(DATE_FORMAT(busTime,'%Y-%m-%d')) = YEARWEEK(NOW())-1","");
        queryWrapper.groupBy("busStage");
        int count = businessService.count(queryWrapper);
        if(count != 0){
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.select("SUM(busBeforeMoney)as busBeforeMoney");
            queryWrapper.eq("busStage","成交");
            queryWrapper1.apply("YEARWEEK(DATE_FORMAT(busTime,'%Y-%m-%d')) = YEARWEEK(NOW())-1","");
            queryWrapper.groupBy("busStage");
            return businessService.getOne(queryWrapper1).getBusBeforeMoney()/10000;
        }else{
            return 0f;
        }
    }

    public Float countChengJMoneryBY(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("busBeforeMoney");
        queryWrapper.eq("busStage","成交");
        queryWrapper.apply("DATE_FORMAT(busTime,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')","");
        queryWrapper.groupBy("busStage");
        int count = businessService.count(queryWrapper);
        if(count != 0){
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.select("SUM(busBeforeMoney)as busBeforeMoney");
            queryWrapper.eq("busStage","成交");
            queryWrapper1.apply("DATE_FORMAT(busTime,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')","");
            queryWrapper.groupBy("busStage");
            return businessService.getOne(queryWrapper1).getBusBeforeMoney()/10000;
        }else{
            return 0f;
        }
    }

    public Float countChengJMonerySY(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("busBeforeMoney");
        queryWrapper.eq("busStage","成交");
        queryWrapper.apply("DATE_FORMAT(busTime,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')","");
        queryWrapper.groupBy("busStage");
        int count = businessService.count(queryWrapper);
        if(count != 0){
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.select("SUM(busBeforeMoney)as busBeforeMoney");
            queryWrapper.eq("busStage","成交");
            queryWrapper1.apply("DATE_FORMAT(busTime,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')","");
            queryWrapper.groupBy("busStage");
            return businessService.getOne(queryWrapper1).getBusBeforeMoney()/10000;
        }else{
            return 0f;
        }
    }

    public Float countChengJMoneryBJ(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("busBeforeMoney");
        queryWrapper.eq("busStage","成交");
        queryWrapper.apply("QUARTER(busTime)=QUARTER(NOW())","");
        queryWrapper.groupBy("busStage");
        int count = businessService.count(queryWrapper);
        if(count != 0){
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.select("SUM(busBeforeMoney)as busBeforeMoney");
            queryWrapper.eq("busStage","成交");
            queryWrapper1.apply("QUARTER(busTime)=QUARTER(NOW())","");
            queryWrapper.groupBy("busStage");
            return businessService.getOne(queryWrapper1).getBusBeforeMoney()/10000;
        }else{
            return 0f;
        }
    }

    public Float countChengJMonerySJ(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("busBeforeMoney");
        queryWrapper.eq("busStage","成交");
        queryWrapper.apply("QUARTER(busTime)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))","");
        queryWrapper.groupBy("busStage");
        int count = businessService.count(queryWrapper);
        if(count != 0){
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.select("SUM(busBeforeMoney)as busBeforeMoney");
            queryWrapper.eq("busStage","成交");
            queryWrapper1.apply("QUARTER(busTime)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))","");
            queryWrapper.groupBy("busStage");
            return businessService.getOne(queryWrapper1).getBusBeforeMoney()/10000;
        }else{
            return 0f;
        }
    }

    public Float countChengJMoneryBN(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("busBeforeMoney");
        queryWrapper.eq("busStage","成交");
        queryWrapper.apply("YEAR(busTime)=YEAR(NOW())","");
        queryWrapper.groupBy("busStage");
        int count = businessService.count(queryWrapper);
        if(count != 0){
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.select("SUM(busBeforeMoney)as busBeforeMoney");
            queryWrapper.eq("busStage","成交");
            queryWrapper1.apply("YEAR(busTime)=YEAR(NOW())","");
            queryWrapper.groupBy("busStage");
            return businessService.getOne(queryWrapper1).getBusBeforeMoney()/10000;
        }else{
            return 0f;
        }
    }

    public Float countChengJMonerySN(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("busBeforeMoney");
        queryWrapper.eq("busStage","成交");
        queryWrapper.apply("YEAR(busTime) = YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR))","");
        queryWrapper.groupBy("busStage");
        int count = businessService.count(queryWrapper);
        if(count != 0){
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.select("SUM(busBeforeMoney)as busBeforeMoney");
            queryWrapper.eq("busStage","成交");
            queryWrapper1.apply("YEAR(busTime) = YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR))","");
            queryWrapper.groupBy("busStage");
            return businessService.getOne(queryWrapper1).getBusBeforeMoney()/10000;
        }else{
            return 0f;
        }
    }

    public List<CountDocumetMoery> countCustBZMoney(Integer page, Integer limit){
        QueryWrapper queryWrapper = new QueryWrapper();
        /* 查询所有客户 */
        IPage<Customer> customerIPage = customerMapper.selectPage(new Page<>(page,limit),queryWrapper);
        /* 转换为集合客户 进行遍历 */
        List<Customer> customerList = customerIPage.getRecords();
        List<CountDocumetMoery> list = new ArrayList();
        for (int i = 0; i <customerList.size() ; i++) {
            CountDocumetMoery countDocumetMoery= new CountDocumetMoery();
            String custName=customerList.get(i).getCustName();
            countDocumetMoery.setCustName(custName);
            if(countMmapper.countCustBusBZ(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setBzsj(countMmapper.countCustBusBZ(customerList.get(i).getCustId()).getBzsj());
            }else{
                countDocumetMoery.setBzsj(0f);
            }

            if(countMmapper.countCustBusSZ(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setSzsj(countMmapper.countCustBusSZ(customerList.get(i).getCustId()).getSzsj());
            }else{
                countDocumetMoery.setSzsj(0f);
            }

            if(countMmapper.countCustCJBZ(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setCjbz(countMmapper.countCustCJBZ(customerList.get(i).getCustId()).getCjbz());
            }else{
                countDocumetMoery.setCjbz(0f);
            }

            if(countMmapper.countCustCJSZ(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setCjsz(countMmapper.countCustCJSZ(customerList.get(i).getCustId()).getCjsz());
            }else{
                countDocumetMoery.setCjsz(0f);
            }

            if(countMmapper.countCustDocBZ(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setGdbz(countMmapper.countCustDocBZ(customerList.get(i).getCustId()).getGdbz());
            }else{
                countDocumetMoery.setGdbz(0f);
            }

            if(countMmapper.countCustDocSZ(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setGdsz(countMmapper.countCustDocSZ(customerList.get(i).getCustId()).getGdsz());
            }else{
                countDocumetMoery.setGdsz(0f);
            }

            if(countMmapper.countCustConBZ(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setHtbz(countMmapper.countCustConBZ(customerList.get(i).getCustId()).getHtbz());
            }else{
                countDocumetMoery.setHtbz(0f);
            }

            if(countMmapper.countCustConSZ(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setHtsz(countMmapper.countCustConSZ(customerList.get(i).getCustId()).getHtsz());
            }else{
                countDocumetMoery.setHtsz(0f);
            }

            list.add(countDocumetMoery);
        }
        return list;
    }


    public List<CountDocumetMoery> countCustBYMoney(Integer page, Integer limit){
        QueryWrapper queryWrapper = new QueryWrapper();
        /* 查询所有客户 */
        IPage<Customer> customerIPage = customerMapper.selectPage(new Page<>(page,limit),queryWrapper);
        /* 转换为集合客户 进行遍历 */
        List<Customer> customerList = customerIPage.getRecords();
        List<CountDocumetMoery> list = new ArrayList();
        for (int i = 0; i <customerList.size() ; i++) {
            CountDocumetMoery countDocumetMoery= new CountDocumetMoery();
            String custName=customerList.get(i).getCustName();
            countDocumetMoery.setCustName(custName);
            if(countMmapper.countCustBusBY(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setBysj(countMmapper.countCustBusBY(customerList.get(i).getCustId()).getBysj());
            }else{
                countDocumetMoery.setBysj(0f);
            }

            if(countMmapper.countCustBusSY(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setSysj(countMmapper.countCustBusSY(customerList.get(i).getCustId()).getSysj());
            }else{
                countDocumetMoery.setSysj(0f);
            }

            if(countMmapper.countCustCJBY(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setBycj(countMmapper.countCustCJBY(customerList.get(i).getCustId()).getBycj());
            }else{
                countDocumetMoery.setBycj(0f);
            }

            if(countMmapper.countCustCJSY(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setSycj(countMmapper.countCustCJSY(customerList.get(i).getCustId()).getSycj());
            }else{
                countDocumetMoery.setSycj(0f);
            }

            if(countMmapper.countCustDocBY(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setBygd(countMmapper.countCustDocBY(customerList.get(i).getCustId()).getBygd());
            }else{
                countDocumetMoery.setBygd(0f);
            }

            if(countMmapper.countCustDocSY(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setSygd(countMmapper.countCustDocSY(customerList.get(i).getCustId()).getSygd());
            }else{
                countDocumetMoery.setSygd(0f);
            }

            if(countMmapper.countCustConBY(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setByht(countMmapper.countCustConBY(customerList.get(i).getCustId()).getByht());
            }else{
                countDocumetMoery.setByht(0f);
            }

            if(countMmapper.countCustConSY(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setSyht(countMmapper.countCustConSY(customerList.get(i).getCustId()).getSyht());
            }else{
                countDocumetMoery.setSyht(0f);
            }

            list.add(countDocumetMoery);
        }
        return list;
    }

    public List<CountDocumetMoery> countCustBJMoney(Integer page, Integer limit){
        QueryWrapper queryWrapper = new QueryWrapper();
        /* 查询所有客户 */
        IPage<Customer> customerIPage = customerMapper.selectPage(new Page<>(page,limit),queryWrapper);
        /* 转换为集合客户 进行遍历 */
        List<Customer> customerList = customerIPage.getRecords();
        List<CountDocumetMoery> list = new ArrayList();
        for (int i = 0; i <customerList.size() ; i++) {
            CountDocumetMoery countDocumetMoery= new CountDocumetMoery();
            String custName=customerList.get(i).getCustName();
            countDocumetMoery.setCustName(custName);
            if(countMmapper.countCustBusBJ(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setBjsj(countMmapper.countCustBusBJ(customerList.get(i).getCustId()).getBjsj());
            }else{
                countDocumetMoery.setBjsj(0f);
            }

            if(countMmapper.countCustBusSJ(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setSjsj(countMmapper.countCustBusSJ(customerList.get(i).getCustId()).getSjsj());
            }else{
                countDocumetMoery.setSjsj(0f);
            }

            if(countMmapper.countCustCJBJ(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setBjcj(countMmapper.countCustCJBJ(customerList.get(i).getCustId()).getBjcj());
            }else{
                countDocumetMoery.setBjcj(0f);
            }

            if(countMmapper.countCustCJSJ(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setSjcj(countMmapper.countCustCJSJ(customerList.get(i).getCustId()).getSjcj());
            }else{
                countDocumetMoery.setSjcj(0f);
            }

            if(countMmapper.countCustDocBJ(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setBjgd(countMmapper.countCustDocBJ(customerList.get(i).getCustId()).getBjgd());
            }else{
                countDocumetMoery.setBjgd(0f);
            }

            if(countMmapper.countCustDocSJ(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setSjgd(countMmapper.countCustDocSJ(customerList.get(i).getCustId()).getSjgd());
            }else{
                countDocumetMoery.setSjgd(0f);
            }

            if(countMmapper.countCustConBJ(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setBjht(countMmapper.countCustConBJ(customerList.get(i).getCustId()).getBjht());
            }else{
                countDocumetMoery.setBjht(0f);
            }

            if(countMmapper.countCustConSJ(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setSjht(countMmapper.countCustConSJ(customerList.get(i).getCustId()).getSjht());
            }else{
                countDocumetMoery.setSjht(0f);
            }

            list.add(countDocumetMoery);
        }
        return list;
    }



    public List<CountDocumetMoery> countCustBNMoney(Integer page, Integer limit){
        QueryWrapper queryWrapper = new QueryWrapper();
        /* 查询所有客户 */
        IPage<Customer> customerIPage = customerMapper.selectPage(new Page<>(page,limit),queryWrapper);
        /* 转换为集合客户 进行遍历 */
        List<Customer> customerList = customerIPage.getRecords();
        List<CountDocumetMoery> list = new ArrayList();
        for (int i = 0; i <customerList.size() ; i++) {
            CountDocumetMoery countDocumetMoery= new CountDocumetMoery();
            String custName=customerList.get(i).getCustName();
            countDocumetMoery.setCustName(custName);
            if(countMmapper.countCustBusBN(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setBnsj(countMmapper.countCustBusBN(customerList.get(i).getCustId()).getBnsj());
            }else{
                countDocumetMoery.setBnsj(0f);
            }

            if(countMmapper.countCustBusSN(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setSnsj(countMmapper.countCustBusSN(customerList.get(i).getCustId()).getSnsj());
            }else{
                countDocumetMoery.setSnsj(0f);
            }

            if(countMmapper.countCustCJBN(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setBncj(countMmapper.countCustCJBN(customerList.get(i).getCustId()).getBncj());
            }else{
                countDocumetMoery.setBncj(0f);
            }

            if(countMmapper.countCustCJSN(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setSncj(countMmapper.countCustCJSN(customerList.get(i).getCustId()).getSncj());
            }else{
                countDocumetMoery.setSncj(0f);
            }

            if(countMmapper.countCustDocBN(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setBngd(countMmapper.countCustDocBN(customerList.get(i).getCustId()).getBngd());
            }else{
                countDocumetMoery.setBngd(0f);
            }

            if(countMmapper.countCustDocSN(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setSngd(countMmapper.countCustDocSN(customerList.get(i).getCustId()).getSngd());
            }else{
                countDocumetMoery.setSngd(0f);
            }

            if(countMmapper.countCustConBN(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setBnht(countMmapper.countCustConBN(customerList.get(i).getCustId()).getBnht());
            }else{
                countDocumetMoery.setBnht(0f);
            }

            if(countMmapper.countCustConSN(customerList.get(i).getCustId()).getCustIds()!=0){
                countDocumetMoery.setSnht(countMmapper.countCustConSN(customerList.get(i).getCustId()).getSnht());
            }else{
                countDocumetMoery.setSnht(0f);
            }

            list.add(countDocumetMoery);
        }
        return list;
    }
}
