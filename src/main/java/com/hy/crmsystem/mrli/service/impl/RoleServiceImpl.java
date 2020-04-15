package com.hy.crmsystem.mrli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crmsystem.mrli.constast.SysConstast;
import com.hy.crmsystem.mrli.entity.DataGridView;
import com.hy.crmsystem.mrli.entity.Role;
import com.hy.crmsystem.mrli.mapper.RoleMapper;
import com.hy.crmsystem.mrli.service.RoleService;
import com.hy.crmsystem.mrli.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.swing.plaf.synth.SynthScrollBarUI;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author licheng
 * @date 2020/4/12 16:09
 */

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {


    @Autowired
    private RoleMapper roleMapper;


    @Override
    public DataGridView queryAllRole(RoleVo roleVo) {
        Page<Object> page = PageHelper.startPage(roleVo.getPage(), roleVo.getLimit());
        List<Role> data = this.roleMapper.queryAllRole(roleVo);
        return new DataGridView(page.getTotal(), data);
 /*       IPage<Role> page = new Page<>(roleVo.getPage(), roleVo.getLimit());
        QueryWrapper<Role> qw = new QueryWrapper<>();
        qw.eq(roleVo.getAvailable() != null, "available", roleVo.getAvailable());
        qw.like(StringUtils.isNotEmpty(roleVo.getRolename()), "rolename", roleVo.getRolename());
        qw.like(StringUtils.isNotEmpty(roleVo.getRoledesc()), "roledesc", roleVo.getRoledesc());
        this.roleMapper.selectPage(page, qw);
        return new DataGridView(page.getTotal(), page.getRecords());*/
    }

    @Override
    public void addRole(RoleVo roleVo) {
        this.roleMapper.insert(roleVo);
    }

    @Override
    public void updateRole(RoleVo roleVo) {
        this.roleMapper.updateById(roleVo);
    }

    @Override
    public void deleteRole(Integer roleid) {
        // 删除角色表的数据
        this.roleMapper.deleteById(roleid);
        // 根据角色id删除sys_role_menu里面的数据
        this.roleMapper.deleteRoleMenuByRid(roleid);
        // 根据角色id删除sys_role_user里面的数据
        this.roleMapper.deleteRoleUserByRid(roleid);
    }

    @Override
    public void deleteBatchRole(Integer[] ids) {
        for (Integer rid : ids) {
            deleteRole(rid);
        }
    }


    @Override
    public List<String> queryRoleByUserId(Integer userid) {
        List<Role> list = roleMapper.queryRolesByUserId(userid);
        List<String> roles = new ArrayList<String>();
        for (Role role : list) {
            roles.add(role.getRolename());
        }
        return roles;
    }
}
