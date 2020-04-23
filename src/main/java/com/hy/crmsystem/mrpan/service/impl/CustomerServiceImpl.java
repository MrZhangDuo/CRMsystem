package com.hy.crmsystem.mrpan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crmsystem.mrpan.entity.*;
import com.hy.crmsystem.mrpan.mapper.CustomerMapper;
import com.hy.crmsystem.mrpan.service.ICustomerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
@Transactional
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    /*客户管理页面联合查询*/
    public List<CustomerBo> customerSelect(@Param("customer") CustomerBo customer,Integer currentPage, Integer pageSize) {
        Page page = PageHelper.startPage(currentPage, pageSize, true);
        return customerMapper.customerSelect(customer);
    }

    /*根据客户分类查询*/
    public List<CustomerBo> custClassifySelect(@Param("classify")String classify,Integer currentPage, Integer pageSize){
        Page page = PageHelper.startPage(currentPage, pageSize, true);
        return customerMapper.custClassifySelect(classify);
    }


    //根据客户Id查询客户及财务信息
    public CustMoneyBo selectCustMoney(Integer custId){
        return customerMapper.selectCustMoney(custId);
    }

    //点合同数时根据客户id查询客户下的所有合同
    public List<ContractBo> selectContractInfo(@Param("contractBo")ContractBo contractBo,Integer currentPage, Integer pageSize){
        Page page = PageHelper.startPage(currentPage, pageSize, true);
        return customerMapper.selectContractInfo(contractBo);
    }

    //点售后服务数时查询售后服务的信息
    public List<AfterServiceNum> selectServiceInfo(@Param("afterService") AfterServiceNum afterService,Integer currentPage, Integer pageSize){
        Page page = PageHelper.startPage(currentPage, pageSize, true);
        return customerMapper.selectServiceInfo(afterService);
    }

    }