package com.hy.crmsystem.mrli.service;

import com.hy.crmsystem.mrli.entity.DataGridView;
import com.hy.crmsystem.mrli.entity.Permission;

import javax.servlet.ServletRequest;
import java.util.List;
import java.util.Set;

/**
 * @author licheng
 * @date 2020/4/13 16:06
 */
public interface PermissionService {

    /**
     * 根据用户id查询权限
     */
    List<String> queryPermissionByUserId(Integer userid);

    boolean needInterceptor(ServletRequest request);

    Set<String> listPermissionURLS(String userName);

    /**
     * 查询全部权限
     * @param permission
     * @return
     */
    DataGridView loadAllPermision(Permission permission);
}
