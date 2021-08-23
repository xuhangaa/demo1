package service.impl;

import dao.RoleDao;
import dao.UserDao;
import domain.Role;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> list() {
        List<User> userList = userDao.findAll();
//        封装每一个user的roles数据
        for (User user : userList) {
            Long id = user.getId();
            List<Role> roles = roleDao.findRoleByUserID(id);
            user.setRoles(roles);
        }
        return userList;
    }

    public void save(User user, Long[] roleIds) {
        Long userId = userDao.save(user);
        userDao.saveUserRoleRel(userId, roleIds);
    }

    public void del(Long userId) {
//        1.删除关系表
        userDao.delUserRoleRel(userId);
//    2.删除user表
        userDao.del(userId);
    }

    public User login(String username, String password) {
        try {
            User user = userDao.findByUsernameAndPassword(username, password);
            return user;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
