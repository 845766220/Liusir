package com.example.demo.controller;


import com.example.demo.mapper.MenusMapper;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(name = "menusController",path = "/menus")
public class MenusController {

    @Resource
    MenusMapper menusMapper;

    //页面跳转到菜单页
    @RequestMapping(path = "/menus")
    public ModelAndView menus(){
        ModelAndView mv=new ModelAndView();

        List<Map> menus=  menusMapper.queryAllMenus();
        mv.setViewName("menus");//menus.html
        mv.addObject("menus",menus);
        return mv;
    }

    @ResponseBody
    @RequestMapping(path = "/queryLevelOne",
      produces = "application/json;charset=utf-8")
    public String queryMenusLevelOne(){
        //查数据库
       List<Map> menus= menusMapper.queryMenusLevelOne();
       Map map=new HashMap();
       map.put("menus",menus);
        JSONObject jsonObject=
                JSONObject.fromObject(map);

        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping(path = "/insertmenu",
            produces = "application/json;charset=utf-8")
    public String insertMenu(@RequestParam Map map){
        //查数据库
        menusMapper.inserMenu(map);
        Map map2=new HashMap();
        map2.put("success","true");
        JSONObject jsonObject=
                JSONObject.fromObject(map2);

        return jsonObject.toString();
    }


    @RequestMapping(path = "/delmenu")
    public ModelAndView delMenu(@RequestParam Map map){
        //查数据库
        menusMapper.delMenu(map);
        Map map2=new HashMap();
        List<Map> menus= menusMapper.queryAllMenus();
        ModelAndView mv=new ModelAndView();
        mv.addObject("menus",menus);
        mv.setViewName("menus");

        return mv;
    }

    @ResponseBody
    @RequestMapping(path = "/queryMenuById",
            produces = "application/json;charset=utf-8")
    public String updateMenu(@RequestParam Map map){
        //查数据库
      List<Map> menu=   menusMapper.queryMenuById(map);
        Map map2=new HashMap();
        map2.put("success","true");
        map2.put("menu",menu);
        JSONObject jsonObject=
                JSONObject.fromObject(map2);

        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping(path = "/saveMenu",
            produces = "application/json;charset=utf-8")
    public String saveMenu(@RequestParam Map map){
        //保存数据库
         menusMapper.saveMenu(map);
        Map map2=new HashMap();
        map2.put("success","true");

        JSONObject jsonObject=
                JSONObject.fromObject(map2);

        return jsonObject.toString();
    }
}
