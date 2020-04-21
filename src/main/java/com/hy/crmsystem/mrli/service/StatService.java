package com.hy.crmsystem.mrli.service;

import com.hy.crmsystem.mrli.entity.BaseEntity;

import java.util.List;

/**
 * @author licheng
 * @date 2020/4/16 9:35
 */
public interface StatService {
    /**
     * 加载客户来源数据
     * @return
     */
    List<BaseEntity> loadCustomerSourceList();
}
