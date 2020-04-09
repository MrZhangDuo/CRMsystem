package com.hy.crmsystem.mrfan.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crmsystem.mrfan.entity.ImgBean;
import com.hy.crmsystem.mrfan.entity.Invitation;
import com.hy.crmsystem.mrfan.entity.InvitationBo;
import com.hy.crmsystem.mrfan.mapper.InvitationMapper;
import com.hy.crmsystem.mrfan.service.IInvitationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
@Transactional
@Service
public class InvitationServiceImpl extends ServiceImpl<InvitationMapper, Invitation> implements IInvitationService {
    @Autowired
    private InvitationMapper invitationMapper;

    @Override
    public IPage<InvitationBo> queryAllInvitation(@RequestParam(name="page") Integer page,@RequestParam(name="limit")Integer limit,InvitationBo invitationBo) {
        Page page1=new Page(page,limit);
        return invitationMapper.queryAllInvitation(page1,invitationBo);
    }

    @Override
    public ImgBean fileuploadExecl(MultipartFile pictureFile, HttpServletRequest request) {
        ImgBean imgBean = new ImgBean();
        try {
            // 图片上传
            // 设置图片名称，不能重复，可以使用uuid
            String picName = UUID.randomUUID().toString();
            // 获取文件名
            String oriName = pictureFile.getOriginalFilename();
            // 获取图片后缀
            String extName = oriName.substring(oriName.lastIndexOf("."));

            String a =request.getSession().getServletContext().getRealPath("/");
            // 开始上传
            pictureFile.transferTo(new File( a+ "\\images\\"+picName + extName));
            imgBean.setCode("0");
            imgBean.setFileName(picName + extName);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return  imgBean;
    }
}
