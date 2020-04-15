package com.hy.crmsystem.mrzhang.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crmsystem.mrzhang.entity.CountDocumetMoery;
import com.hy.crmsystem.mrzhang.entity.LayuiData;
import com.hy.crmsystem.mrzhang.service.impl.CountImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Transactional
@RequestMapping("/count")
public class CountController {
    @Autowired
    CountImpl countService;

    /**************************************** 统计商机金额 ***********************************************************************************************/
    /**
    * 查询本周商机预成交金额
    * */
    @ResponseBody
    @RequestMapping(value = "countBusinessMoneryBZ.do",method = RequestMethod.POST)
    public Float countBusinessMoneryBZ(){
        return countService.countBusinessMoneryBZ();
    }

    /**
     * 查询上周商机预成交金额
     * */
    @ResponseBody
    @RequestMapping(value = "countBusinessMonerySZ.do",method = RequestMethod.POST)
    public Float countBusinessMonerySZ(){
        return countService.countBusinessMonerySZ();
    }

    /**
     * 查询本月商机预成交金额
     * */
    @ResponseBody
    @RequestMapping(value = "countBusinessMoneryBY.do",method = RequestMethod.POST)
    public Float countBusinessMoneryBY(){
        return countService.countBusinessMoneryBY();
    }

    /**
     * 查询上月商机预成交金额
     * */
    @ResponseBody
    @RequestMapping(value = "countBusinessMonerySY.do",method = RequestMethod.POST)
    public Float countBusinessMonerySY(){
        return countService.countBusinessMonerySY();
    }

    /**
     * 查询本季度商机预成交金额
     * */
    @ResponseBody
    @RequestMapping(value = "countBusinessMoneryBJ.do",method = RequestMethod.POST)
    public Float countBusinessMoneryBJ(){
        return countService.countBusinessMoneryBJ();
    }

    /**
     * 查询上季度商机预成交金额
     * */
    @ResponseBody
    @RequestMapping(value = "countBusinessMonerySJ.do",method = RequestMethod.POST)
    public Float countBusinessMonerySJ(){
        return countService.countBusinessMonerySJ();
    }

    /**
     * 查询本年度商机预成交金额
     * */
    @ResponseBody
    @RequestMapping(value = "countBusinessMoneryBN.do",method = RequestMethod.POST)
    public Float countBusinessMoneryBN(){
        return countService.countBusinessMoneryBN();
    }

    /**
     * 查询上年度商机预成交金额
     * */
    @ResponseBody
    @RequestMapping(value = "countBusinessMonerySN.do",method = RequestMethod.POST)
    public Float countBusinessMonerySN(){
        return countService.countBusinessMonerySN();
    }
    /**************************************** 统计商机金额 ***********************************************************************************************/


    /**************************************** 统计合同金额 ***********************************************************************************************/
    /**
     * 查询本周合同金额
     * */
    @ResponseBody
    @RequestMapping(value = "countContractMoneryBZ.do",method = RequestMethod.POST)
    public Float countContractMoneryBZ(){
        return countService.countContractMoneryBZ();
    }

    /**
     * 查询上周合同金额
     * */
    @ResponseBody
    @RequestMapping(value = "countContractMonerySZ.do",method = RequestMethod.POST)
    public Float countContractMonerySZ(){
        return countService.countContractMonerySZ();
    }

    /**
     * 查询本月合同金额
     * */
    @ResponseBody
    @RequestMapping(value = "countContractMoneryBY.do",method = RequestMethod.POST)
    public Float countContractMoneryBY(){
        return countService.countContractMoneryBY();
    }

    /**
     * 查询上月合同金额
     * */
    @ResponseBody
    @RequestMapping(value = "countContractMonerySY.do",method = RequestMethod.POST)
    public Float countContractMonerySY(){
        return countService.countContractMonerySY();
    }

    /**
     * 查询本季度合同金额
     * */
    @ResponseBody
    @RequestMapping(value = "countContractMoneryBJ.do",method = RequestMethod.POST)
    public Float countContractMoneryBJ(){
        return countService.countContractMoneryBJ();
    }

    /**
     * 查询上季度合同金额
     * */
    @ResponseBody
    @RequestMapping(value = "countContractMonerySJ.do",method = RequestMethod.POST)
    public Float countContractMonerySJ(){
        return countService.countContractMonerySJ();
    }

    /**
     * 查询本年度合同金额
     * */
    @ResponseBody
    @RequestMapping(value = "countContractMoneryBN.do",method = RequestMethod.POST)
    public Float countContractMoneryBN(){
        return countService.countContractMoneryBN();
    }

    /**
     * 查询上年度合同金额
     * */
    @ResponseBody
    @RequestMapping(value = "countContractMonerySN.do",method = RequestMethod.POST)
    public Float countContractMonerySN(){
        return countService.countContractMonerySN();
    }
    /**************************************** 统计合同金额 ***********************************************************************************************/

    /**************************************** 统计跟单金额 ***********************************************************/

