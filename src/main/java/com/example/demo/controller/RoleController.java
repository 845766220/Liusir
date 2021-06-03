package com.example.demo.controller;

import com.example.demo.mapper.RolesMapper;
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
@RequestMapping(name = "rolecontroller",path = "roles")
public class RoleController {
    @Resource
    RolesMapper rolesMapper;

    @RequestMapping(path = "roles")
    public ModelAndView getAllRoles(){
        ModelAndView mv=new ModelAndView();
        List<Map> roles=rolesMapper.getAllRoles();
        mv.addObject("roles",roles);
        mv.setViewName("roles");
        return mv;
    }
    @ResponseBody
    @RequestMapping(path = "/insert",produces = "application/json;charset=utf-8")
    public String insert(@RequestParam Map map){

        rolesMapper.insert(map);
        Map map1=new HashMap();
        map1.put("success","true");
        JSONObject jsonObject=JSONObject.fromObject(map1);
        return jsonObject.toString();
    }
    @ResponseBody
    @RequestMapping(path = "/del",produces = "application/json;charset=utf-8")
    public String del(@RequestParam Map map){

        rolesMapper.del(map);
        Map map1=new HashMap();
        map1.put("success","true");
        JSONObject jsonObject=JSONObject.fromObject(map1);
        return jsonObject.toString();
    }
    @ResponseBody
    @RequestMapping(path = "/queryRoleById",produces = "application/json;charset=utf-8")
    public String queryRoleById(@RequestParam Map map){

        List<Map> roles=rolesMapper.queryRoleById(map);
        Map map1=new HashMap();
        map1.put("success","true");
        map1.put("role", roles.get(0));
        JSONObject jsonObject=JSONObject.fromObject(map1);
        return jsonObject.toString();
    }
    @ResponseBody
    @RequestMapping(path = "/update",produces = "application/json;charset=utf-8")
    public String update(@RequestParam Map map){

       rolesMapper.update(map);
        Map map1=new HashMap();
        map1.put("success","true");
        JSONObject jsonObject=JSONObject.fromObject(map1);
        return jsonObject.toString();
    }

}
