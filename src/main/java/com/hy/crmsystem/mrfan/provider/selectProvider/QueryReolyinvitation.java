package com.hy.crmsystem.mrfan.provider.selectProvider;

public class QueryReolyinvitation {

    public String queryReolyinvitationByInvitationId(Integer invitationId){
        return new StringBuffer("SELECT r.*,i.* FROM  reolyinvitation r,invitation i WHERE r.`invitationId`=i.`invitationId` AND i.`invitationId`="+invitationId+"").toString();
    }
    public String queryReolyinvitationFuJi(Integer reolyId){
        return new StringBuffer("SELECT rr.*,r.`reolyPeople`as people,r.erreoly as erreoly FROM  reolyinvitation r,reolyinvitation rr WHERE r.`reolyId`=rr.quiltReolyPeople AND rr.erreoly="+reolyId+"").toString();
    }


}
