package com.hy.crmsystem.mrli.mapper;

import com.hy.crmsystem.mrli.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crmsystem.mrli.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
public interface UserMapper extends BaseMapper<User> {




    /**
     * 保存用户和角色的关系
     *
     * @param userid
     * @param rid
     */
    void insertUserRole(@Param("uid") Integer userid, @Param("rid") Integer rid);

    /**
     * 更改用户
     *
     * @param userVo
     */
    void updateUser(UserVo userVo);

    /**
     * 根据用户名查询用户对象
     * @param username
     * @return
     */
    User queryUserByUserName(String username);
}