    /**
     * 统计跟单本周的预成交金额
     * */
    @ResponseBody
    @RequestMapping(value = "countDocumentaryMoneyBZ.do",method = RequestMethod.POST)
    public Float countDocumentaryMoneyBZ(){
        return countService.countDocumentaryMoneyBZ();
    }

    /**
     * 统计跟单上周的预成交金额
     * */
    @ResponseBody
    @RequestMapping(value = "countDocumentaryMoneySZ.do",method = RequestMethod.POST)
    public Float countDocumentaryMoneySZ(){
        return countService.countDocumentaryMoneySZ();
    }

    /**
     * 统计跟单本月的预成交金额
     * */
    @ResponseBody
    @RequestMapping(value = "countDocumentaryMoneyBY.do",method = RequestMethod.POST)
    public Float countDocumentaryMoneyBY(){
        return countService.countDocumentaryMoneyBY();
    }

    /**
     * 统计跟单上月的预成交金额
     * */
    @ResponseBody
    @RequestMapping(value = "countDocumentaryMoneySY.do",method = RequestMethod.POST)
    public Float countDocumentaryMoneySY(){
        return countService.countDocumentaryMoneySY();
    }

    /**
     * 统计跟单本季度的预成交金额
     * */
    @ResponseBody
    @RequestMapping(value = "countDocumentaryMoneyBJ.do",method = RequestMethod.POST)
    public Float countDocumentaryMoneyBJ(){
        return countService.countDocumentaryMoneyBJ();
    }

    /**
     * 统计跟单上季度的预成交金额
     * */
    @ResponseBody
    @RequestMapping(value = "countDocumentaryMoneySJ.do",method = RequestMethod.POST)
    public Float countDocumentaryMoneySJ(){
        return countService.countDocumentaryMoneySJ();
    }

    /**
     * 统计跟单本年度的预成交金额
     * */
    @ResponseBody
    @RequestMapping(value = "countDocumentaryMoneyBN.do",method = RequestMethod.POST)
    public Float countDocumentaryMoneyBN(){
        return countService.countDocumentaryMoneyBN();
    }

    /**
     * 统计跟单上年度的预成交金额
     * */
    @ResponseBody
    @RequestMapping(value = "countDocumentaryMoneySN.do",method = RequestMethod.POST)
    public Float countDocumentaryMoneySN(){
        return countService.countDocumentaryMoneySN();
    }


    @ResponseBody
    @RequestMapping(value = "countChengJMoneryBZ.do",method = RequestMethod.POST)
    public Float countChengJMoneryBZ(){
        return countService.countChengJMoneryBZ();
    }

    @ResponseBody
    @RequestMapping(value = "countChengJMonerySZ.do",method = RequestMethod.POST)
    public Float countChengJMonerySZ(){
        return countService.countChengJMonerySZ();
    }

    @ResponseBody
    @RequestMapping(value = "countChengJMoneryBY.do",method = RequestMethod.POST)
    public Float countChengJMoneryBY(){
        return countService.countChengJMoneryBY();
    }

    @ResponseBody
    @RequestMapping(value = "countChengJMonerySY.do",method = RequestMethod.POST)
    public Float countChengJMonerySY(){
        return countService.countChengJMonerySY();
    }

    @ResponseBody
    @RequestMapping(value = "countChengJMoneryBJ.do",method = RequestMethod.POST)
    public Float countChengJMoneryBJ(){
        return countService.countChengJMoneryBJ();
    }

    @ResponseBody
    @RequestMapping(value = "countChengJMonerySJ.do",method = RequestMethod.POST)
    public Float countChengJMonerySJ(){
        return countService.countChengJMonerySJ();
    }

    @ResponseBody
    @RequestMapping(value = "countChengJMoneryBN.do",method = RequestMethod.POST)
    public Float countChengJMoneryBN(){
        return countService.countChengJMoneryBN();
    }

    @ResponseBody
    @RequestMapping(value = "countChengJMonerySN.do",method = RequestMethod.POST)
    public Float countChengJMonerySN(){
        return countService.countChengJMonerySN();
    }

    @ResponseBody
    @RequestMapping(value = "countCustBZMoney.do",method = RequestMethod.GET)
    public LayuiData countCustBZMoney(Integer page, Integer limit){
        return countService.countCustBZMoney(page,limit);
    }

    @ResponseBody
    @RequestMapping(value = "countCustBYMoney.do",method = RequestMethod.GET)
    public LayuiData countCustBYMoney(Integer page, Integer limit){
        return countService.countCustBYMoney(page,limit);
    }

    @ResponseBody
    @RequestMapping(value = "countCustBJMoney.do",method = RequestMethod.GET)
    public LayuiData countCustBJMoney(Integer page, Integer limit){
        return countService.countCustBJMoney(page,limit);
    }

    @ResponseBody
    @RequestMapping(value = "countCustBNMoney.do",method = RequestMethod.GET)
    public LayuiData countCustBNMoney(Integer page, Integer limit){
        return countService.countCustBNMoney(page,limit);
    }

}
