package com.hy.crmsystem.mrpan.service.impl;

import com.hy.crmsystem.mrli.entity.User;
import com.hy.crmsystem.mrpan.entity.AddUserEntity;
import com.hy.crmsystem.mrpan.mapper.AddUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AddUserServiceImpl {
    @Autowired
    private AddUserMapper addUserMapper;

    //用户注册
    public void UserZhuce(AddUserEntity addUserEntity){
        addUserMapper.UserZhuce(addUserEntity);
    }

    /*根据用户的昵称查询信息*/
    public User selectUserById(Integer userId){
       return  addUserMapper.selectUserById(userId);
    };

}
