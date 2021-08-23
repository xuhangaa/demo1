package com.dao.fatory;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;

public class StaticFatory {
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
