package com.hy.crmsystem.mrli.controller;


import com.hy.crmsystem.mrli.entity.DataGridView;
import com.hy.crmsystem.mrli.entity.User;
import com.hy.crmsystem.mrli.service.IUserService;
import com.hy.crmsystem.mrli.service.PermissionService;
import com.hy.crmsystem.mrli.utils.ActivierUser;
import com.hy.crmsystem.mrli.utils.ResultObj;
import com.hy.crmsystem.mrli.vo.UserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.nio.channels.DatagramChannel;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private PermissionService permissionService;

    /**
     * 查询当前登陆的用户
     */
    @GetMapping("/getCurrentUser")
    public DataGridView getCurrentUser() {
        ActivierUser activierUser = (ActivierUser) SecurityUtils.getSubject().getPrincipal();
        return new DataGridView(activierUser.getUser().getRealname());
    }

    @RequestMapping("/permission")
    public DataGridView getPermission(Integer userid){
        Set<String> permission =  this.permissionService.queryPermissionByUserId(userid);
        return new DataGridView(permission);
    }

    /**
     * 加载用户列表返回DataGridView
     */
    @RequestMapping("/loadAllUser")
    public DataGridView loadAllUser(UserVo userVo) {
        return this.userService.queryAllUser(userVo);
    }


    /**
     * 添加用户
     */
    /*@RequiresPermissions("user:add")*/
    @PostMapping("/addUser")
    public ResultObj addUser(UserVo userVo) {
        try {
            this.userService.save(userVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改用户
     */
    @RequestMapping("/updateUser")
    public ResultObj updateUser(UserVo userVo) {
        try {
            this.userService.updateUser(userVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 删除用户
     */
    @RequestMapping("/deleteUser")
    public ResultObj deleteUser(UserVo userVo) {
        try {
            this.userService.deleteUser(userVo.getUserid());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除用户
     */
    @RequestMapping("/deleteBatchUser")
    public ResultObj deleteBatchUser(UserVo userVo) {
        try {
            this.userService.deleteBatchUser(userVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }


    /**
     * 加载用户管理的分配角色的数据
     */
    @RequestMapping("/initUserRole")
    public DataGridView initUserRole(UserVo userVo) {
        return this.userService.queryUserRole(userVo.getUserid());
    }

    /**
     * 保存用户和角色的关系
     */
    @RequestMapping("saveUserRole")
    public ResultObj saveUserRole(UserVo userVo) {
        try {
            this.userService.saveUserRole(userVo);
            return ResultObj.DISPATCH_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DISPATCH_ERROR;
        }
    }

}
