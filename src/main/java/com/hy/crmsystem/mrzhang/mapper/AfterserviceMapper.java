package com.hy.crmsystem.mrzhang.mapper;

import com.hy.crmsystem.mrfan.entity.Contract;
import com.hy.crmsystem.mrzhang.entity.Afterservice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crmsystem.mrzhang.entity.AfterserviceBo;
import org.apache.ibatis.annotations.Mapper;
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
public interface AfterserviceMapper extends BaseMapper<Afterservice> {

    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.QueryCustContractNum.class,method = "queryCustContractNum")
    public List<Contract> queryCustContract(String custName);

    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectprovider.QueryCustContractNum.class,method = "queryAfterServiceById")
    public AfterserviceBo queryAfterServiceById(String serviceId);
}
