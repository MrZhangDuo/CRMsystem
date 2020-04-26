package com.hy.crmsystem.mrli.controller;

import com.hy.crmsystem.mrli.entity.Loginfo;
import com.hy.crmsystem.mrli.entity.User;
import com.hy.crmsystem.mrli.service.LoginfoService;
import com.hy.crmsystem.mrli.utils.ActivierUser;
import com.hy.crmsystem.mrli.utils.ResultObj;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author licheng
 * @date 2020/4/13 17:08
 */
@Controller
@RequestMapping("/login")
public class LoginController {


    @Autowired
    private LoginfoService loginfoService;

    /**
     * 跳转到登录页面
     */
    @RequestMapping("toLogin")
    public String toLogin() {
        return "login";
    }


    /**
     * 用户登录
     */
    @RequestMapping("/login")
    @ResponseBody
    public ResultObj doLogin(String loginname, String pwd, Model model, HttpServletRequest request) {

        try {
            //得到主体
            Subject subject = SecurityUtils.getSubject();
            // 把用户名和密码封装为UsernamePasswordToken对象
            UsernamePasswordToken loginToken = new UsernamePasswordToken(loginname, pwd);
            // 调用主体的登录方法
            subject.login(loginToken);
            Session session = subject.getSession();
            ActivierUser activierUser = (ActivierUser) subject.getPrincipal();
            session.setAttribute("user", activierUser.getUser());

            // 得到shiro的sessionid==token
            String token = subject.getSession().getId().toString();

            // 写入登录日志
            User user = activierUser.getUser();
            Loginfo loginfo = new Loginfo();
            loginfo.setLoginname(user.getRealname() + "-" + user.getLoginname());
            loginfo.setLoginip(request.getRemoteAddr());
            loginfo.setLogintime(new Date());
            loginfoService.save(loginfo);

            return new ResultObj(200, "登陆成功", token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return new ResultObj(-1, "用户名或密码不正确");
        }catch (UnauthorizedException e){
            System.out.println("======================================================================================");
            return new ResultObj(-1,"没有权限");
        }

    }
}
