package com.hy.crmsystem.mrfan.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crmsystem.mrfan.entity.Invitation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crmsystem.mrfan.entity.InvitationBo;
import com.hy.crmsystem.mrzhang.entity.LayuiData;
import com.hy.crmsystem.uploadimage.UploadImage;
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
    public LayuiData queryAllInvitation(Integer page1, Integer limit, InvitationBo invitationBo);
    public UploadImage fileuploadExecl(@RequestParam("file") MultipartFile pictureFile, HttpServletRequest request);
}
