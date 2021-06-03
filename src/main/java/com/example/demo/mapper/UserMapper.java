package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    @Select("select * from admin_user where user_name=#{user_name} and user_pwd=#{user_pwd}")
    public List<Map> check(Map map);


    @Select(
            " select u.*,m.* " +
                    " from admin_user u,admin_role r,admin_menu m, " +
                    " admin_role_menu rm, admin_user_role ur " +
                    " where  u.user_id=ur.user_id " +
                    " and   ur.role_id=r.role_id " +
                    " and  r.role_id=rm.role_id " +
                    " and rm.menu_id=m.menu_id " +
                    " and  u.user_id=#{user_id} ")
    public List<Map> queryAllMenus(Map map);
}
