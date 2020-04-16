package com.hy.crmsystem.mrfan.controller;


import com.hy.crmsystem.mrfan.entity.Contract;
import com.hy.crmsystem.mrfan.entity.ContractBoi;
import com.hy.crmsystem.mrfan.entity.QueryType;
import com.hy.crmsystem.mrfan.service.impl.ContractServiceImpl;
import com.hy.crmsystem.mrzhang.entity.Andition;
import com.hy.crmsystem.mrzhang.entity.LayuiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    ContractServiceImpl contractService;

    @ResponseBody
    @RequestMapping("queryAllContract.do")
    public LayuiData queryAllContract(String page, String limit, String currentName, Contract contract, QueryType queryType){
        return contractService.queryAllContract(page,limit,currentName,contract,queryType);
    }

    @ResponseBody
    @RequestMapping("queryMyContract.do")
    public LayuiData queryMyContract(String page,String limit,Contract contract,QueryType queryType){
        String currentName="张铎";
        return contractService.queryAllContract(page,limit,currentName,contract,queryType);
    }

    /* 查询 合同 执行 搁置。。。。 的数量 */
    @ResponseBody
    @RequestMapping("queryContractCount.do")
    public Andition queryContractCount(String custName){
        return  new Andition(contractService.countContractCheChu(custName),contractService.countContractZhiXing(custName),
                contractService.countContractGuanBi(custName),
                contractService.countContractGeZhi(custName),contractService.countContractBenZhou(custName),contractService.countContractShangZhou(custName),
                contractService.countContractBenYue(custName),contractService.countContractShangYue(custName),contractService.countContractBenJi(custName),contractService.countContractShangJi(custName));
    }

    /* 查询 合同 执行 搁置。。。。 的数量 */
    @ResponseBody
    @RequestMapping("queryMyContractCount.do")
    public Andition queryMyContractCount(){
        String custName="张铎";
        return  new Andition(contractService.countContractCheChu(custName),contractService.countContractZhiXing(custName),
                contractService.countContractGuanBi(custName),
                contractService.countContractGeZhi(custName),contractService.countContractBenZhou(custName),contractService.countContractShangZhou(custName),
                contractService.countContractBenYue(custName),contractService.countContractShangYue(custName),contractService.countContractBenJi(custName),contractService.countContractShangJi(custName));
    }

}
