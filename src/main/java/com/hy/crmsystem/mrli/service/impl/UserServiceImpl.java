package com.hy.crmsystem.mrli.service.impl;

import com.hy.crmsystem.mrli.entity.User;
import com.hy.crmsystem.mrli.mapper.UserMapper;
import com.hy.crmsystem.mrli.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
