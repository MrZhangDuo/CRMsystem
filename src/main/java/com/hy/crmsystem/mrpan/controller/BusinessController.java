package com.hy.crmsystem.mrpan.controller;

import com.github.pagehelper.PageInfo;
import com.hy.crmsystem.mrpan.entity.*;
import com.hy.crmsystem.mrpan.mapper.CustomerMapper;
import com.hy.crmsystem.mrpan.service.impl.BusinessServiceImpl;
import com.hy.crmsystem.mrpan.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
@Controller
@RequestMapping("/business")
public class BusinessController {
    @Autowired
    private BusinessServiceImpl businessService;
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private CustomerMapper customerMapper;
    //点商机数时根据客户id查询所有商机的对应信息
    @ResponseBody
    @RequestMapping(value = "/selectBusInfo.do",method = RequestMethod.GET)
    public layuiEntity selectBusInfo(BusinessBo businessBo, @RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "3") Integer limit){
        List<BusinessBo> pages = businessService.selectBusInfo(businessBo, page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }

    //查询商机的所有信息
    @ResponseBody
    @RequestMapping(value = "/selectAllBusInfo.do",method = RequestMethod.GET)
    public layuiEntity selectAllBusInfo(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "3") Integer limit){
        List<BusinessBo> pages = businessService.selectAllBusInfo(page,limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }


    /*根据商机id查询商机及客户信息*/
    @RequestMapping("/custByBusId.do")
    public String custByBusId(Integer busId, Model model){
        /*根据商机名查询客户的客户名称，所属行业，所在城市，详细地址*/
       model.addAttribute("selectCustInfo",businessService.custByBusId(busId));
      return "page/business/businessDetails";

    }

    //修改商机的详细信息
    @RequestMapping("updateBusDetails.do")
    public String updateBusDetails(Customer customer, Business business){
            //修改商机详细信息中的客户信息
            customerService.updateById(customer);
            //修改商机详细信息中的商机信息
            businessService.updateById(business);
            return "redirect:/business/custByBusId.do?busId="+business.getBusId();

    }

    //添加商机
    @ResponseBody
    @RequestMapping("/updateBusDetailsaddBusiness.do")
    public String addBusiness(Customer customer,Business business){
        String a="0";
        try {
            //添加客户信息并返回客户id
            Integer customerId=customerMapper.insert(customer);
            business.setCustId(customerId);
            //添加商机信息
            businessService.save(business);
        } catch (Exception e) {
           a="1";
        }
       return a;
    }

    /*查询进行中的商机*/
    @ResponseBody
    @RequestMapping("/proceedBus.do")
    public layuiEntity proceedBus(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "9") Integer limit){
        List<BusinessBo> pages = businessService.proceedBus(page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    /*查询进行中的商机数量*/
    @ResponseBody
    @RequestMapping("/proceedBusNumber.do")
    public Integer proceedBusNumber(){
        return businessService.proceedBusNumber();
    }


    /*已成交商机*/
    @ResponseBody
    @RequestMapping("/tradedBus.do")
    public layuiEntity tradedBus(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "9") Integer limit){
        List<BusinessBo> pages = businessService.tradedBus(page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    /*已成交商机的商机数量*/
    @ResponseBody
    @RequestMapping("/tradedBusNumber.do")
    public Integer tradedBusNumber(){
        return businessService.tradedBusNumber();
    }
    /*已丢单商机*/
    @ResponseBody
    @RequestMapping("/throwBus.do")
    public layuiEntity throwBus(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "9") Integer limit){
        List<BusinessBo> pages = businessService.throwBus(page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    /*已丢单商机的商机数量*/
    @ResponseBody
    @RequestMapping("/throwBusNumber.do")
    public Integer throwBusNumber(){
        return businessService.throwBusNumber();
    }
    /*已搁置商机*/
    @ResponseBody
    @RequestMapping("/shelveBus.do")
    public layuiEntity shelveBus(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "9") Integer limit){
        List<BusinessBo> pages = businessService.shelveBus(page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    /*已搁置商机的商机数量*/
    @ResponseBody
    @RequestMapping("/shelveBusNumber.do")
    public Integer shelveBusNumber(){
        return businessService.shelveBusNumber();
    }

    /*七天未跟单*/
    @ResponseBody
    @RequestMapping("/docTimeLessSeven.do")
    public layuiEntity docTimeLessSeven(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "9") Integer limit){
        List<BusinessBo> pages = businessService.docTimeLessSeven(page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    /*七天未跟单的商机数量*/
    @ResponseBody
    @RequestMapping("/docTimeLessSevenNumber.do")
    public Integer docTimeLessSevenNumber(){
        return businessService.docTimeLessSevenNumber();
    }

    /*三十天未跟单*/
    @ResponseBody
    @RequestMapping("/docTimeLessThirty.do")
    public layuiEntity docTimeLessThirty(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "9") Integer limit){
        List<BusinessBo> pages = businessService.docTimeLessThirty(page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    /*三十天未跟单的商机数量*/
    @ResponseBody
    @RequestMapping("/docTimeLessThirtyNumber.do")
    public Integer docTimeLessThirtyNumber(){
        return businessService.docTimeLessThirtyNumber();
    }

    /*九十天未跟单*/
    @ResponseBody
    @RequestMapping("/docTimeLessNinety.do")
    public layuiEntity docTimeLessNinety(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "9") Integer limit){
        List<BusinessBo> pages = businessService.docTimeLessNinety(page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    /*九十天未跟单的商机数量*/
    @ResponseBody
    @RequestMapping("/docTimeLessNinetyNumber.do")
    public Integer docTimeLessNinetyNumber(){
        return businessService.docTimeLessNinetyNumber();
    }

    /*本周新增*/
    @ResponseBody
    @RequestMapping("/weekAdd.do")
    public layuiEntity weekAdd(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "9") Integer limit){
        List<BusinessBo> pages = businessService.weekAdd(page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    /*本周新增数量*/
    @ResponseBody
    @RequestMapping("/weekAddNumber.do")
    public Integer weekAddNumber(){
      return  businessService.weekAddNumber();
    }
    /*上周新增*/
    @ResponseBody
    @RequestMapping("/lastWeekAdd.do")
    public layuiEntity lastWeekAdd(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "9") Integer limit){
        List<BusinessBo> pages = businessService.lastWeekAdd(page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    /*上周新增数量*/
    @ResponseBody
    @RequestMapping("/lastWeekAddNumber.do")
    public Integer lastWeekAddNumber(){
        return  businessService.lastWeekAddNumber();
    }


    /*本月新增*/
    @ResponseBody
    @RequestMapping("/monthAdd.do")
    public layuiEntity monthAdd(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "9") Integer limit){
        List<BusinessBo> pages = businessService.monthAdd(page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    /*本月新增数量*/
    @ResponseBody
    @RequestMapping("/monthAddNumber.do")
    public Integer monthAddNumber(){
        return  businessService.monthAddNumber();
    }


    /*上月新增*/
    @ResponseBody
    @RequestMapping("/lastMonthAdd.do")
    public layuiEntity lastMonthAdd(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "9") Integer limit){
        List<BusinessBo> pages = businessService.lastMonthAdd(page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    /*上月新增数量*/
    @ResponseBody
    @RequestMapping("/lastMonthAddNumber.do")
    public Integer lastMonthAddNumber(){
        return  businessService.lastMonthAddNumber();
    }

    /*本季度新增*/
    @ResponseBody
    @RequestMapping("/quarterAdd.do")
    public layuiEntity quarterAdd(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "9") Integer limit){
        List<BusinessBo> pages = businessService.quarterAdd(page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    /*本季度新增数量*/
    @ResponseBody
    @RequestMapping("/quarterAddNumber.do")
    public Integer quarterAddNumber(){
        return  businessService.quarterAddNumber();
    }


    /*上季度新增*/
    @ResponseBody
    @RequestMapping("/lastQuarterAdd.do")
    public layuiEntity lastQuarterAdd(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "9") Integer limit){
        List<BusinessBo> pages = businessService.lastQuarterAdd(page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    /*上季度新增数量*/
    @ResponseBody
    @RequestMapping("/lastQuarterAddNumber.do")
    public Integer lastQuarterAddNumber(){
        return  businessService.lastQuarterAddNumber();
    }



};

