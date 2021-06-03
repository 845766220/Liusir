package com.example.demo.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysMapper {

    @Select("select * from admin_user")
    public List<Map> getAllUsers();

    @Delete(" delete from admin_user " +
            " where user_id=#{user_id}")
    public void delUser(Map map);

    @Insert(" insert into admin_user(user_name,user_pwd)" +
            " values(#{user_name},#{user_pwd}) ")
    public void insertUser(Map map);

    @Select("select * from admin_user where user_id=#{user_id}")
    public List<Map> queryUserById(Map map);

    @Update(" update admin_user set user_name=#{user_name}," +
            "user_pwd=#{user_pwd} where user_id=#{user_id}")
    public void updateUser(Map map);
}
