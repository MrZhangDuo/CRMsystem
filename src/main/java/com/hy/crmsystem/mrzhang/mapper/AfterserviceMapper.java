package com.hy.crmsystem.mrzhang.mapper;

import com.hy.crmsystem.mrfan.entity.Contract;
import com.hy.crmsystem.mrpan.entity.Customer;
import com.hy.crmsystem.mrzhang.entity.Afterservice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectKey;
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

    @SelectProvider(type = com.hy.crmsystem.mrzhang.provider.selectProvider.QueryCustContractNum.class,method = "queryCustContractNum")
    public List<Contract> queryCustContract(String ServiceCustName);
}
