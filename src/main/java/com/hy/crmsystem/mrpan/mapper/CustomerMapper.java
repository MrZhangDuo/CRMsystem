package com.hy.crmsystem.mrpan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crmsystem.mrpan.entity.*;
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
public interface CustomerMapper extends BaseMapper<Customer> {
    //客户主页面的模糊查询
    @SelectProvider(type =customerManage.class,method = "customerselect")
    public List<CustomerBo> customerSelect(CustomerBo customer);

    //根据客户分类查询
    @Select("SELECT c.custName, sj.sjs AS busId,sj.yje AS busBeforeMoney,ht.hts AS contractId, ht.contractMoney AS contractMoney,ht.hke AS incomesMoney ,sh.shs AS serviceId,sh.pjf AS servicesCore FROM  customer c LEFT JOIN \n" +
            "(SELECT b.`custId`,COUNT(b.`custId`)AS sjs,SUM(busBeforeMoney)AS yje FROM  customer c LEFT JOIN  business b   ON b.`custId`=c.custId GROUP BY c.custId)AS sj ON c.custId=sj.custId LEFT JOIN \n" +
            "(SELECT con.`custId`, COUNT(con.custId)AS hts ,con.contractMoney,SUM(mon.incomesMoney)AS hke FROM customer c LEFT JOIN contract con ON c.custId=con.`custId` LEFT JOIN moneyregister mon ON con.`contractId`=mon.`contractId`\n" +
            "GROUP BY c.custId) AS ht ON c.custId=ht.custId  LEFT JOIN\n" +
            "(SELECT a.`custId` ,COUNT(a.custId)AS shs ,AVG(servicesCore)AS pjf FROM customer c LEFT JOIN afterservice a ON c.custId=a.`custId` GROUP BY c.custId)sh ON c.custId=sh.custId where custClassify=#{classify}\n")
    public List<CustomerBo> custClassifySelect(String classify);

    /*查询客户的所有信息*/
    @SelectProvider(type =customerManage.class,method = "selectCustAll")
    public CustomerBo selectCustAll(String custName);

    //根据客户Id查询客户及财务信息
    @SelectProvider(type = customerManage.class,method = "selectCustMoney")
    public CustMoneyBo selectCustMoney(Integer custId);

    //点合同数时根据客户id查询客户下的所有合同
    @SelectProvider(type =customerManage.class,method = "selectContractInfo")
    public List<ContractBo> selectContractInfo(ContractBo contractBo);

    //点售后服务数时查询售后服务的信息
    @SelectProvider(type =customerManage.class,method = "selectServiceInfo")
    public List<AfterServiceNum> selectServiceInfo(AfterServiceNum afterService);


}
