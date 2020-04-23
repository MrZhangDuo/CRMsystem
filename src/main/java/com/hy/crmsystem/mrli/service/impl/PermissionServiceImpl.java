package com.hy.crmsystem.mrli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crmsystem.mrli.entity.DataGridView;
import com.hy.crmsystem.mrli.entity.Permission;
import com.hy.crmsystem.mrli.entity.User;
import com.hy.crmsystem.mrli.mapper.PermissionMapper;
import com.hy.crmsystem.mrli.service.IUserService;
import com.hy.crmsystem.mrli.service.PermissionService;
import com.hy.crmsystem.mrli.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author licheng
 * @date 2020/4/13 16:06
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RoleService roleService;
    @Autowired
    private IUserService userService;


    @Override
    public Set<String> queryPermissionByUserId(Integer userid) {
        // 根据用户ID查询权限
        Set<String> list = permissionMapper.queryPermissionByUserId(userid);
        /*Set<String> permissions = new HashSet<>();
        for (Permission permission : list) {
            permissions.add(permission.getPercode());
        }*/
        return list;
    }

    @Override
    public boolean needInterceptor(ServletRequest request) {
        return false;
    }

    @Override
    public Set<String> listPermissionURLS(String userName) {
        // 根据用户名查询用户
        User user = this.userService.queryUserByUserName(userName);
        Set<String> result = new HashSet<>();
        // 根据用户id查询角色
        List<String> roles = roleService.queryRoleByUserId(user.getUserid());
        return null;
    }


    @Override
    public DataGridView loadAllPermision(Permission permission) {
        QueryWrapper<Permission> qw = new QueryWrapper<>();
        qw.eq(permission.getAvailable() != null, "available", permission.getAvailable());
        qw.orderByAsc("ordernumber");
        List<Permission> permissions = this.permissionMapper.selectList(qw);
        return new DataGridView(Long.valueOf(permissions.size()),permissions);
    }
}
