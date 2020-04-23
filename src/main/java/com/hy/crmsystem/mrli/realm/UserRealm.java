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

import java.util.List;

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
            List<String> roles = this.roleService.queryRoleByUserId(user.getUserid());
            // 查询权限
            List<String> permissions = this.permissionService.queryPermissionByUserId(user.getUserid());
            // 构造Activeuser
            ActivierUser activierUser = new ActivierUser(user, roles, permissions);
            // 创建盐
            ByteSource credentialsSalt = ByteSource.Util.bytes(user.getLoginname());

            // 认证信息里存放账号密码，getName() 是当前Realm的继承方法，通常返回当前类名 ：UserRealm
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(activierUser, user.getPwd(), credentialsSalt, this.getName());
            return info;
        } else {
            throw new UnknownAccountException("此用户不存在");
        }

    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 能进入这里，表示账号已经通过验证了
        ActivierUser activierUser = (ActivierUser) principalCollection.getPrimaryPrincipal();
        // 授权对象   ---注意这里类别导错了 SimpleAuthorizationInfo
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        // 通过service获取角色和权限
        List<String> roles = activierUser.getRoles();
        List<String> permissions = activierUser.getPermissions();
        if (null != roles && roles.size() > 0) {
            // 把通过service获取到的角色放进去
            info.addRoles(roles);
        }
        if (null != permissions && permissions.size() > 0) {
            // 把通过service获取到的权限放进去
            info.addStringPermissions(permissions);
        }
        return info;
    }

    public static void main(String[] args){

        Object obj=new SimpleHash("MD5","123456",ByteSource.Util.bytes("admin"),2);
        System.out.println(obj);


    }
}
