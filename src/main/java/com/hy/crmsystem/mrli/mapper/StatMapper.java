package com.hy.crmsystem.mrli.mapper;

import com.hy.crmsystem.mrli.entity.BaseEntity;

import java.util.List;

/**
 * @author licheng
 * @date 2020/4/16 9:36
 */
public interface StatMapper {

    /**
     * 查询客户来源数据
     *
     * @return
     */
    List<BaseEntity> queryCustomerSource();

}
