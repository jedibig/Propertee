package com.property.controller;

import com.property.SpringBootConfigurer;
import com.property.WebMvcConfiguration;
import com.property.WebSecurityConfig;
import com.property.controller.util.UserHandlerInterceptor;
import com.property.dao.LoginRepository;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;

@TestConfiguration
@SpringBootConfiguration
@Import({SpringBootConfigurer.class, WebSecurityConfig.class, WebMvcConfiguration.class})
public class TestControllerConfiguration {
    @MockBean
    LoginRepository loginRepository;
    @MockBean
    UserHandlerInterceptor userHandlerInterceptor;
}
