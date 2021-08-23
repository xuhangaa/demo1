package com.impl;

import com.dao.UserDao;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//<bean id="userService" class="com.impl.UserServiceImpl">
//@Component("userService")
@Service("userService")
public class UserServiceImpl implements UserService {
    @Value("${jdbc.driver}")
    private String driver;
//    @Autowired
//    @Qualifier("userDao")
    @Resource(name="userDao")//等于Autowired+Qualifier
    private UserDao userDao;
//    注解方式可以不写set方法，xml需要因为反射调用set方法
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    public void save() {
        System.out.println(driver);
        userDao.save();
    }
    @PostConstruct
    public void init(){
        System.out.println("intialization");
    }
    @PreDestroy
    public void destory(){
        System.out.println("destrty");
    }
}
