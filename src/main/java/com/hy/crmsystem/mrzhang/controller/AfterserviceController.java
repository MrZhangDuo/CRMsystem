package com.hy.crmsystem.mrzhang.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.hy.crmsystem.mrfan.entity.Contract;
import com.hy.crmsystem.mrli.entity.User;
import com.hy.crmsystem.mrli.service.impl.UserServiceImpl;
import com.hy.crmsystem.mrpan.entity.Business;
import com.hy.crmsystem.mrpan.entity.Customer;
import com.hy.crmsystem.mrpan.service.impl.BusinessServiceImpl;
import com.hy.crmsystem.mrpan.service.impl.CustomerServiceImpl;
import com.hy.crmsystem.mrzhang.entity.Afterservice;
import com.hy.crmsystem.mrzhang.entity.Andition;
import com.hy.crmsystem.mrzhang.entity.LayuiData;
import com.hy.crmsystem.mrzhang.mapper.AfterserviceMapper;
import com.hy.crmsystem.mrzhang.service.impl.AfterserviceServiceImpl;
import com.hy.crmsystem.uploadimage.UploadImage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

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
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    UserServiceImpl userService;

    @ResponseBody
    @RequestMapping("queryAllAfterService.do")
    public LayuiData queryAllAfterService(Model model,Integer page, Integer limit, String type,String serviceTheme, String serviceType, String serviceStartTime, String servicePeople, String servicesCore ,
                                          String chul,String chec,String jies,String benzhou,String shangzhou ,String benyue,String shangyue,String benji,String shangji ){
        LayuiData layuiData = new LayuiData();
        IPage<Afterservice> afterserviceIPage = afterserviceService.queryAllAfterService(page,limit,type,serviceTheme,
                serviceType,serviceStartTime,servicePeople,servicesCore,chul,chec,jies,benzhou,shangzhou,benyue,shangyue,benji,shangji);

        layuiData.setData(afterserviceIPage.getRecords());
        layuiData.setCount(afterserviceIPage.getTotal());
        return layuiData;
    }

    /* 按主题查询 */
    @ResponseBody
    @RequestMapping("queryAllServiceTheme.do")
    public Set<Afterservice> queryAllServiceTheme(){
        return new HashSet<Afterservice>(this.afterserviceService.queryAllServiceTheme());
    }

    /* 按服务类型查询 */
    @ResponseBody
    @RequestMapping("queryAllserviceType.do")
    public Set<Afterservice> queryAllserviceType(){
        return new HashSet<Afterservice>(this.afterserviceService.queryAllserviceType());
    }

    /* 按服务人员查询 */
    @ResponseBody
    @RequestMapping("queryAllservicePeople.do")
    public Set<Afterservice> queryAllservicePeople(){
        return new HashSet<Afterservice>(this.afterserviceService.queryAllservicePeople());
    }

    /* 按服务评分查询 */
    @ResponseBody
    @RequestMapping("queryAllservicesCore.do")
    public Set<Afterservice> queryAllservicesCore(){
        return new HashSet<Afterservice>(this.afterserviceService.queryAllservicesCore());
    }

    /* 新增售后记录 */
    @ResponseBody
    @PostMapping("insertAfterService.do")
    public String insertAfterService(Afterservice  afterservice){
        String returns="0";
        try {
         /*   afterservice.setServiceCondition("处理中");//添加合同状态*/
            afterserviceService.save(afterservice);
            } catch (Exception e) {
            returns="1";
        }
        return returns;
    }

    /* 查询 服务中 已撤出 已结束 的数量 */
    @ResponseBody
    @RequestMapping("queryAnditionCount.do")
    public Andition queryAnditionCount(){
         return  new Andition(afterserviceService.countServiceanditionChuLi(),
                 afterserviceService.countServiceanditionCheChu(),afterserviceService.countServiceanditionJieShu(),
         afterserviceService.countBenZhou(),afterserviceService.countShangZhou(),afterserviceService.countBenYue(),
                 afterserviceService.countShangYue(),afterserviceService.countBenJi(),afterserviceService.countShangJi());
    }


    /* 查询客户名称 */
    @ResponseBody
    @RequestMapping("queryAllCust.do")
    public List<Customer> queryAllCust(){
        return customerService.list();
    }


    /* 查询某客户下的合同编号 */
    @ResponseBody
    @RequestMapping("queryCustContract.do")
    public List<Contract> queryCustContract(String ServiceCustName){
        return afterserviceService.queryCustContract(ServiceCustName);
    }


    /* 查询某一条数据 */
    @RequestMapping("queryAfterServiceById.do")
    public String queryAfterServiceById(Model model,String serviceId){
        model.addAttribute("afterservice",afterserviceService.queryAfterServiceById(serviceId));
        return  "page/afterservice/queryAfterServiceById";
    }


    @PostMapping("/uploadfile.do")
    @ResponseBody
    public UploadImage uploadfile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request){
        // 图片上传
        // 设置图片名称，不能重复，可以使用uuid
        String picName = UUID.randomUUID().toString();
        // 获取文件名
        String oriName = multipartFile.getOriginalFilename();
        // 获取图片后缀
        String extName = oriName.substring(oriName.lastIndexOf("."));
        String tomcatImage = request.getSession().getServletContext().getRealPath("/");
        System.out.println(tomcatImage);
        // 开始上传
        try {
            multipartFile.transferTo(new File(tomcatImage+"\\images\\" + picName + extName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        UploadImage uploadImage = new UploadImage();
        uploadImage.setCode("0");
        uploadImage.setFilename(picName+extName);
        return  uploadImage;
    }

    @ResponseBody
    @RequestMapping("queryAllUser.do")
    public List<User> queryAllUser(){
        return userService.list();
    }


}
