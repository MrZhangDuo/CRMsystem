package com.hy.crmsystem.mrfan.controller;


import com.hy.crmsystem.mrfan.entity.Reolyinvitation;
import com.hy.crmsystem.mrfan.service.impl.ReolyinvitationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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

    @RequestMapping("insertYiReoly.do")
    public String insertReoly(Reolyinvitation reolyinvitation){
        reolyinvitation.setReolyTime(new Date());
        reolyinvitation.setReolyPeople("pan");
        reolyinvitationService.save(reolyinvitation);
        return "redirect:/invitation/queryInvitationById.do?invitationId="+reolyinvitation.getInvitationId();
    }

    @RequestMapping("insertErReoly.do")
    public String insertReoly(String  reolyId,String erreoly ,String invitationId ,String reolyContent ){
        Reolyinvitation reolyinvitation = new Reolyinvitation();
        reolyinvitation.setQuiltReolyPeople(reolyId);
        reolyinvitation.setReolyPeople("pan");
        reolyinvitation.setReolyContent(reolyContent);
        reolyinvitation.setReolyTime(new Date());
        reolyinvitation.setErreoly(erreoly);
        reolyinvitationService.save(reolyinvitation);
        return "redirect:/invitation/queryInvitationById.do?invitationId="+Integer.parseInt(invitationId);
    }

}
