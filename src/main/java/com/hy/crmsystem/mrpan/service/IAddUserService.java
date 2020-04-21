package com.hy.crmsystem.mrpan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crmsystem.mrpan.entity.AddUserEntity;

public interface IAddUserService extends IService<AddUserEntity> {

    //用户注册
    public void UserZhuce(AddUserEntity addUserEntity);
    /*根据用户的昵称查询信息*/
    public AddUserEntity selectUserById(String userId);
}
