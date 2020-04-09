package com.hy.crmsystem.mrfan.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crmsystem.mrfan.entity.ImgBean;
import com.hy.crmsystem.mrfan.entity.InvitationBo;
import com.hy.crmsystem.mrfan.entity.LayuiDate;
import com.hy.crmsystem.mrfan.service.impl.InvitationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/invitation")
public class InvitationController {
    @Autowired
    InvitationServiceImpl invitationService;

    @ResponseBody
    @RequestMapping("queryAllInvitation.do")
    public LayuiDate queryAllInvitation(@RequestParam(name="page" )String page,@RequestParam(name="limit")String limit,InvitationBo invitationBo){
        LayuiDate layuiDate=new LayuiDate();
        IPage<InvitationBo> invitationBoIPage= invitationService.queryAllInvitation(Integer.parseInt(page),Integer.parseInt(limit),invitationBo);
        layuiDate.setData(invitationBoIPage.getRecords());
        layuiDate.setCount(Integer.parseInt(String.valueOf(invitationBoIPage.getTotal())));
        return layuiDate;
    }
    @RequestMapping("/fileuploadExecl.do")
    @ResponseBody
    public ImgBean fileuploadExecl(@RequestParam("file") MultipartFile pictureFile, HttpServletRequest request){
        return invitationService.fileuploadExecl(pictureFile,request);
    }
}
