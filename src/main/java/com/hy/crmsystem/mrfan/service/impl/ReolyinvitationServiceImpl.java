package com.hy.crmsystem.mrfan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crmsystem.mrfan.entity.InvitationReolyBo;
import com.hy.crmsystem.mrfan.entity.Reolyinvitation;
import com.hy.crmsystem.mrfan.mapper.ReolyinvitationMapper;
import com.hy.crmsystem.mrfan.service.IReolyinvitationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
@Service
public class ReolyinvitationServiceImpl extends ServiceImpl<ReolyinvitationMapper, Reolyinvitation> implements IReolyinvitationService {

    @Autowired
    ReolyinvitationMapper reolyinvitationMapper;

    public List<InvitationReolyBo> queryReolyInvitationById1(Integer invitationId){
        return reolyinvitationMapper.queryReolyinvitationByInvitationId(invitationId);
    }

    public List<InvitationReolyBo> queryReolyId(List<InvitationReolyBo> reolyinvitations){
        if(null != reolyinvitations && !reolyinvitations.isEmpty()){
            for(InvitationReolyBo reolyinvitation:reolyinvitations){
                List<InvitationReolyBo> reolyinvitationList = fu_jiReolyinvitation(reolyinvitation.getReolyId());
                reolyinvitation.setReolyinvitationList(reolyinvitationList);
                queryReolyId(reolyinvitationList);
            }
        }
        return reolyinvitations;
    }

    public  List<InvitationReolyBo> fu_jiReolyinvitation(Integer reolyId){
        return reolyinvitationMapper.queryReolyinvitationFuJi(reolyId);
    }
}
