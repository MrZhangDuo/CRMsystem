package com.hy.crmsystem.mrzhang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.hy.crmsystem.mrpan.service.impl.BusinessServiceImpl;
import com.hy.crmsystem.mrzhang.mapper.CountMmapper;
import com.hy.crmsystem.mrzhang.service.ICountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CountImpl implements ICountService {
    @Autowired
    com.hy.crmsystem.mrfan.service.impl.ContractServiceImpl contractService;
    @Autowired
    BusinessServiceImpl businessService;
    @Autowired
    CountMmapper countMmapper;

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
}
