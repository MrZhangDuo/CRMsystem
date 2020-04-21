package com.hy.crmsystem.mrfan.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crmsystem.mrfan.entity.Invitation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crmsystem.mrfan.entity.InvitationBo;
import org.apache.ibatis.annotations.*;

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
public interface InvitationMapper extends BaseMapper<Invitation> {

    @SelectProvider(type =com.hy.crmsystem.mrfan.provider.selectProvider.QueryAllInvitation.class,method = "queryAllInvitation")
    public IPage<InvitationBo> queryAllInvitation(@Param("page1")IPage<InvitationBo> page,@Param("invitationBo") InvitationBo invitationBo );
}
