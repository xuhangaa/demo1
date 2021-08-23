package test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class JDBCTemplateTest {

    @Test
    public void test3(){

    }

    @Test
    public void test2(){
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);
        int row = jdbcTemplate.update("insert into account value (?,?)", "jjj", "5000");
        System.out.println(row);
    }

    @Test
    public void test1() throws PropertyVetoException {
        ComboPooledDataSource ds=new ComboPooledDataSource();
        ds.setDriverClass("com.mysql.cj.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        ds.setUser("root");
        ds.setPassword("root");
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(ds);

        int tom = template.update("insert into account value (?,?)", "tom", "5000");
        System.out.println(tom);
    }

}
