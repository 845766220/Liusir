package com.example.demo.controller;

import com.example.demo.mapper.SysMapper;

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
@RequestMapping(name="systemController",path ="/sys")
public class SystemController {

    @Resource
    SysMapper sysMapper;

    //查询
    @RequestMapping(path ="/user")
    public ModelAndView sysuser(){
        ModelAndView mv=new ModelAndView();
        List<Map> users=sysMapper.getAllUsers();
        mv.addObject("users",users);
        mv.setViewName("users");
        return mv;
    }
    //删除
    @RequestMapping(path ="/deluser")
    public ModelAndView deluser(@RequestParam Map map) {
        ModelAndView mv = new ModelAndView();
        //进行删除操作
        sysMapper.delUser(map);
        //再次查询
        List<Map> users = sysMapper.getAllUsers();
        mv.addObject("users", users);
        mv.setViewName("users");
        return mv;
    }
    @ResponseBody
    @RequestMapping(path="/insertuser", produces = "application/json;charset=utf-8")
    public String insertUser(@RequestParam Map map){
        sysMapper.insertUser(map);
        //给ajax  返回json  map
        Map map1=new HashMap();
        map1.put("success","true");
        //使用Jsonlib吧map  转为json    gson
        JSONObject jsonObject= JSONObject.fromObject(map1);
        return jsonObject.toString();//转成json字符串返回
    }
    @ResponseBody
    @RequestMapping(path="/queryUserById", produces = "application/json;charset=utf-8")
    public String queryUserById(@RequestParam Map map){
        List<Map> users=sysMapper.queryUserById(map);
        //给ajax  返回json  map
        Map map1=new HashMap();
        map1.put("user",users.get(0));
        map1.put("success","true");
        //使用Jsonlib吧map  转为json    gson
        JSONObject jsonObject= JSONObject.fromObject(map1);
        return jsonObject.toString();//转成json字符串返回
    }
    @ResponseBody
    @RequestMapping(path="/updateUser", produces = "application/json;charset=utf-8")
    public String updateUser(@RequestParam Map map){
        sysMapper.updateUser(map);
        //给ajax  返回json  map
        Map map1=new HashMap();

        map1.put("success","true");
        //使用Jsonlib吧map  转为json    gson
        JSONObject jsonObject= JSONObject.fromObject(map1);
        return jsonObject.toString();//转成json字符串返回
    }
}
