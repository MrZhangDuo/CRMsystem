package com.hy.crmsystem.mrpan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crmsystem.mrpan.entity.Business;
import com.hy.crmsystem.mrpan.service.IMoneyinforService;
import com.hy.crmsystem.mrpan.entity.Moneyinfor;
import com.hy.crmsystem.mrpan.mapper.MoneyinforMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
public class MoneyinforServiceImpl extends ServiceImpl<MoneyinforMapper, Moneyinfor> implements IMoneyinforService {
    @Autowired
    private MoneyinforMapper moneyinforMapper;


}
