package com.hy.crmsystem.mrfan.controller;


import com.hy.crmsystem.mrfan.entity.Invitation;
import com.hy.crmsystem.mrfan.entity.InvitationBo;
import com.hy.crmsystem.mrfan.entity.InvitationReolyBo;
import com.hy.crmsystem.mrfan.service.impl.InvitationServiceImpl;
import com.hy.crmsystem.mrfan.service.impl.ReolyinvitationServiceImpl;
import com.hy.crmsystem.mrli.utils.ShiroGetUserUtil;
import com.hy.crmsystem.mrpan.entity.Business;
import com.hy.crmsystem.mrzhang.entity.LayuiData;
import com.hy.crmsystem.uploadimage.UploadImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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
    @Autowired
    private ReolyinvitationServiceImpl reolyinvitationService;

    @ResponseBody
    @RequestMapping("queryAllInvitation.do")
    public LayuiData queryAllInvitation(@RequestParam(name="page" )String page, @RequestParam(name="limit")String limit, InvitationBo invitationBo){
        return invitationService.queryAllInvitation(Integer.parseInt(page),Integer.parseInt(limit),invitationBo);
    }

    @ResponseBody
    @RequestMapping("/fileuploadExecl.do")
    public UploadImage fileuploadExecl(@RequestParam("file") MultipartFile pictureFile, HttpServletRequest request){
        return invitationService.fileuploadExecl(pictureFile,request);
    }

    @ResponseBody
    @RequestMapping("/queryAllBusiness.do")
    public List<Business> queryAllBusiness(){
        return invitationService.queryAllBusiness();
    }


    @RequestMapping("/addInvitation.do")
    public String addInvitation(Invitation invitation){
            invitation.setInvitationTime(new Date());
            invitation.setInvitationAuthor(ShiroGetUserUtil.UserObject().getUser().getRealname());
            invitationService.save(invitation);
        return "redirect:/page/invitation/queryAllInvitation.html";
    }

    /*  查询回复 */
    @RequestMapping("/queryInvitationById.do")
    public String queryInvitationById(Integer invitationId, Model model){
        if(invitationId>0){
            Invitation invitation = invitationService.getById(invitationId);/* 查询当前主题的帖子 */
            if(invitation.getInvitationClick()>0){
                invitation.setInvitationClick(invitation.getInvitationClick()+1);
            }else{
                invitation.setInvitationClick(1);
            }
            invitationService.updateById(invitation);
            List<InvitationReolyBo> YiJiHuiFu = reolyinvitationService.queryReolyInvitationById1(invitation.getInvitationId());/* 查询当前帖子的一级回复*/
            List<InvitationReolyBo> YiJiXiaHuiFu = reolyinvitationService.queryReolyId(YiJiHuiFu);/* 查询一级回复下面的回复*/
            model.addAttribute("invitation",invitation);
            model.addAttribute("YiJiHuiFu",YiJiHuiFu);/* 查询所有的一级回复*/
            model.addAttribute("YiJiXiaHuiFu",YiJiXiaHuiFu);/* 查询一级回复下的回复 */
            return "page/invitation/queryInvitationById";
        }else{
            return "page/404";
        }
    }
}
