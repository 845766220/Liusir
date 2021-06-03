package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(name="loginController",path="/login")
public class LoginController {

    @Resource
    UserMapper userMapper;

    @RequestMapping(path="/hello")
    public String hello(){
        return "login";//login,就是指login.html模板
    }
    @RequestMapping("/checkpassword")
    public ModelAndView checkpassword(@RequestParam Map map, HttpSession session){
        ModelAndView mv=new ModelAndView();
        //校验密码  如果用户名密码匹配 users就有数据
         List<Map>users= userMapper.check(map);
         if(users.size()>0){
             //登录成功
             //查询当前用户的菜单
             List<Map> menus=userMapper.queryAllMenus(users.get(0));
             //mv.addObject("menus",menus);
             session.setAttribute("menus",menus);
             mv.setViewName("index");
         }else{
             //登录失败
             mv.addObject("error","用户名登录错误");
             mv.setViewName("login");
         }
        return mv;
    }
}
