package com.hy.crmsystem.mrfan.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crmsystem.mrfan.entity.ImgBean;
import com.hy.crmsystem.mrfan.entity.Invitation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crmsystem.mrfan.entity.InvitationBo;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
public interface IInvitationService extends IService<Invitation> {
    public IPage<InvitationBo> queryAllInvitation( Integer page1,Integer limit,InvitationBo invitationBo);
    public ImgBean fileuploadExecl(@RequestParam("file") MultipartFile pictureFile, HttpServletRequest request);
}
