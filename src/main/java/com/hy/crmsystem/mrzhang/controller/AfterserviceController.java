package com.hy.crmsystem.mrzhang.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crmsystem.mrzhang.entity.Afterservice;
import com.hy.crmsystem.mrzhang.entity.Andition;
import com.hy.crmsystem.mrzhang.entity.LayuiData;
import com.hy.crmsystem.mrzhang.service.impl.AfterserviceServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
@Controller
@Transactional
@RequestMapping("/afterservice")
public class AfterserviceController {

    Logger logger =Logger.getLogger(AfterserviceServiceImpl.class);
    @Autowired
    AfterserviceServiceImpl afterserviceService;

    @ResponseBody
    @RequestMapping("queryAllAfterService.do")
    public LayuiData queryAllAfterService(Model model,Integer page, Integer limit, String ServiceTheme, String ServiceType, String ServiceStartTime, String ServicePeople, String ServicesCore ,
                                          String benzhou,String shangzhou ,String benyue,String shangyue,String benji,String shangji ){
        LayuiData layuiData = new LayuiData();
        IPage<Afterservice> afterserviceIPage = afterserviceService.queryAllAfterService(page,limit,ServiceTheme,
                ServiceType,ServiceStartTime,ServicePeople,ServicesCore,benzhou,shangzhou,benyue,shangyue,benji,shangji);
        layuiData.setData(afterserviceIPage.getRecords());
        layuiData.setCount(Integer.parseInt(String.valueOf(afterserviceIPage.getTotal())));
        return layuiData;
    }

    @ResponseBody
    @RequestMapping("queryAllServiceTheme.do")
    public Set<Afterservice> queryAllServiceTheme(){
        return new HashSet<Afterservice>(this.afterserviceService.queryAllServiceTheme());
    }

    @ResponseBody
    @RequestMapping("queryAllserviceType.do")
    public Set<Afterservice> queryAllserviceType(){
        return new HashSet<Afterservice>(this.afterserviceService.queryAllserviceType());
    }

    @ResponseBody
    @RequestMapping("queryAllservicePeople.do")
    public Set<Afterservice> queryAllservicePeople(){
        return new HashSet<Afterservice>(this.afterserviceService.queryAllservicePeople());
    }

    @ResponseBody
    @RequestMapping("queryAllservicesCore.do")
    public Set<Afterservice> queryAllservicesCore(){
        return new HashSet<Afterservice>(this.afterserviceService.queryAllservicesCore());
    }

    @ResponseBody
    @PostMapping("insertAfterService.do")
    public String insertAfterService(Afterservice  afterservice){
        String returns="0";
        try {
            afterserviceService.save(afterservice);
            } catch (Exception e) {
            returns="1";
        }
        return returns;
    }

    @ResponseBody
    @RequestMapping("queryAnditionCount.do")
    public Andition queryAnditionCount(){
        logger.info("===========================================走过了");
         return  new Andition(afterserviceService.countServiceanditionChuLi(),afterserviceService.countServiceanditionCheChu(),afterserviceService.countServiceanditionJieShu());
    }



}
