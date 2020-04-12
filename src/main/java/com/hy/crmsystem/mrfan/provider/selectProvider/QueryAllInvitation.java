package com.hy.crmsystem.mrfan.provider.selectProvider;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.hy.crmsystem.mrfan.entity.InvitationBo;
import org.apache.ibatis.annotations.Param;

public class QueryAllInvitation {
    public String queryAllInvitation(@Param("invitationBo") InvitationBo invitationBo){
        StringBuffer sql=new StringBuffer("SELECT i.invitationSubject,i.invitationAuthor,i.invitationTime,b.busName ,i.invitationClick,i.invitationReply,r.reolyTime FROM invitation i,business b,reolyinvitation r WHERE i.`invitationId`=r.`invitationId` AND i.`invitationSubject`=b.`busId`");
        if(StringUtils.isNotEmpty(invitationBo.getInvitationSubject())){
            sql.append(" and i.invitationSubject like '%"+invitationBo.getInvitationSubject()+"%'");
        }if(StringUtils.isNotEmpty(invitationBo.getInvitationAuthor())){
            sql.append(" and i.invitationAuthor like '%"+invitationBo.getInvitationAuthor()+"%'");
        }
        return sql.toString();
    }
}
