package com.hy.crmsystem.mrfan.service;

import com.hy.crmsystem.mrfan.entity.Contract;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crmsystem.mrfan.entity.ContractBoi;
import com.hy.crmsystem.mrfan.entity.QueryType;
import com.hy.crmsystem.mrzhang.entity.Andition;
import com.hy.crmsystem.mrzhang.entity.LayuiData;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
public interface IContractService extends IService<Contract> {
    /* 查询所有合同信息 */
    public LayuiData queryAllContract(String page, String limit, String currentName, Contract contract, QueryType queryType);

}
