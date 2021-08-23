package service.impl;

import dao.RoleDao;
import domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import service.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

//    public void setRoleDao(RoleDao roleDao) {
//        this.roleDao = roleDao;
//    }

    public List<Role> list() {
        List<Role> roleList= roleDao.findAll();
        return roleList;
    }

    public void save(Role role) {
        roleDao.save(role);
    }
}
