package com.hy.crmsystem.mrli.realm;

import com.hy.crmsystem.mrli.entity.User;
import com.hy.crmsystem.mrli.service.IUserService;
import com.hy.crmsystem.mrli.service.PermissionService;
import com.hy.crmsystem.mrli.service.RoleService;
import com.hy.crmsystem.mrli.utils.ActivierUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author licheng
 * @date 2020/4/13 16:02
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;


    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 拿到用户身份 getPrincipals 得到username
        String username = authenticationToken.getPrincipal().toString();

        //根据用户名查询用户
        User user = this.userService.queryUserByUserName(username);
        if (null != user) {
            // 查询角色
            Set<String> roles = new HashSet<>(this.roleService.queryRoleByUserId(user.getUserid()));
            // 查询权限
           /* List<String> permissions = ;*/
            Set<String> permissions = new HashSet<>(this.permissionService.queryPermissionByUserId(user.getUserid()));


            Iterator<String> per = permissions.iterator();
            while (per.hasNext()){
                System.out.println("权限================================================"+per.next());
            }
            // 构造Activeuser
            ActivierUser activierUser = new ActivierUser(user, roles, permissions);
            // 创建盐
            ByteSource credentialsSalt = ByteSource.Util.bytes(user.getLoginname());

            // 认证信息里存放账号密码，getName() 是当前Realm的继承方法，通常返回当前类名 ：UserRealm
            return new SimpleAuthenticationInfo(activierUser, user.getPwd(), credentialsSalt, this.getName());
        } else {
            throw new UnknownAccountException("此用户不存在");
        }

    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
       /* //授权
        System.err.println("-----------------------------");
        Set<String> roles=null;
        //1、先拿到用户名
        Object object=principalCollection.getPrimaryPrincipal().toString();*/
        System.err.println("----------------"+"授权方法");
        //根据用户名查询用户
        User user = this.userService.queryUserByUserName("admin");
        // 查询角色
        Set<String> roles = new HashSet<>(this.roleService.queryRoleByUserId(user.getUserid()));
        // 查询权限
        /* List<String> permissions = ;*/
        Set<String> permissions = new HashSet<>(this.permissionService.queryPermissionByUserId(user.getUserid()));
        Iterator<String> per = permissions.iterator();
        while (per.hasNext()){
            System.out.println("权限================================================"+per.next());
        }
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roles);
        authorizationInfo.addStringPermissions(permissions);

        // 认证信息里存放账号密码，getName() 是当前Realm的继承方法，通常返回当前类名 ：UserRealm
        return authorizationInfo;
    }

    public static void main(String[] args){
        Object obj=new SimpleHash("MD5","123456",ByteSource.Util.bytes("admin"),2);
        System.out.println(obj);


    }
}
