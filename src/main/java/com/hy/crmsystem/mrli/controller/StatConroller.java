package com.hy.crmsystem.mrli.controller;

import com.hy.crmsystem.mrli.entity.BaseEntity;
import com.hy.crmsystem.mrli.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author licheng
 * @date 2020/4/16 9:34
 */
@RestController
@RequestMapping("/stat")
public class StatConroller {

    @Autowired
    private StatService statService;

    /**
     * 加载客户来源数据
     */
    @RequestMapping("/loadCustomerSourceJson")
    public List<BaseEntity> loadCustomerSourceJson(){
        return this.statService.loadCustomerSourceList();
    }
}
