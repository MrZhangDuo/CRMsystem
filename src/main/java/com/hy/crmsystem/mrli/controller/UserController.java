package com.hy.crmsystem.mrli.controller;


import com.hy.crmsystem.mrli.entity.DataGridView;
import com.hy.crmsystem.mrli.entity.User;
import com.hy.crmsystem.mrli.service.IUserService;
import com.hy.crmsystem.mrli.utils.ActivierUser;
import com.hy.crmsystem.mrli.utils.ResultObj;
import com.hy.crmsystem.mrli.utils.ShiroGetUserUtil;
import com.hy.crmsystem.mrli.vo.UserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 查询当前登陆的用户
     */
    @GetMapping("/getCurrentUser")
    public DataGridView getCurrentUser() {
        ActivierUser activierUser = (ActivierUser) SecurityUtils.getSubject().getPrincipal();
        return new DataGridView(activierUser.getUser().getRealname());
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

    /*根据用户密码查询用户的信息并修改用户密码*/
    @ResponseBody
    @RequestMapping(value = "/selectNameBypwd.do",method = RequestMethod.GET)
    public Integer selectNameBypwd(String oldpwd,String pwd){
        //三行获取当前登陆人
        String custName= ShiroGetUserUtil.UserObject().getUser().getLoginname();//获取登录人的账号
        String password=ShiroGetUserUtil.UserObject().getUser().getPwd();//获取登录人的密码
        Integer userid=ShiroGetUserUtil.UserObject().getUser().getUserid();//获取登录人的id
        User getUser=userService.getById(userid);//根据登录人的id获取用户信息

        //加密输入的老密码
        String algorithmName="MD5";//加密的方式
        Object salt= ByteSource.Util.bytes(custName);//加的盐（盐一般是用户的账号）
        int hashIterations=100; //要加密的次数

        Object oldsource=oldpwd;//要加密的老密码
        Object oldPassword=new SimpleHash(algorithmName,oldsource,salt,hashIterations);//老密码加密
        String oldPassword1=oldPassword.toString();


        if(getUser==null){
            return 500;// 用户不存在
        }else if(password.equals(oldPassword1)){//判断输入的密码与当前登陆人的密码是否相同
            Object newsource=pwd;//要加密的新密码
            Object newPassword=new SimpleHash(algorithmName,newsource,salt,hashIterations);//新密码加密
            String newPassword1=newPassword.toString();
            ShiroGetUserUtil.UserObject().getUser().setPwd(newPassword1);//将加密后的新密码替换当前登陆人的密码
            userService.saveOrUpdate(ShiroGetUserUtil.UserObject().getUser());//修改用户密码

            return 200;
        }else{
            return 502;// 原密码输入错误

        }
    }

}
