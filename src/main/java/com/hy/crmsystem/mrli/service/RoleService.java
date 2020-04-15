package com.hy.crmsystem.mrli.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crmsystem.mrli.entity.DataGridView;
import com.hy.crmsystem.mrli.entity.Role;
import com.hy.crmsystem.mrli.vo.RoleVo;

import java.util.List;

/**
 * @author licheng
 * @date 2020/4/12 16:07
 */
public interface RoleService extends IService<Role> {


    /**
     * 查询所有角色
     * @param roleVo
     * @return
     */
    DataGridView queryAllRole(RoleVo roleVo);

    /**
     * 添加角色
     * @param roleVo
     */
    void addRole(RoleVo roleVo);

    /**
     * 修改角色
     * @param roleVo
     */
    void updateRole(RoleVo roleVo);

    /**
     * 根据id删除角色
     * @param roleid
     */
    void deleteRole(Integer roleid);

    /**
     * 批量删除角色
     * @param ids
     */
    void deleteBatchRole(Integer[] ids);

    /**
     * 根据用户id查询角色
     * @param userid
     * @return
     */
    List<String> queryRoleByUserId(Integer userid);
}