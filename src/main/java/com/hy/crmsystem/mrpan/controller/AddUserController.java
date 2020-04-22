package com.hy.crmsystem.mrpan.controller;

import com.hy.crmsystem.mrli.entity.User;
import com.hy.crmsystem.mrli.service.impl.UserServiceImpl;
import com.hy.crmsystem.mrli.utils.ShiroGetUserUtil;
import com.hy.crmsystem.mrpan.entity.AddUserEntity;
import com.hy.crmsystem.mrpan.service.impl.AddUserServiceImpl;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/tianJiaUser")
public class AddUserController {
    @Autowired
    private AddUserServiceImpl addUserService;
    @Autowired
    UserServiceImpl userService;

    //用户注册(在用户注册时就将密码进行加密以确保密码的安全)
    @RequestMapping(value = "/UserZhuce.do",method = RequestMethod.POST)
    public String UserZhuce(AddUserEntity addUserEntity){
        String a="1";
        try {
            String algorithmName="MD5";//加密的方式
            Object source=addUserEntity.getPwd();//要加密的密码
            Object salt= ByteSource.Util.bytes(addUserEntity.getLoginname());//加的盐（盐一般是用户的账号）
            int hashIterations=100; //要加密的次数
            Object createMiWen=new SimpleHash(algorithmName,source,salt,hashIterations);//排放顺序不能错
            addUserEntity.setPwd(String.valueOf(createMiWen));
            addUserService.UserZhuce(addUserEntity);
        } catch (Exception e) {
            a="0";
        }
       return a;
    }

    /*根据用户的id查询信息*/
    @RequestMapping("/selectUserById.do")
    public String selectUserById(Model model){
            //三行获取当前登陆人
            Integer userId= ShiroGetUserUtil.UserObject().getUser().getUserid();//获取登录人的id
            model.addAttribute("user",addUserService.selectUserById(userId));
            return "page/user-setting";
    }


    /*修改客户基本信息user-setting.html*/
    @RequestMapping("/updateUser.do")
    public String updateUser(User user){
        userService.updateById(user);
        return "redirect:/index.html";
    }




}
