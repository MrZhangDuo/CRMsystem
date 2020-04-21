package com.hy.crmsystem.mrfan.controller;


import com.hy.crmsystem.mrfan.entity.Contract;
import com.hy.crmsystem.mrfan.entity.ContractCustomerBo;
import com.hy.crmsystem.mrfan.entity.Moneyregister;
import com.hy.crmsystem.mrfan.entity.QueryType;
import com.hy.crmsystem.mrfan.service.impl.ContractServiceImpl;
import com.hy.crmsystem.mrfan.service.impl.MoneyregisterServiceImpl;
import com.hy.crmsystem.mrpan.entity.Customer;
import com.hy.crmsystem.mrpan.service.impl.CustomerServiceImpl;
import com.hy.crmsystem.mrzhang.entity.Andition;
import com.hy.crmsystem.mrzhang.entity.LayuiData;
import com.hy.crmsystem.uploadimage.UploadImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    MoneyregisterServiceImpl moneyregisterService;

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

    /* 点击合同主题 查询当前合同信息 */
    @RequestMapping("queryContractById.do")
    public String queryContractById(String contractId, Model model){
        ContractCustomerBo contractCustomerBo = contractService.queryContractById(contractId);
        model.addAttribute("contractCustomerBo",contractCustomerBo);
        return "page/contract/queryContractById";

    }


    /* 点击合同主题 查询当前合同信息 */
    @RequestMapping("toUpdateContract.do")
    public String toUpdateContract(String contractId, Model model){
        ContractCustomerBo contractCustomerBo = contractService.queryContractById(contractId);
        model.addAttribute("contractCustomerBo",contractCustomerBo);
        return "page/contract/updateContract";

    }

    /* 点击合修改合同信息 */
    @RequestMapping("updateContract.do")
    public String updateContract(Contract contract){
        contractService.updateById(contract);
        return "redirect:queryContractById.do?contractId="+contract.getContractId();

    }



    /* 查询客户信息 */
    @ResponseBody
    @RequestMapping("queryAllcust.do")
    public List<Customer> queryAllcust(Contract contract){
        return customerService.list();
    }

    /* 查询客户信息 */
    @RequestMapping("addContract.do")
    public String addContract(Contract contract){
        contractService.save(contract);
        return "redirect:/page/contract/queryAllContract.html";
    }







    /* 点击汇款 添加当前合同的收入登记 */
    @RequestMapping("toContractMoney.do")
    public String toContractMoney(String contractId,Model model){
        Contract contract = contractService.getById(Integer.parseInt(contractId));
        model.addAttribute("contract",contract);
        return "page/contract/addContractMoney";
    }

    /* 点击汇款 添加当前合同的收入登记 */
    @RequestMapping("addContractMoney.do")
    public String addContractMoney(Moneyregister moneyregister){
        System.out.println(moneyregister);
        moneyregisterService.save(moneyregister);
        return "redirect:/page/contract/queryAllContract.html";
    }


    /* 点击开票 添加当前合同的开票记录 */
    @RequestMapping("addContractBill.do")
    public void addContractBill(String contractId){

    }
}
