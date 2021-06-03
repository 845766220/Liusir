package com.example.demo.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenusMapper {

    @Select(" select * from admin_menu ")
    public List<Map>  queryAllMenus();

    @Select(" select * from admin_menu " +
            " where menu_level='1' ")
    public List<Map>  queryMenusLevelOne();

    @Insert(" insert into admin_menu(menu_name,menu_href,menu_level," +
            "  menu_icon,menu_parent_id)" +
            "  values(#{menu_name},#{menu_href},#{menu_level}," +
            "  #{menu_icon},#{menu_parent_id})")
    public void inserMenu(Map map);

    @Delete(" delete from admin_menu where menu_id=#{menu_id}")
    public void delMenu(Map map);

    @Select(" select * from admin_menu where menu_id=#{menu_id}")
    public List<Map> queryMenuById(Map map);

    @Update("  update admin_menu set menu_name=#{menu_name}," +
            " menu_href=#{menu_href},menu_level=#{menu_level}," +
            " menu_icon=#{menu_icon},menu_parent_id=#{menu_parent_id}" +
            " where menu_id=#{menu_id}")
    public void saveMenu(Map map);
}
