package com.dao.demo;

import com.dao.impl.UserServieImpl;
import com.dao.service.UserService;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {
//        空指针错误，因为两个东西没有联系
//        UserService userService=new UserServieImpl();
//        userService.save();


        ApplicationContext app =new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService=(UserService) app.getBean("userService");
        userService.save();


    }
}
