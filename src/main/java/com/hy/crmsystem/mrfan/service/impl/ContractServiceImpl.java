package com.hy.crmsystem.mrfan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crmsystem.mrfan.entity.Contract;
import com.hy.crmsystem.mrfan.entity.ContractBoi;
import com.hy.crmsystem.mrfan.entity.QueryType;
import com.hy.crmsystem.mrfan.mapper.ContractMapper;
import com.hy.crmsystem.mrfan.service.IContractService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crmsystem.mrzhang.entity.Andition;
import com.hy.crmsystem.mrzhang.entity.LayuiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
@Service
public class ContractServiceImpl extends ServiceImpl<ContractMapper, Contract> implements IContractService {

    @Autowired
    ContractMapper contractMapper;
    @Override
    public LayuiData queryAllContract(String page, String limit, String currentName, Contract contract, QueryType queryType) {
        IPage iPage = new Page(Integer.parseInt(page),Integer.parseInt(limit));
        IPage<ContractBoi> contractBoList = contractMapper.queryAllContract(iPage,currentName,contract,queryType);
        for (int i = 0; i <contractBoList.getRecords().size() ; i++) {
            System.out.println(contractBoList.getRecords().get(i));
        }
        LayuiData layuiData = new LayuiData();
        layuiData.setData(contractBoList.getRecords());
        layuiData.setCount(contractBoList.getTotal());
        return layuiData;
    }



    public Integer countContractZhiXing(String custName) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("contractzhuangtai");
        queryWrapper.eq("contractzhuangtai","执行");
        if(StringUtils.isNotEmpty(custName)){
            queryWrapper.like("relevancyPeople",custName);
        }
        return contractMapper.selectCount(queryWrapper);
    }

    public Integer countContractGuanBi(String custName) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("contractzhuangtai");
        queryWrapper.eq("contractzhuangtai","关闭");
        if(StringUtils.isNotEmpty(custName)){
            queryWrapper.like("relevancyPeople",custName);
        }
        return contractMapper.selectCount(queryWrapper);
    }

    public Integer countContractCheChu(String custName) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("contractzhuangtai");
        queryWrapper.eq("contractzhuangtai","撤除");
        if(StringUtils.isNotEmpty(custName)){
            queryWrapper.like("relevancyPeople",custName);
        }
        return contractMapper.selectCount(queryWrapper);
    }
    public Integer countContractGeZhi(String custName) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("contractzhuangtai");
        queryWrapper.eq("contractzhuangtai","搁置");
        if(StringUtils.isNotEmpty(custName)){
            queryWrapper.like("relevancyPeople",custName);
        }
        return contractMapper.selectCount(queryWrapper);
    }




    public Integer countContractBenZhou(String custName) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("signedTime");
        queryWrapper.apply("signedTime=YEARWEEK(NOW())","");
        if(StringUtils.isNotEmpty(custName)){
            queryWrapper.like("relevancyPeople",custName);
        }
        return contractMapper.selectCount(queryWrapper);
    }

    public Integer countContractShangZhou(String custName) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("signedTime");
        queryWrapper.apply("signedTime=YEARWEEK(NOW())-1","");
        if(StringUtils.isNotEmpty(custName)){
            queryWrapper.like("relevancyPeople",custName);
        }
        return contractMapper.selectCount(queryWrapper);
    }

    public Integer countContractBenYue(String custName) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("signedTime");
        queryWrapper.apply("DATE_FORMAT(signedTime,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')","");
        if(StringUtils.isNotEmpty(custName)){
            queryWrapper.like("relevancyPeople",custName);
        }
        return contractMapper.selectCount(queryWrapper);
    }

    public Integer countContractShangYue(String custName) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("signedTime");
        queryWrapper.apply("DATE_FORMAT(signedTime,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')","");
        if(StringUtils.isNotEmpty(custName)){
            queryWrapper.like("relevancyPeople",custName);
        }
        return contractMapper.selectCount(queryWrapper);
    }

    public Integer countContractBenJi(String custName) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("signedTime");
        queryWrapper.apply("QUARTER(signedTime)=QUARTER(NOW())","");
        if(StringUtils.isNotEmpty(custName)){
            queryWrapper.like("relevancyPeople",custName);
        }
        return contractMapper.selectCount(queryWrapper);
    }

    public Integer countContractShangJi(String custName) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("signedTime");
        queryWrapper.apply("QUARTER(signedTime)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))","");
        if(StringUtils.isNotEmpty(custName)){
            queryWrapper.like("relevancyPeople",custName);
        }
        return contractMapper.selectCount(queryWrapper);
    }
}
