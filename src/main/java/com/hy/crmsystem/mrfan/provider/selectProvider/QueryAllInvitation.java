package com.hy.crmsystem.mrfan.provider.selectProvider;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.hy.crmsystem.mrfan.entity.InvitationBo;
import org.apache.ibatis.annotations.Param;

public class QueryAllInvitation {
    public String queryAllInvitation(@Param("invitationBo") InvitationBo invitationBo){
        StringBuffer sql=new StringBuffer("SELECT i.InvitationSubject,i.Invitationauthor,i.InvitationTime,b.BusName ,i.InvitationClick,i.InvitationReply,r.ReolyTime FROM invitation i,business b,reolyinvitation r WHERE i.`InvitationId`=b.`InvitationId` AND r.`ReolyId`=i.`ReolyId`");
        if(StringUtils.isNotEmpty(invitationBo.getInvitationSubject())){
            sql.append(" and i.InvitationSubject like '%"+invitationBo.getInvitationSubject()+"%'");
        }if(StringUtils.isNotEmpty(invitationBo.getInvitationauthor())){
            sql.append(" and i.Invitationauthor like '%"+invitationBo.getInvitationauthor()+"%'");
        }
        return sql.toString();
    }
}
