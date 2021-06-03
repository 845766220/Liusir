package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserRoleMapper {
    @Select("    select u.*,ifnull(r.role_id,'')  role_id," +
            "              ifnull(r.role_desc,'') role_desc," +
            "              ifnull(r.role_name,'') role_name " +
            "     from admin_user u " +
            "   left join admin_user_role  ur" +
            "   on u.user_id=ur.user_id" +
            "   left join admin_role r" +
            "   on ur.role_id=r.role_id")
    public List<Map> queryAll();
}
