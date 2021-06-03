package com.example.demo.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface RolesMapper {
    @Select(" select * from admin_role ")
    public List<Map> getAllRoles();

    @Insert(" insert into admin_role(role_name,role_desc) " +
            " values(#{role_name},#{role_desc})")
    public void insert(Map map);

    @Delete(" delete from admin_role where role_id=#{role_id}")
    public void del(Map map);

    @Select(" select * from admin_role where role_id=#{role_id}")
    public  List<Map> queryRoleById(Map map);

    @Update(" update admin_role set role_name=#{role_name}," +
            " role_desc=#{role_desc} where role_id=#{role_id}")
    public void update(Map map);
}
