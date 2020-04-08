package com.hy.crmsystem.mrzhang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crmsystem.mrfan.entity.Contract;
import com.hy.crmsystem.mrpan.entity.Customer;
import com.hy.crmsystem.mrzhang.entity.Afterservice;
import com.hy.crmsystem.mrzhang.mapper.AfterserviceMapper;
import com.hy.crmsystem.mrzhang.service.IAfterserviceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
@Service
public class AfterserviceServiceImpl extends ServiceImpl<AfterserviceMapper, Afterservice> implements IAfterserviceService {
    @Autowired
    AfterserviceMapper afterserviceMapper;

    @Override
    public IPage<Afterservice> queryAllAfterService(Integer page, Integer limit, String ServiceTheme, String ServiceType,
                 String ServiceStartTime,String ServicePeople, String ServicesCore,
                                                    String chul,String chec,String jies,String benzhou,String shangzhou,
                                                    String benyue,String shangyue,String benji,String shangji) {
        Logger logger =Logger.getLogger(AfterserviceServiceImpl.class);
        QueryWrapper<Afterservice> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(ServiceTheme)){
            queryWrapper.like("ServiceTheme",ServiceTheme);
        }
        if (StringUtils.isNotEmpty(ServiceType)){
            queryWrapper.like("ServiceType",ServiceType);
        }
        if (StringUtils.isNotEmpty(ServicePeople)){
            queryWrapper.like("ServicePeople",ServicePeople);
        }
        if (StringUtils.isNotEmpty(ServicesCore)){
            queryWrapper.eq("ServicesCore",Integer.parseInt(ServicesCore));
        }
        if (StringUtils.isNotEmpty(ServiceStartTime)){
            queryWrapper.ge("ServiceStartTime",ServiceStartTime);
        }
        if(StringUtils.isNotEmpty(chul)&&chul.equals("chul")){
            queryWrapper.eq("serviceCondition","处理中");
        }else if (StringUtils.isNotEmpty(chec)&&chec.equals("chec")){
            queryWrapper.eq("serviceCondition","撤除");
        }else if (StringUtils.isNotEmpty(jies)&&jies.equals("jies")){
            queryWrapper.eq("serviceCondition","结束");
        }else if (StringUtils.isNotEmpty(benzhou)&&benzhou.equals("benzhou")){
            queryWrapper.apply("ServiceStartTime=YEARWEEK(NOW())","");
        }else if (StringUtils.isNotEmpty(shangzhou)&&shangzhou.equals("shangzhou")){
            queryWrapper.apply("ServiceStartTime=YEARWEEK(NOW())-1","");
        }else if (StringUtils.isNotEmpty(benyue)&&benyue.equals("benyue")){
            queryWrapper.apply("DATE_FORMAT(ServiceStartTime,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')","");
        }else if (StringUtils.isNotEmpty(shangyue)&&shangyue.equals("shangyue")){
            queryWrapper.apply("DATE_FORMAT(ServiceStartTime,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')","");
        }else if (StringUtils.isNotEmpty(benji)&&benji.equals("benji")){
            queryWrapper.apply("QUARTER(ServiceStartTime)=QUARTER(NOW())","");
        }else if (StringUtils.isNotEmpty(shangji)&&shangji.equals("shangji")){
            queryWrapper.apply("QUARTER(ServiceStartTime)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))","");
        }
        Page<Afterservice> afterservicePage = new Page<>(page,limit);
        return this.afterserviceMapper.selectPage(afterservicePage,queryWrapper);
    }

    @Override
    public List<Afterservice> queryAllServiceTheme() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("DISTINCT serviceTheme");
        return this.afterserviceMapper.selectList(queryWrapper);
    }

    public List<Afterservice> queryAllserviceType() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("DISTINCT serviceType");
        return this.afterserviceMapper.selectList(queryWrapper);
    }

    public List<Afterservice> queryAllservicePeople() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("DISTINCT servicePeople");
        return this.afterserviceMapper.selectList(queryWrapper);
    }

    public List<Afterservice> queryAllservicesCore() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("DISTINCT servicesCore");
        return this.afterserviceMapper.selectList(queryWrapper);
    }

    @Override
    public Integer countServiceanditionChuLi() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("serviceCondition");
        queryWrapper.eq("serviceCondition","处理中");
        return afterserviceMapper.selectCount(queryWrapper);
    }

    public Integer countServiceanditionCheChu() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("serviceCondition");
        queryWrapper.eq("serviceCondition","撤除");
        return afterserviceMapper.selectCount(queryWrapper);
    }

    public Integer countServiceanditionJieShu() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("serviceCondition");
        queryWrapper.eq("serviceCondition","结束");
        return afterserviceMapper.selectCount(queryWrapper);
    }



    public Integer countBenZhou() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("ServiceStartTime");
        queryWrapper.apply("ServiceStartTime=YEARWEEK(NOW())","");
        return afterserviceMapper.selectCount(queryWrapper);
    }

    public Integer countShangZhou() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("ServiceStartTime");
        queryWrapper.apply("ServiceStartTime=YEARWEEK(NOW())-1","");
        return afterserviceMapper.selectCount(queryWrapper);
    }

    public Integer countBenYue() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("ServiceStartTime");
        queryWrapper.apply("DATE_FORMAT(ServiceStartTime,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')","");
        return afterserviceMapper.selectCount(queryWrapper);
    }

    public Integer countShangYue() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("ServiceStartTime");
        queryWrapper.apply("DATE_FORMAT(ServiceStartTime,'%Y-%m')=DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH),'%Y-%m')","");
        return afterserviceMapper.selectCount(queryWrapper);
    }

    public Integer countBenJi() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("ServiceStartTime");
        queryWrapper.apply("QUARTER(ServiceStartTime)=QUARTER(NOW())","");
        return afterserviceMapper.selectCount(queryWrapper);
    }

    public Integer countShangJi() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("ServiceStartTime");
        queryWrapper.apply("QUARTER(ServiceStartTime)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))","");
        return afterserviceMapper.selectCount(queryWrapper);
    }

    @Override
    public List<Contract> queryCustContract(String ServiceCustName) {
        return afterserviceMapper.queryCustContract(ServiceCustName);
    }
}
