package com.hy.crmsystem.mrpan.controller;

import com.github.pagehelper.PageInfo;
import com.hy.crmsystem.mrpan.entity.*;
import com.hy.crmsystem.mrpan.mapper.MoneyinforMapper;
import com.hy.crmsystem.mrpan.service.impl.CustomerServiceImpl;
import com.hy.crmsystem.mrpan.service.impl.MoneyinforServiceImpl;
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
 * 前端控制器
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private MoneyinforServiceImpl moneyinforService;
    @Autowired
    private MoneyinforMapper moneyinforMapper;

    /*客户管理页面联合查询*/
    @ResponseBody
    @RequestMapping(value = "/customerSelect.do", method = RequestMethod.GET)
    public layuiEntity customerSelect(CustomerBo customer,@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "3") Integer limit) {
        List<CustomerBo> pages = customerService.customerSelect(customer, page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }

    /*根据客户分类查询*/
    @ResponseBody
    @RequestMapping(value = "/custClassifySelect.do",method = RequestMethod.GET)
    public layuiEntity custClassifySelect(String classify,@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "3") Integer limit){
        List<CustomerBo> pages  = customerService.custClassifySelect(classify, page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }

    //添加新增客户的基本信息及财务信息
    @ResponseBody
    @RequestMapping("/addCustomerInfo.do")
    public String customerInfo(Customer customer,Moneyinfor moneyinfor){
        String returns="0";
        try{
            //添加新增客户的财务信息并返回id
            Integer moneyId= moneyinforMapper.insert(moneyinfor);
            customer.setMoneyId(moneyId);
            //添加新增客户的基本信息
            customerService.save(customer);
        }catch (Exception e){
            returns="1";
        }

        return returns;
    }

    //修改客户的基本信息及财务信息
    @RequestMapping("/updateCustomerInfo.do")
    public String updateCustomerInfo(Customer customer,Moneyinfor moneyinfor){
        /*修改财务信息*/
        moneyinforService.updateById(moneyinfor);
        /*修改客户信息*/
        customerService.updateById(customer);
        return "redirect:/customer/selectCustMoney.do?custId="+customer.getCustId();
    }



    //根据客户名称查询客户信息及财务信息
    @RequestMapping("/selectCustMoney.do")
    public String selectCustMoney(Integer custId, Model model){
        //根据客户Id查询客户及财务信息
        model.addAttribute("customerInfo",customerService.selectCustMoney(custId));
        return "page/customer/customerNameInfo";
    }


    //点合同数时根据客户id查询客户下的所有合同
    @ResponseBody
    @RequestMapping(value = "/selectContractInfo.do",method = RequestMethod.GET)
    public layuiEntity selectContractInfo(ContractBo contractBo,@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "3") Integer limit){
        List<ContractBo> pages = customerService.selectContractInfo(contractBo,page,limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }

    //点售后服务数时查询售后服务的信息
    @ResponseBody
    @RequestMapping(value = "/selectServiceInfo.do",method = RequestMethod.GET)
    public layuiEntity selectServiceInfo(AfterServiceNum afterService,@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "3") Integer limit){
        List<AfterServiceNum> pages = customerService.selectServiceInfo(afterService,page,limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }

}
