package com.hy.crmsystem.mrzhang.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crmsystem.mrzhang.entity.Afterservice;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
public interface IAfterserviceService extends IService<Afterservice> {

    public IPage<Afterservice> queryAllAfterService(Integer page, Integer limit,String ServiceTheme, String ServiceType
            , String ServiceStartTime, String ServicePeople, String ServicesCore,
                                                    String benzhou,String shangzhou ,String benyue,String shangyue,String benji,String shangji);
    public List<Afterservice> queryAllServiceTheme();
    public Integer countServiceanditionChuLi();
}
