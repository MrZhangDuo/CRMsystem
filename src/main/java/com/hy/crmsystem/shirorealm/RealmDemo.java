package com.hy.crmsystem.shirorealm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RealmDemo extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        /* 拿到用户名 */
        Object username = principalCollection.getPrimaryPrincipal();
        /* 通过用户名查询角色和权限 */


        /* 获取当前用户的角色 */
        Set<String> roleSet = new HashSet<>();
        Iterator<String> iterable = roleSet.iterator();
        while (iterable.hasNext()){
            System.out.println("角色======================================="+iterable.next());
        }
        System.out.println("111111111111111111111111111111111111111111111111111111111111111111");



        /* 获取当前用户的权限 */
        Set<String> queryRoleAllAuthority = new HashSet<>();
        Set<String> queryUserAllAuthority;
        /* 遍历用户权限循环加入到所有权限的set 集合 */
        /*Iterator<String> stringIterator = queryUserAllAuthority.iterator();
        while (stringIterator.hasNext()){
            queryRoleAllAuthority.add(stringIterator.next());
        }*/
        /* 返回授权信息*/
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roleSet);
        simpleAuthorizationInfo.addStringPermissions(queryRoleAllAuthority);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("account",token.getUsername());
        /*User user= (User)userService.getOne(queryWrapper);
        if (user==null){
            throw  new UnknownAccountException("用户名不存在");
        }*/
       /* SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getAccount(),user.getPassword(),ByteSource.Util.bytes(user.getAccount()),getName());
        return simpleAuthenticationInfo;*/
       return null;
    }

    public static void main(String [] args0){
        Logger logger= Logger.getLogger(RealmDemo.class);
        logger.error("错误页面");
        /**  加密方式为 MD5
        *
        String hashAlogrithmName = "MD5";
        Object credentials = "123";
        Object salt = ByteSource.Util.bytes("panwenhui");
        Integer hashIterations = 1000;
        Object result = new  SimpleHash(hashAlogrithmName,credentials,salt,hashIterations);
            System.out.println("加密的密码为："+result);*/
    }
}
