package com.hy.crmsystem.mrfan.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crmsystem.mrfan.entity.Contract;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crmsystem.mrfan.entity.ContractBoi;
import com.hy.crmsystem.mrfan.entity.QueryType;
import com.hy.crmsystem.mrzhang.entity.Andition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
@Mapper
public interface ContractMapper extends BaseMapper<Contract> {

    @SelectProvider(type = com.hy.crmsystem.mrfan.provider.selectProvider.QueryAllContract.class,method = "queryAllContract")
    public IPage<ContractBoi> queryAllContract(@Param("iPage")IPage<ContractBoi> page, @Param("currentName")String currentName,@Param("contract")Contract contract,@Param("queryType") QueryType queryType);
}
