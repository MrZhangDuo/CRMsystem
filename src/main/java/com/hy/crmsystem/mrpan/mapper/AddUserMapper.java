package com.hy.crmsystem.mrpan.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crmsystem.mrli.entity.User;
import com.hy.crmsystem.mrpan.entity.AddUserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AddUserMapper extends BaseMapper<AddUserEntity> {

    /*添加用户的所有信息*/
    @Insert("insert into sys_user(loginname,identity,realname,sex,address,phone,pwd,position,available,userimg)" +
            " values(#{loginname},#{identity},#{realname},#{sex},#{address},#{phone},#{pwd},'员工','1',#{userimg})")
    public void UserZhuce(AddUserEntity addUserEntity);

    /*根据用户的昵称查询信息*/
    @Select("select * from sys_user where userid=#{value}")
    public User selectUserById(Integer userId);



}
