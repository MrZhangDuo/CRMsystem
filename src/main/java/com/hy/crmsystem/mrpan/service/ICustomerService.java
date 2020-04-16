package com.hy.crmsystem.mrpan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crmsystem.mrpan.entity.*;
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
public interface ICustomerService extends IService<Customer> {
    /*客户管理页面联合查询*/
    public List<CustomerBo> customerSelect(CustomerBo customer, Integer currentPage, Integer pageSize);
    /*根据客户分类查询*/
    public List<CustomerBo> custClassifySelect(@Param("classify") String classify, Integer currentPage, Integer pageSize);
    //根据客户Id查询客户及财务信息
    public CustMoneyBo selectCustMoney(Integer custId);
    //点合同数时根据客户id查询客户下的所有合同
    public List<ContractBo> selectContractInfo(@Param("contractBo") ContractBo contractBo, Integer currentPage, Integer pageSize);
    //点售后服务数时查询售后服务的信息
    public List<AfterServiceNum> selectServiceInfo(@Param("afterService") AfterServiceNum afterService, Integer currentPage, Integer pageSize);
}
