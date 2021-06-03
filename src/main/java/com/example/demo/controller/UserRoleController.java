package com.example.demo.controller;

import com.example.demo.mapper.UserRoleMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(name = "userRoleController",path = "/userrole")
public class UserRoleController {
    @Resource
    UserRoleMapper userRoleMapper;

    @RequestMapping(path = "/all")
    public ModelAndView getAll(){
        ModelAndView mv=new ModelAndView();
        //准备数据
        List<Map> userroles=userRoleMapper.queryAll();
        mv.addObject("userroles",userroles);
        mv.setViewName("userroles");
        return mv;
    }
}
