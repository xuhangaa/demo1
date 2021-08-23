package com.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext=sce.getServletContext();
        servletContext.getInitParameter("contextConfigLocation");


        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        //将app存储到ServletContext对象中

        servletContext.setAttribute("app",app);
        System.out.println("spring 容器创建完毕");
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
