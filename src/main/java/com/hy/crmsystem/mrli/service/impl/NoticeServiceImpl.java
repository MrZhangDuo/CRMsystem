package com.hy.crmsystem.mrli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crmsystem.mrli.entity.DataGridView;
import com.hy.crmsystem.mrli.entity.Notice;
import com.hy.crmsystem.mrli.mapper.NoticeMapper;
import com.hy.crmsystem.mrli.service.NoticeService;
import com.hy.crmsystem.mrli.vo.NoticeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author licheng
 * @date 2020/4/15 10:37
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public DataGridView queryAllNotice(NoticeVo noticeVo) {
        IPage<Notice> page = new Page<>(noticeVo.getPage(), noticeVo.getLimit());
        QueryWrapper<Notice> qw = new QueryWrapper<>();
        qw.like(StringUtils.isNotEmpty(noticeVo.getTitle()), "title", noticeVo.getTitle());
        qw.like(StringUtils.isNotEmpty(noticeVo.getOpername()), "openname", noticeVo.getOpername());
        qw.ge(noticeVo.getStartTime() != null, "createtime", noticeVo.getStartTime());
        qw.le(noticeVo.getEndTime() != null, "endtime", noticeVo.getEndTime());
        qw.orderByDesc("createtime");
        this.noticeMapper.selectPage(page, qw);
        return new DataGridView(page.getTotal(), page.getRecords());
    }
}
