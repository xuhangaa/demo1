package com.dao.impl;

import com.dao.UserDao;
import com.dao.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {
    private List<String> strList;
    private Map<String, User> userMap;
    private Properties properties;

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    private  String username;
    private  int age;
  /*  public UserDaoImpl() {
        System.out.println("creat");
    }

    public void init(){
        System.out.println("initialization");
    }

    public void destory(){
        System.out.println("destory");
    }*/

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void save() {
//        System.out.println(username+"=="+age);
        System.out.println(strList);
        System.out.println(userMap);
        System.out.println(properties);
        System.out.println("save running");

    }
}
