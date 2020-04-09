package com.hy.crmsystem.mrpan.service;

import com.hy.crmsystem.mrli.entity.DataGridView;
import com.hy.crmsystem.mrpan.entity.Business;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
public interface IBusinessService extends IService<Business> {


    /**
     * 查询商机名称
     * @return
     */
    List<Business> queryBusName();

}
