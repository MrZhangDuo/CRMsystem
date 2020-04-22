package com.hy.crmsystem.mrfan.controller;

import com.hy.crmsystem.mrfan.entity.Billaskfor;
import com.hy.crmsystem.mrfan.service.impl.BillaskforServiceImpl;
import com.hy.crmsystem.mrfan.service.impl.ContractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
@Controller
@RequestMapping("/billaskfor")
public class BillaskforController {
    @Autowired
    private ContractServiceImpl contractService;
    @Autowired
    private BillaskforServiceImpl billaskforService;

    /*查询所有的合同名称*/
    @RequestMapping("/selectAllContName.do")
    public String selectAllContName(Integer contractId,Model model){
       model.addAttribute("allContName",contractService.getById(contractId));
        return "page/contract/addContractBill";
    }

  /*  添加开票额*/
    @ResponseBody
    @RequestMapping("/addOpenTicket.do")
    public String addOpenTicket(Billaskfor billaskfor){
            billaskforService.save(billaskfor);
            return "redirect:/page/contract/queryAllContract.html" ;
    }



}
