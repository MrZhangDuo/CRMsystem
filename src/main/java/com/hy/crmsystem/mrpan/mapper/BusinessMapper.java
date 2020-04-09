package com.hy.crmsystem.mrpan.mapper;

import com.hy.crmsystem.mrpan.entity.Business;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
public interface BusinessMapper extends BaseMapper<Business> {


    /**
     * 查询商机名称
     * @return
     */
    List<Business> queryBusName();

}
