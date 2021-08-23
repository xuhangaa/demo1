package controller;

import domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.RoleService;

import java.util.List;

@RequestMapping("/role")
@Controller
public class RoleController {
//web层注解 dao层用配置文件
    @Autowired //相当于set方法
    private RoleService roleService;

    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:/role/list"; //走list会走方法，那么会刷新数据
    }

    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView =new ModelAndView();
        List<Role> roleList=roleService.list();
        //设置模型
        modelAndView.addObject("roleList",roleList);
        //设置视图
        modelAndView.setViewName("role-list.jsp");
//        System.out.println(roleList);
        return modelAndView;
    }
}
