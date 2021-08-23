package com.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;

@Configuration
//<context:component-scan base-package="com"/>
@ComponentScan("com")
@Import({DataSourceConfiguration.class})//这是个数组，加其他直接写进去
public class SpringConfiguration {

}
