package com.property.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:database.properties")
public class PropertyConfig {
    @Value("${hbm2ddl}") String hbm2ddl;
    @Value("${url}") String url;
    @Value("${db_username}") String username;
    @Value("${password}") String password;
    @Value("${driver}") String driver;
    @Value("${dialect}") String dialect;
}
