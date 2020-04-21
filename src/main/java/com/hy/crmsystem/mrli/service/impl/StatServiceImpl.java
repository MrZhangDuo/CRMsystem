package com.hy.crmsystem.mrli.service.impl;

import com.hy.crmsystem.mrli.entity.BaseEntity;
import com.hy.crmsystem.mrli.mapper.StatMapper;
import com.hy.crmsystem.mrli.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author licheng
 * @date 2020/4/16 9:35
 */
@Service
public class StatServiceImpl implements StatService {

    @Autowired
    private StatMapper statMapper;

    @Override
    public List<BaseEntity> loadCustomerSourceList() {
        return statMapper.queryCustomerSource();
    }
}
