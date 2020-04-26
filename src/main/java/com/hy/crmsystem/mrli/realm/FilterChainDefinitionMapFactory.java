package com.hy.crmsystem.mrli.realm;

import com.hy.crmsystem.mrli.entity.Permission;
import com.hy.crmsystem.mrli.mapper.PermissionMapper;
import com.hy.crmsystem.mrli.service.PermissionService;
import com.hy.crmsystem.mrli.service.impl.PermissionServiceImpl;
import com.hy.crmsystem.mrli.utils.ActivierUser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 该类为获取数据库中需要判断那些路径需要权限才能访问的
 */
public class FilterChainDefinitionMapFactory {

    @Autowired
    private PermissionMapper permissionMapper;

    public Map<String, String> getPermissionMap(){
//        LinkedHashMap是一个有序的map集合
        Map<String, String> map = new LinkedHashMap<>();
        List<Permission> permissions = permissionMapper.selectList(null);
        map.put("/login", "anon");//放行的路径
        map.put("/logout", "logout");//退出的路径
        for (Permission permission : permissions) {
            map.put(permission.getPurl() ,"perms["+permission.getPercode()+"]");//需要判断权限的路径
        }
        map.put("/**", "authc");//匿名身份验证
        return map;
    }

}
