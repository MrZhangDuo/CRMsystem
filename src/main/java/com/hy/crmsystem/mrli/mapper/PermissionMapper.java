package com.hy.crmsystem.mrli.mapper;

import com.hy.crmsystem.mrli.entity.Permission;

import java.util.List;

/**
 * @author licheng
 * @date 2020/4/13 16:12
 */
public interface PermissionMapper {

    /**
     * 根据用户id查询权限
     * @param userid
     * @return
     */
    List<Permission> queryPermissionByUserId(Integer userid);
}
