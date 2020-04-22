package com.hy.crmsystem.mrli.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.hy.crmsystem.mrli.entity.Role;
import com.hy.crmsystem.mrli.vo.RoleVo;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {


    /**
     * 查询角色
     */
    List<Role> queryAllRole(Role role);


    /**
     * 根据角色id删除sys_role_role里面的数据
     *
     * @param roleid
     */
    void deleteRoleMenuByRid(Integer roleid);

    /**
     * 根据角色id删除sys_role_user里面的数据
     *
     * @param roleid
     */
    void deleteRoleUserByRid(Integer roleid);

    /**
     * 查询所有可用的角色
     *
     * @param role
     * @return
     */
    List<Role> queryRole(Role role);

    /**
     * 根据用户ID查询角色
     *
     * @param available
     * @param userid
     * @return
     */
    List<Role> queryRoleByUid(@Param("available") Integer available, @Param("uid") Integer userid);

    /**
     * 根据用户id删除sys_role_user里面的数据
     *
     * @param userid
     */
    void deleteRoleUserByUid(Integer userid);


    /**
     * 根据用户id查询角色
     *
     * @param userid
     * @return
     */
    List<Role> queryRolesByUserId(Integer userid);

    /**
     * 根据角色ID查询角色拥有的菜单和权限ID
     *
     * @param id
     * @return
     */
    List<Integer> queryMenuIdsByRid(Integer id);


    /**
     * 保存角色和菜单权限之间的关系
     *
     * @param roleid
     * @param perid
     */
    void insertRoleMenu(@Param("roleid") Integer roleid, @Param("perid") Integer perid);
}