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
    /* 认证 */
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
            Set<String> permissions = new HashSet<>(this.permissionService.queryPermissionByUserId(user.getUserid()));
            // 构造Activeuser
            ActivierUser activierUser = new ActivierUser(user, roles, permissions);
            // 认证信息里存放账号密码，getName() 是当前Realm的继承方法，通常返回当前类名 ：UserRealm
            return new SimpleAuthenticationInfo(activierUser,user.getPwd(),ByteSource.Util.bytes(user.getLoginname()),getName());
        } else {
            throw new UnknownAccountException("此用户不存在");
        }
    }
    /* 授权 */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 能进入这里，表示账号已经通过验证了
        ActivierUser activierUser = (ActivierUser) principalCollection.getPrimaryPrincipal();
        // 通过service获取角色
        Iterator<String> iterable = activierUser.getRoles().iterator();
        while (iterable.hasNext()){
            System.out.println("角色======================================="+iterable.next());
        }
        System.out.println("111111111111111111111111111111111111111111111111111111111111111111");
        // 通过service获取权限
        Iterator<String> stringIterator1 = activierUser.getPermissions().iterator();
        while (stringIterator1.hasNext()){
            System.out.println("权限======================================="+stringIterator1.next());
        }
        System.out.println("222222222222222222222222222222222222222222222222222222222222222222");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        // 把通过service获取到的角色放进去
        simpleAuthorizationInfo.setRoles(activierUser.getRoles());
        // 把通过service获取到的权限放进去
        simpleAuthorizationInfo.addStringPermissions(activierUser.getPermissions());
        return simpleAuthorizationInfo;
    }
}
