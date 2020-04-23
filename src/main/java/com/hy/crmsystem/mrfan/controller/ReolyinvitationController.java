package com.hy.crmsystem.mrfan.controller;


import com.hy.crmsystem.mrfan.entity.Invitation;
import com.hy.crmsystem.mrfan.entity.Reolyinvitation;
import com.hy.crmsystem.mrfan.service.impl.InvitationServiceImpl;
import com.hy.crmsystem.mrfan.service.impl.ReolyinvitationServiceImpl;
import com.hy.crmsystem.mrli.utils.ShiroGetUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/reolyinvitation")
public class ReolyinvitationController {
    @Autowired
    ReolyinvitationServiceImpl reolyinvitationService;
    @Autowired
    InvitationServiceImpl invitationService;

    @RequestMapping("insertYiReoly.do")
    public String insertReoly(Reolyinvitation reolyinvitation){
        reolyinvitation.setReolyTime(new Date());
        reolyinvitation.setReolyPeople(ShiroGetUserUtil.UserObject().getUser().getRealname());

        /* 点击回复 把帖子回复加 1 */
        Invitation invitation = invitationService.getById(reolyinvitation.getInvitationId());
        invitation.setInvitationReply(invitation.getInvitationReply()+1);
        invitationService.updateById(invitation);
        reolyinvitationService.save(reolyinvitation);
        return "redirect:/invitation/queryInvitationById.do?invitationId="+reolyinvitation.getInvitationId();
    }

    @RequestMapping("insertErReoly.do")
    public String insertReoly(String  reolyId,String erreoly ,String invitationId ,String reolyContent ){
        Reolyinvitation reolyinvitation = new Reolyinvitation();
        reolyinvitation.setQuiltReolyPeople(reolyId);
        reolyinvitation.setReolyPeople(ShiroGetUserUtil.UserObject().getUser().getRealname());
        reolyinvitation.setReolyContent(reolyContent);
        reolyinvitation.setReolyTime(new Date());
        reolyinvitation.setErreoly(erreoly);

        /* 点击回复 把帖子回复加 1 */
        Invitation invitation = invitationService.getById(invitationId);
        if(null != invitation.getInvitationReply() && invitation.getInvitationReply()>0){
            invitation.setInvitationReply(invitation.getInvitationReply()+1);
        }else{
            invitation.setInvitationReply(1);
        }
        invitationService.updateById(invitation);
        reolyinvitationService.save(reolyinvitation);
        return "redirect:/invitation/queryInvitationById.do?invitationId="+Integer.parseInt(invitationId);
    }

}
