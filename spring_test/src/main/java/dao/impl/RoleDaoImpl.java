package dao.impl;

import dao.RoleDao;
import domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    public List<Role> findAll() {
        List<Role> roleList = jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
//        System.out.println(roleList);
        return roleList;
    }

    public void save(Role role) {
        jdbcTemplate.update("insert into sys_role value (?,?,?)",null,role.getRoleName(),role.getRoleDesc());
    }

    public List<Role> findRoleByUserID(Long id) {
        List<Role> roles = jdbcTemplate.query("select * from sys_user_role ur,sys_role r " +
                        "where ur.roleId=r.id and ur.userId=? ", new BeanPropertyRowMapper<Role>(Role.class), id);
        return  roles;
    }


}
