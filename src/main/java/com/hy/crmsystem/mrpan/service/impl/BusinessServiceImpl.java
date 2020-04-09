package com.hy.crmsystem.mrpan.service.impl;

import com.hy.crmsystem.mrli.entity.DataGridView;
import com.hy.crmsystem.mrpan.entity.Business;
import com.hy.crmsystem.mrpan.mapper.BusinessMapper;
import com.hy.crmsystem.mrpan.service.IBusinessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements IBusinessService {

    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public List<Business> queryBusName() {
         return this.businessMapper.queryBusName();
    }
}
