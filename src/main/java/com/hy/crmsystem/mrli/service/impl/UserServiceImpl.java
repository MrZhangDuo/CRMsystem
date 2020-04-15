package com.hy.crmsystem.mrli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crmsystem.mrli.constast.SysConstast;
import com.hy.crmsystem.mrli.entity.DataGridView;
import com.hy.crmsystem.mrli.entity.Role;
import com.hy.crmsystem.mrli.entity.User;
import com.hy.crmsystem.mrli.mapper.RoleMapper;
import com.hy.crmsystem.mrli.mapper.UserMapper;
import com.hy.crmsystem.mrli.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crmsystem.mrli.service.RoleService;
import com.hy.crmsystem.mrli.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleService roleService;

    @Override
    public DataGridView queryAllUser(UserVo userVo) {
        IPage<User> page = new Page<>(userVo.getPage(), userVo.getLimit());
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq(userVo.getAvailable() != null, "available", userVo.getAvailable());
        qw.like(StringUtils.isNotEmpty(userVo.getRealname()), "realname", userVo.getRealname());
        qw.like(StringUtils.isNotEmpty(userVo.getLoginname()), "loginname", userVo.getLoginname());
        qw.like(StringUtils.isNotEmpty(userVo.getPhone()), "phone", userVo.getLoginname());
        qw.like(null != userVo.getSex(), "sex", userVo.getSex());
        this.userMapper.selectPage(page, qw);
        return new DataGridView(page.getTotal(), page.getRecords());

    }


    @Override
    public void addUser(UserVo userVo) {
        // 设置默认密码
        userVo.setPwd(DigestUtils.md5DigestAsHex(SysConstast.USER_DEFAULT_PWD.getBytes()));
        // 设置用户类型 都是普通用户type=2
        userVo.setType(SysConstast.USER_TYPE_NORMAL);
        this.userMapper.insert(userVo);
    }

    @Override
    public void updateUser(UserVo userVo) {
        this.userMapper.updateUser(userVo);
    }

    /**
     * 删除用户
     */
    @Override
    public void deleteUser(Integer userid) {
        // 删除用户
        this.userMapper.deleteById(userid);
        // 根据用户id删除sys_role_user里面的数据
        this.roleMapper.deleteRoleUserByUid(userid);

    }


    @Override
    public void deleteBatchUser(Integer[] ids) {
        for (Integer uid : ids) {
            this.deleteUser(uid);
        }
    }


    @Override
    public DataGridView queryUserRole(Integer userid) {
        //1,查询所有可用的角色
        Role role = new Role();
        role.setAvailable(SysConstast.AVAILABLE_TRUE);
        List<Role> allRole = this.roleMapper.queryAllRole(role);
        //2,根据用户ID查询已拥有的角色
        List<Role> userRole = this.roleMapper.queryRoleByUid(SysConstast.AVAILABLE_TRUE, userid);

        List<Map<String, Object>> data = new ArrayList<>();
        for (Role r1 : allRole) {
            Boolean LAY_CHECKED = false;
            for (Role r2 : userRole) {
                if (r1.getRoleid().equals(r2.getRoleid())) {
                    LAY_CHECKED = true;
                }
            }
            Map<String, Object> map = new HashMap<String, Object>();

            map.put("roleid", r1.getRoleid());
            map.put("rolename", r1.getRolename());
            map.put("roledesc", r1.getRoledesc());
            map.put("LAY_CHECKED", LAY_CHECKED);
            data.add(map);
        }
        return new DataGridView(data);
    }


    @Override
    public void saveUserRole(UserVo userVo) {
        Integer userid = userVo.getUserid();
        Integer[] roleIds = userVo.getIds();
        //根据用户id删除sys_role_user里面的数据
        this.roleMapper.deleteRoleUserByUid(userid);
        //保存关系
        if (roleIds != null && roleIds.length > 0) {
            for (Integer rid : roleIds) {
                this.userMapper.insertUserRole(userid, rid);
            }
        }
    }


    @Override
    public User queryUserByUserName(String username) {
        return userMapper.queryUserByUserName(username);
    }
}
