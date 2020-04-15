package com.hy.crmsystem.mrli.service;

import com.hy.crmsystem.mrli.entity.DataGridView;
import com.hy.crmsystem.mrli.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crmsystem.mrli.vo.UserVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
public interface IUserService extends IService<User> {


    /**
     * 查询所有用户
     *
     * @param userVo
     * @return
     */
    DataGridView queryAllUser(UserVo userVo);

    /**
     * 添加用户
     *
     * @param userVo
     */
    void addUser(UserVo userVo);

    /**
     * 修改用户
     *
     * @param userVo
     */
    void updateUser(UserVo userVo);

    /**
     * 删除用户
     *
     * @param userid
     */
    void deleteUser(Integer userid);

    /**
     * 批量删除用户
     *
     * @param ids
     */
    void deleteBatchUser(Integer[] ids);

    /**
     * 加载用户管理的分配角色的数据
     *
     * @param userId
     * @return
     */
    DataGridView queryUserRole(Integer userId);


    /**
     * 保存用户和角色的关系
     *
     * @param userVo
     */
    void saveUserRole(UserVo userVo);


    /**
     * 根据用户名查询用户对象
     *
     * @param username
     * @return
     */
    User queryUserByUserName(String username);

}
