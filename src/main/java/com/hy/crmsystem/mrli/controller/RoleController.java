package com.hy.crmsystem.mrli.controller;

import com.hy.crmsystem.mrli.constast.SysConstast;
import com.hy.crmsystem.mrli.entity.DataGridView;
import com.hy.crmsystem.mrli.entity.Role;
import com.hy.crmsystem.mrli.service.RoleService;
import com.hy.crmsystem.mrli.utils.ResultObj;
import com.hy.crmsystem.mrli.vo.RoleVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author licheng
 * @date 2020/4/12 16:05
 */
@RestController
@RequestMapping("/role")
public class RoleController {


    @Autowired
    private RoleService roleService;


    /**
     * 加载角色列表返回datagridview
     */
    @RequestMapping("/loadAllRole")
    public DataGridView loadAllRole(RoleVo roleVo) {
        return this.roleService.queryAllRole(roleVo);
    }

    /**
     * 添加角色
     */
    @RequestMapping("/addRole")
    /*@RequiresPermissions("role:add")*/
    public ResultObj addRole(RoleVo roleVo) {
        try {
            this.roleService.addRole(roleVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改角色
     */
//    @RequiresPermissions("role:edit")
//    @RequiresRoles("1321321")/
    @RequestMapping("/updateRole")
    public ResultObj updateRole(RoleVo roleVo) {
        try {
            this.roleService.updateRole(roleVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 删除角色
     */
    @RequestMapping("/deleteRole")
    public ResultObj deleteRole(RoleVo roleVo) {
        try {
            this.roleService.deleteRole(roleVo.getRoleid());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除角色
     */
    @RequestMapping("/deleteBatchRole")
    public ResultObj deleteBatchRole(RoleVo roleVo) {
        try {
            this.roleService.deleteBatchRole(roleVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }

    }



    /**
     * 根据角色ID查询角色拥有的菜单和权限ID
     * @param id 角色ID
     */
    @RequestMapping("/queryMenuIdsByRid")
    public Object queryMenuIdsByRid(Integer id){
        List<Integer> mids=this.roleService.queryMenuIdsByRid(id);
        return new DataGridView(mids);
    }


    /**
     * 保存角色和菜单权限之间的关系
     */
    @RequestMapping("/saveRoleMenu")
    public ResultObj saveRoleMenu(Integer roleid,Integer[] perids){
        try {
            this.roleService.saveRoleMenu(roleid,perids);
            return ResultObj.DISPATCH_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DISPATCH_ERROR;
        }
    }





}
