package com.controller;


import com.domain.User;
import com.domain.VO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//@Controller
@Controller()
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/quick23")
    @ResponseBody
    public void save23(String username, MultipartFile[] uploadFile) throws IOException {
        System.out.println(username);
        for(MultipartFile multipartFile:uploadFile){
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("C:\\upload\\"+originalFilename));
        }
    }

    @RequestMapping(value = "/quick22")
    @ResponseBody
    public void save22(String username, MultipartFile uploadFile){
        System.out.println(username);
        String originalFilename = uploadFile.getOriginalFilename();
        try {
            uploadFile.transferTo(new File("C:\\upload\\"+originalFilename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/quick21")
    @ResponseBody
    public void save21(@CookieValue("JSESSIONID") String jsessionID){
        System.out.println(jsessionID);
    }

    @RequestMapping(value = "/quick20")
    @ResponseBody
    public void save20(@RequestHeader(value = "User-Agent",required = false) String user_agent){
        System.out.println(user_agent);
    }

    @RequestMapping(value = "/quick19")
    @ResponseBody
    public void save19(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    @RequestMapping(value = "/quick18")
    @ResponseBody
    public void save18(Date date) throws IOException {
        System.out.println(date);
    }

    @RequestMapping(value = "/quick17/{username}")
    @ResponseBody
    public void save17(@PathVariable(value = "username") String username) throws IOException {
        System.out.println(username);
    }

    @RequestMapping(value = "/quick16")
    @ResponseBody//代表不进行页面跳转,直接回写数据
    public void save16(@RequestParam(value = "name",required = false,defaultValue = "aa") String username) throws IOException {
        System.out.println(username);
    }


    @RequestMapping(value = "/quick15")
    @ResponseBody//代表不进行页面跳转,直接回写数据
    public void save15(@RequestBody List<User> userList) throws IOException {
        System.out.println(userList);
    }

    @RequestMapping(value = "/quick14")
    @ResponseBody//代表不进行页面跳转,直接回写数据
    public void save14(VO vo) throws IOException {
        System.out.println(vo);
    }

    @RequestMapping(value = "/quick13")
    @ResponseBody//代表不进行页面跳转,直接回写数据
    public void save13(String[] strs) throws IOException {
        System.out.println(Arrays.asList(strs));
    }

    @RequestMapping(value = "/quick12")
    @ResponseBody//代表不进行页面跳转,直接回写数据
    public void save12(User user) throws IOException {
        System.out.println(user);
    }

    @RequestMapping(value = "/quick11")
    @ResponseBody//代表不进行页面跳转,直接回写数据
    public void save11(String username, int age) throws IOException {
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping(value = "/quick10")
    @ResponseBody
    public User save10() throws IOException {
        User user = new User();
        user.setName("aa");
        user.setAge(18);
        return user;
    }

    @RequestMapping(value = "/quick9")
    @ResponseBody
    public String save9() throws IOException {
        User user = new User();
        user.setName("aa");
        user.setAge(18);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }

    @RequestMapping(value = "/quick8")
    @ResponseBody
    public String save8() throws IOException {
        return "{\"username\":\"aa\",\"age\":18}";
    }

    @RequestMapping(value = "/quick7")
    @ResponseBody
    public String save7() throws IOException {
        return "hello xuhang";
    }

    @RequestMapping(value = "/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().println("hello xuhang");
    }

    @RequestMapping(value = "/quick5")
    public String save5(HttpServletRequest request) {
        request.setAttribute("username", "xuhang");//使用request域的方式
        return "/success.jsp";
    }

    @RequestMapping(value = "/quick4")
    public String save4(Model model) {
        model.addAttribute("username", "xuhang");
        return "/success.jsp";
    }

    @RequestMapping(value = "/quick3")
    public ModelAndView save3(ModelAndView modelAndView) {
        modelAndView.addObject("username", "xuhang");
        modelAndView.setViewName("/success.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/quick2")
    public ModelAndView save2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", "xuhang");
        modelAndView.setViewName("/success.jsp");//  '/'很重要
        return modelAndView;
    }


    //返回字符串的形式，同时传递默认为get
    @RequestMapping(value = "/quick", method = RequestMethod.GET, params = {"username"})
    public String save() {
        System.out.println("Controller save running");
//        return "success.jsp";
        //有forward和redirect 两种类型
        return "/success.jsp";//加上/相当于从当前web资源下寻找资源
    }
}
