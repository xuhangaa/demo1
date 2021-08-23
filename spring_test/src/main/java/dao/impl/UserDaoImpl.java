package dao.impl;

import dao.UserDao;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    public List<User> findAll() {
        List<User> userList = jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    public Long save(final User user) {

        PreparedStatementCreator creator = new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
//                使用原始jdbc的方法完成PreparedStatement的组建
                PreparedStatement preparedStatement = connection.prepareStatement("insert into sys_user values(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1, null);
                preparedStatement.setObject(2, user.getUsername());
                preparedStatement.setObject(3, user.getEmail());
                preparedStatement.setObject(4, user.getPassword());
                preparedStatement.setObject(5, user.getPhoneNum());
                return preparedStatement;
            }
        };

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(creator, keyHolder);
//        jdbcTemplate.update("insert into sys_user values(?,?,?,?,?)",
//                null, user.getUsername(), user.getEmail(), user.getPassword(), user.getPhoneNum());

        long userId = keyHolder.getKey().longValue();
        return userId;//返回插入后数据库生成的id
    }

    public void saveUserRoleRel(Long userId, Long[] roleIds) {
        for (Long roleId : roleIds) {
            jdbcTemplate.update("insert into sys_user_role values(?,?)", userId, roleId);
        }
    }


    public void delUserRoleRel(Long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId=?",userId);

    }

    public void del(Long userId) {
        jdbcTemplate.update("delete from sys_user where id=?;",userId);
    }

    public User findByUsernameAndPassword(String username, String password) throws EmptyResultDataAccessException {
        System.out.println(111);
        User user = jdbcTemplate.queryForObject("select * from sys_user where username=? and password=?", new BeanPropertyRowMapper<User>(User.class), username, password);
        System.out.println("dao");
        System.out.println(user);
        return user;
    }
}
