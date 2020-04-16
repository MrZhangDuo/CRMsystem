package com.hy.crmsystem.mrli.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crmsystem.mrli.entity.DataGridView;
import com.hy.crmsystem.mrli.entity.Loginfo;
import com.hy.crmsystem.mrli.vo.LoginfoVo;

/**
 * @author licheng
 * @date 2020/4/15 17:06
 */
public interface LoginfoService extends IService<Loginfo> {

    /**
     * 查询全部登录日志
     * @param loginfoVo
     * @return
     */
    DataGridView queryAllLoginfo(LoginfoVo loginfoVo);
}
