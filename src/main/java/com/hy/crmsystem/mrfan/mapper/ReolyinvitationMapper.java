package com.hy.crmsystem.mrfan.mapper;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.hy.crmsystem.mrfan.entity.InvitationReolyBo;
import com.hy.crmsystem.mrfan.entity.Reolyinvitation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
@Mapper
public interface ReolyinvitationMapper extends BaseMapper<Reolyinvitation> {

    @SelectProvider(type =com.hy.crmsystem.mrfan.provider.selectProvider.QueryReolyinvitation.class ,method = "queryReolyinvitationByInvitationId")
    public List<InvitationReolyBo> queryReolyinvitationByInvitationId(Integer invitationId);

    @SelectProvider(type =com.hy.crmsystem.mrfan.provider.selectProvider.QueryReolyinvitation.class ,method = "queryReolyinvitationFuJi")
    public List<InvitationReolyBo> queryReolyinvitationFuJi(Integer reolyId);


}
