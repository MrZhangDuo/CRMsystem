package com.hy.crmsystem.mrli.controller;

import com.hy.crmsystem.mrli.entity.DataGridView;
import com.hy.crmsystem.mrli.entity.Notice;
import com.hy.crmsystem.mrli.service.NoticeService;
import com.hy.crmsystem.mrli.utils.ActivierUser;
import com.hy.crmsystem.mrli.utils.ResultObj;
import com.hy.crmsystem.mrli.vo.NoticeVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author licheng
 * @date 2020/4/15 10:35
 */
@RequestMapping("/notice")
@RestController
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
     * 查询全部公告
     */
    @RequestMapping("/loadAllNotice")
    public DataGridView loadAllNotice(NoticeVo noticeVo) {
        return this.noticeService.queryAllNotice(noticeVo);
    }


    /**
     * 添加
     */
    @RequestMapping("/addNotice")
    public ResultObj addNotice(Notice notice) {
        try {
            Subject subject = SecurityUtils.getSubject();
            ActivierUser activierUser = (ActivierUser) subject.getPrincipal();

            notice.setOpername(activierUser.getUser().getRealname());
            notice.setCreatetime(new Date());
            this.noticeService.save(notice);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }


    /**
     * 修改
     */
    @RequestMapping("/updateNotice")
    public ResultObj updateNotice(Notice notice) {
        try {
            this.noticeService.updateById(notice);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }


    /**
     * 删除公告
     */
    @RequestMapping("/deleteNotice")
    public ResultObj deleteNotice(Integer id) {
        try {
            this.noticeService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除
     */
    @RequestMapping("/batchDeleteNotice")
    public ResultObj batchDeleteNotice(Integer[] ids) {
        try {
            if (null != ids && ids.length > 0) {
                List<Integer> idsList = new ArrayList<>();
                for (Integer id : ids) {
                    idsList.add(id);
                }
                this.noticeService.removeByIds(idsList);
                return ResultObj.DELETE_SUCCESS;
            } else {
                return new ResultObj(-1, "传入ID不能为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }


    }
}
