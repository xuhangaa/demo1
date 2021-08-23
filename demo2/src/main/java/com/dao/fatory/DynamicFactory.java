package com.dao.fatory;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;

public class DynamicFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
