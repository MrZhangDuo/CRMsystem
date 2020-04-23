package com.hy.crmsystem.mrli.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crmsystem.mrli.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Set;

/**
 * @author licheng
 * @date 2020/4/13 16:12
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 根据用户id查询权限
     * @param userid
     * @return
     */
    Set<String> queryPermissionByUserId(Integer userid);
}
