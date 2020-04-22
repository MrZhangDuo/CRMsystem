package com.hy.crmsystem.mrpan.controller;

import com.github.pagehelper.PageInfo;
import com.hy.crmsystem.mrli.utils.ShiroGetUserUtil;
import com.hy.crmsystem.mrpan.entity.Business;
import com.hy.crmsystem.mrpan.entity.BusinessBo;
import com.hy.crmsystem.mrpan.entity.Customer;
import com.hy.crmsystem.mrpan.entity.layuiEntity;
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
    public layuiEntity selectAllBusInfo(BusinessBo businessBo,@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "3") Integer limit){
        List<BusinessBo> pages = businessService.selectAllBusInfo(businessBo,page,limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }

    //查询我的商机中商机的信息
    @ResponseBody
    @RequestMapping(value = "/MyBusInfo.do",method = RequestMethod.GET)
    public layuiEntity  MyBusInfo(BusinessBo businessBo,@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "3") Integer limit){
       //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号
        List<BusinessBo> pages = businessService.MyBusInfo(businessBo,custName,page,limit);//
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    //根据商机负责人查询我的商机信息
    @ResponseBody
    @RequestMapping(value = "/MyBusInfoByResponsiblePeople.do",method = RequestMethod.GET)
    public layuiEntity  MyBusInfoByResponsiblePeople(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "3") Integer limit){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号

        List<BusinessBo> pages = businessService.MyBusInfoByResponsiblePeople(custName,page,limit);//
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    //根据商机参与人查询我的商机信息
    @ResponseBody
    @RequestMapping(value = "/MyBusInfoByJoinPeople.do",method = RequestMethod.GET)
    public layuiEntity  MyBusInfoByJoinPeople(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "3") Integer limit){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号

        List<BusinessBo> pages = businessService.MyBusInfoByJoinPeople(custName,page,limit);//
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    //根据商机关注人查询我的商机信息
    @ResponseBody
    @RequestMapping(value = "/MyBusInfoByCarePeople.do",method = RequestMethod.GET)
    public layuiEntity  MyBusInfoByCarePeople(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "3") Integer limit){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号

        List<BusinessBo> pages = businessService.MyBusInfoByCarePeople(custName,page,limit);
        PageInfo<Business> pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        System.out.println(pageInfo.getTotal()+"==================================================");
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }

    //查询我的商机中商机负责人是登陆人的商机条数
    @ResponseBody
    @RequestMapping("/BusResponsiblePeopleNumber.do")
    public Integer BusResponsiblePeopleNumber(){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号

        return businessService.BusResponsiblePeopleNumber(custName);
    }
    //查询我的商机中商机参与人是登陆人的商机条数
    @ResponseBody
    @RequestMapping("/BusJoinPeopleNumber.do")
    public Integer BusJoinPeopleNumber(){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号

        return   businessService.BusJoinPeopleNumber(custName);
    }
    //查询我的商机中商机关注人是登陆人的商机条数
    @ResponseBody
    @RequestMapping("/BusCarePeopleNumber.do")
    public Integer BusCarePeopleNumber(){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号

        return businessService.BusCarePeopleNumber(custName);
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
    @RequestMapping("/addBusiness.do")
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

    /*111111111111111111111111我的商机信息11111111111111111111111111111*/

    /*成交商机*/
    @ResponseBody
    @RequestMapping("/successBus.do")
    public layuiEntity successBus(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "9") Integer limit){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号

        List<BusinessBo> pages = businessService.successBus(custName,page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    /*丢单商机*/
    @ResponseBody
    @RequestMapping("/myThrow.do")
    public layuiEntity myThrow(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "9") Integer limit){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号

        List<BusinessBo> pages = businessService.myThrow(custName,page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    /*搁置商机*/
    @ResponseBody
    @RequestMapping("/myShelve.do")
    public layuiEntity myShelve(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "9") Integer limit){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号

        List<BusinessBo> pages = businessService.myShelve(custName,page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    /*进行中的商机*/
    @ResponseBody
    @RequestMapping("/myBusProceed.do")
    public layuiEntity myBusProceed(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "9") Integer limit){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号

        List<BusinessBo> pages = businessService.myBusProceed(custName,page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    /*7天未跟单*/
    @ResponseBody
    @RequestMapping("/myBusSeven.do")
    public layuiEntity myBusSeven(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "9") Integer limit){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号

        List<BusinessBo> pages = businessService.myBusSeven(custName,page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    /*30天未跟单*/
    @ResponseBody
    @RequestMapping("/myBusthirty.do")
    public layuiEntity myBusthirty(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "9") Integer limit){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号

        List<BusinessBo> pages = businessService.myBusthirty(custName,page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    /*90天未跟单*/
    @ResponseBody
    @RequestMapping("/myBusNenity.do")
    public layuiEntity myBusNenity(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "9") Integer limit){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号

        List<BusinessBo> pages = businessService.myBusNenity(custName,page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    /*本周新增*/
    @ResponseBody
    @RequestMapping("/myBusWeek.do")
    public layuiEntity myBusWeek(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "9") Integer limit){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号

        List<BusinessBo> pages = businessService.myBusWeek(custName,page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    /*上周新增*/
    @ResponseBody
    @RequestMapping("/myBusLassWeek.do")
    public layuiEntity myBusLassWeek(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "9") Integer limit){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号

        List<BusinessBo> pages = businessService.myBusLassWeek(custName,page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    /*本月新增*/
    @ResponseBody
    @RequestMapping("/myBusMonth.do")
    public layuiEntity myBusMonth(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "9") Integer limit){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号

        List<BusinessBo> pages = businessService.myBusMonth(custName,page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    /*上月新增*/
    @ResponseBody
    @RequestMapping("/myBusLassMonth.do")
    public layuiEntity myBusLassMonth(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "9") Integer limit){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号

        List<BusinessBo> pages = businessService.myBusLassMonth(custName,page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    /*本季度新增*/
    @ResponseBody
    @RequestMapping("/myBusQuarter.do")
    public layuiEntity myBusQuarter(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "9") Integer limit){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号

        List<BusinessBo> pages = businessService.myBusQuarter(custName,page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }
    /*上季度新增*/
    @ResponseBody
    @RequestMapping("/myBusLassQuarter.do")
    public layuiEntity myBusLassQuarter(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "9") Integer limit){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号

        List<BusinessBo> pages = businessService.myBusLassQuarter(custName,page, limit);
        PageInfo pageInfo = new PageInfo(pages);
        layuiEntity layui = new layuiEntity();
        layui.setCount(pageInfo.getTotal());/*Count数据总条数*/
        layui.setData(pageInfo.getList());/*数据信息*/
        return layui;
    }

    /*成交商机的数量*/
    @ResponseBody
    @RequestMapping("/successBusNumber.do")
    public Integer successBusNumber(){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号
        return businessService.successBusNumber(custName);
    }
    /*丢单商机的数量*/
    @ResponseBody
    @RequestMapping("/myThrowNumber.do")
    public  Integer myThrowNumber(){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号
        return businessService.myThrowNumber(custName);
    };
    /*搁置商机的数量*/
    @ResponseBody
    @RequestMapping("/myShelveNumber.do")
    public  Integer myShelveNumber(){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号
        return businessService.myShelveNumber(custName);
    };
    /*进行中的商机数量*/
    @ResponseBody
    @RequestMapping("/proceedNumber.do")
    public Integer proceedNumber(){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号
        return businessService.proceedNumber(custName);
    };
    /*7天未跟单数量*/
    @ResponseBody
    @RequestMapping("/sevenNumber.do")
    public Integer sevenNumber(){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号
        return businessService.sevenNumber(custName);
    };
    /*30天未跟单数量*/
    @ResponseBody
    @RequestMapping("/thrityNumber.do")
    public Integer thrityNumber(){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号
        return businessService.thrityNumber(custName);
    };
    /*90天未跟单数量*/
    @ResponseBody
    @RequestMapping("/nenityNumber.do")
    public Integer nenityNumber(){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号
        return businessService.nenityNumber(custName);
    };
    /*本周新增数量*/
    @ResponseBody
    @RequestMapping("/weekNumber.do")
    public Integer weekNumber(){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号
        return businessService.weekNumber(custName);
    };
    /*上周新增数量*/
    @ResponseBody
    @RequestMapping("/weekLastNumber.do")
    public Integer weekLastNumber(){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号
        return businessService.weekLastNumber(custName);
    };
    /*本月新增数量*/
    @ResponseBody
    @RequestMapping("/monthNumber.do")
    public Integer monthNumber(){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号
        return businessService.monthNumber(custName);
    };
    /*上月新增数量*/
    @ResponseBody
    @RequestMapping("/monthLastNumber.do")
    public Integer monthLastNumber(){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号
        return businessService.monthLastNumber(custName);
    };
    /*本季度新增数量*/
    @ResponseBody
    @RequestMapping("/quarterNumber.do")
    public Integer quarterNumber(){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号
        return businessService.quarterNumber(custName);
    };
    /*上季度新增数量*/
    @ResponseBody
    @RequestMapping("/quarterLassNumber.do")
    public Integer quarterLassNumber(){
        //三行获取当前登陆人
        String custName=ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号
        return businessService.quarterLassNumber(custName);
    };



};

