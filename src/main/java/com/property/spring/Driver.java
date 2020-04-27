package com.property.spring;

import com.property.exception.DaoException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {
    public void main(String[] args) throws DaoException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    }
}
