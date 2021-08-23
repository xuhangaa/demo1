package com;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceTest {
    @Test
    public void test1() throws SQLException, PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/day14");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void test2() throws SQLException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource ds = (DataSource) app.getBean("datasource1");
        Connection connection = ds.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void test3() throws SQLException {
        DruidDataSource ds=new DruidDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/day14");
        ds.setUsername("root");
        ds.setPassword("root");
        Connection connection = ds.getConnection();
        System.out.println(connection);
        connection.close();
    }
    @Test
    public void test4() throws SQLException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource ds = (DataSource) app.getBean("datasource2");
        Connection connection = ds.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
