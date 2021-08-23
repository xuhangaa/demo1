package com.dao.impl;

import com.dao.UserDao;
import com.dao.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServieImpl implements UserService {
    private UserDao userDao;

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }


    public UserServieImpl() {
    }

    public UserServieImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
//        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDao userDao1=(UserDao) app.getBean("userDao");
////        UserDao userDao2=(UserDao) app.getBean("userDao");
//        System.out.println(userDao1);
        userDao.save();
    }
}
