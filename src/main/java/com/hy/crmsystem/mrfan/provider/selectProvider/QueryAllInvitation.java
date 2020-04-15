package com.hy.crmsystem.mrfan.provider.selectProvider;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.hy.crmsystem.mrfan.entity.InvitationBo;
import org.apache.ibatis.annotations.Param;

public class QueryAllInvitation {
    public String queryAllInvitation(@Param("invitationBo") InvitationBo invitationBo){
        StringBuffer sql=new StringBuffer("SELECT inv.*,ib.busName,ir.reolyTime FROM invitation inv LEFT JOIN (SELECT i.`invitationId`,b.`busName` FROM invitation i,business b WHERE i.`busId`=b.`busId`)AS ib ON inv.`invitationId`=ib.invitationId LEFT JOIN (SELECT i.`invitationId`, MAX(r.reolyTime)AS reolyTime FROM invitation i,reolyinvitation r WHERE i.`invitationId`=r.`invitationId`)AS ir ON inv.`invitationId`=ir.invitationId where  1=1 ");
        if(StringUtils.isNotEmpty(invitationBo.getInvitationSubject())){
            sql.append(" and inv.invitationSubject like '%"+invitationBo.getInvitationSubject()+"%'");
        }if(StringUtils.isNotEmpty(invitationBo.getInvitationAuthor())){
            sql.append(" and inv.invitationAuthor like '%"+invitationBo.getInvitationAuthor()+"%'");
        }
        return sql.toString();
    }
}
