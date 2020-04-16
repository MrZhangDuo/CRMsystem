package com.hy.crmsystem.mrli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crmsystem.mrli.entity.DataGridView;
import com.hy.crmsystem.mrli.entity.Loginfo;
import com.hy.crmsystem.mrli.mapper.LoginfoMapper;
import com.hy.crmsystem.mrli.service.LoginfoService;
import com.hy.crmsystem.mrli.vo.LoginfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author licheng
 * @date 2020/4/15 17:06
 */
@Service
public class LoginfoServiceImpl extends ServiceImpl<LoginfoMapper, Loginfo> implements LoginfoService {

    @Autowired
    private LoginfoMapper loginfoMapper;

    @Override
    public DataGridView queryAllLoginfo(LoginfoVo loginfoVo) {
        IPage<Loginfo> page = new Page<>(loginfoVo.getPage(), loginfoVo.getLimit());
        QueryWrapper<Loginfo> qw = new QueryWrapper<>();
        qw.like(StringUtils.isNotEmpty(loginfoVo.getLoginname()), "loginname", loginfoVo.getLoginname());
        qw.like(StringUtils.isNotEmpty(loginfoVo.getLoginip()), "loginip", loginfoVo.getLoginip());
        qw.ge(loginfoVo.getStartTime() != null, "logintime", loginfoVo.getStartTime());
        qw.le(loginfoVo.getEndTime() != null, "logintime", loginfoVo.getEndTime());
        qw.orderByAsc("logintime");
        this.loginfoMapper.selectPage(page, qw);
        return new DataGridView(page.getTotal(), page.getRecords());
    }


}
