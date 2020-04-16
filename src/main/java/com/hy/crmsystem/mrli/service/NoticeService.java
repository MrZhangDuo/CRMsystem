package com.hy.crmsystem.mrli.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crmsystem.mrli.entity.DataGridView;
import com.hy.crmsystem.mrli.entity.Notice;
import com.hy.crmsystem.mrli.vo.NoticeVo;

/**
 * @author licheng
 * @date 2020/4/15 10:36
 */
public interface NoticeService extends IService<Notice> {

    /**
     * 查询全部公告
     * @param noticeVo
     * @return
     */
    DataGridView queryAllNotice(NoticeVo noticeVo);
}
