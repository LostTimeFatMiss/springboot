package com.sym.springboot.rest.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/6/12
 */
@Configuration
public class DataSourceConfig {
    @Autowired
    private Environment environment;

    @Bean
    @Primary
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/springboot");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        druidDataSource.setInitialSize(2);
        druidDataSource.setMaxActive(20);
        druidDataSource.setMinIdle(0);
        druidDataSource.setMaxWait(60000);
        druidDataSource.setValidationQuery("SELECT 1");
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setPoolPreparedStatements(false);
        return druidDataSource;
    }

    /*@Bean*/
    /*注释掉是因为下面给变成了jdbctemp,用不到这个作为bean*/
    public DataSource dataSource1(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/shiro");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        druidDataSource.setInitialSize(2);
        druidDataSource.setMaxActive(20);
        druidDataSource.setMinIdle(0);
        druidDataSource.setMaxWait(60000);
        druidDataSource.setValidationQuery("SELECT 1");
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setPoolPreparedStatements(false);
        return druidDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public JdbcTemplate renrenJdbcTemp(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource1());
        return jdbcTemplate;
    }
}
