package com.hy.crmsystem.mrli.service.impl;

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
    public List<String> queryPermissionByUserId(Integer userid) {
        // 根据用户ID查询权限
        List<Permission> list = permissionMapper.queryPermissionByUserId(userid);
        List<String> permissions = new ArrayList<>();
        for (Permission permission : list) {
            permissions.add(permission.getPercode());
        }
        return permissions;
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
}
