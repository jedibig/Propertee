package com.property.spring;

import java.io.IOException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import com.property.dto.*;
import org.aspectj.apache.bcel.generic.TABLESWITCH;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.property")
public class SpringConfig implements WebMvcConfigurer {

    @Autowired PropertyConfig property;


    public SessionFactory sessionFatory() throws IOException {
        LocalSessionFactoryBean sf= new LocalSessionFactoryBean();
        sf.setDataSource(datasource());
        Properties p= new Properties();
        p.setProperty(Environment.HBM2DDL_AUTO, property.hbm2ddl);
        p.setProperty(Environment.SHOW_SQL, "true");
        p.setProperty(Environment.DIALECT, property.dialect);
        sf.setHibernateProperties(p);
        sf.setAnnotatedClasses(User.class, Listing.class, Pricing.class, Address.class, PropertyDetails.class);
        sf.setAnnotatedPackages("com.property.dto");
        sf.afterPropertiesSet();
        return sf.getObject();
    }


    public DataSource datasource() {
        System.out.println(property.username + property.password);
        DriverManagerDataSource ds= new DriverManagerDataSource(property.url, property.username, property.password);
        ds.setDriverClassName(property.driver);
        return ds;
    }

    @Bean
    public InternalResourceViewResolver vr(){
        return new InternalResourceViewResolver("/WEB-INF/jsp/", ".jsp");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resource/**").addResourceLocations("/resource/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/home").setViewName("index");
        registry.addViewController("/error").setViewName("error");
        registry.addViewController("/property-form").setViewName("post_property");
    }
}
