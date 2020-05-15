package com.property.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.property.SpringBootConfigurer;
import com.property.WebSecurityConfig;
import com.property.controller.util.UserHandlerInterceptor;
import com.property.dao.LoginRepository;
import com.property.dto.Listing;
import com.property.service.ListingService;
import com.sun.org.apache.xpath.internal.operations.Mult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.security.Principal;
import java.util.*;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ListingRdbmsController.class)
@Import(WebSecurityConfig.class)
public class GetListingControllerTest {
    @Autowired MockMvc mvc;

    @MockBean
    ListingService listingService;


    @MockBean
    Listing listing;
    @MockBean
    Principal principal;


    @BeforeEach
    public void init(){
    }

    @Test
    public void testGetListingByIdBasicFlow() throws Exception {
        when(listingService.getListingById(anyLong())).thenReturn(Optional.of(new Listing()));

        mvc.perform(get("/listings/" + anyInt()))
                .andExpect(view().name("single_property"))
                .andExpect(model().attributeExists("listing"));
    }

    @Test
    public void testGetListingByIdNotExist() throws Exception {
        int listing_id = anyInt();
        when(listingService.getListingById(listing_id)).thenReturn(Optional.empty());
        mvc.perform(get("/listings/" + listing_id))
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("error"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testPostNewListingBasicFlow() throws Exception {
        String body = "{\n" +
                "  \"street\": \"232freaf\",\n" +
                "  \"city\": \"fewafw\",\n" +
                "  \"state\": \"AR\",\n" +
                "  \"zipcode\": 12345,\n" +
                "  \"price\": 94984,\n" +
                "  \"extra_charges\": 515,\n" +
                "  \"property_type\": \"house\",\n" +
                "  \"user_type\": \"owner\",\n" +
                "  \"list_for\": \"sell\",\n" +
                "  \"house_sybtype\": \"independent\",\n" +
                "  \"project_name\": \"reafre\",\n" +
                "  \"area\": 1100,\n" +
                "  \"bedroom_num\": 2,\n" +
                "  \"bathroom_num\": 1,\n" +
                "  \"balconies\": 0,\n" +
                "  \"total_floor\": 25,\n" +
                "  \"furnishing\": \"semifurnished\",\n" +
                "  \"parking\": false,\n" +
                "  \"available_from\": \"03-03-03\",\n" +
                "  \"age\": 20,\n" +
                "  \"description\": \"aeferwafe\",\n" +
                "  \"email\": \"j@j.com\",\n" +
                "  \"phonenumber\": 1234567890,\n" +
                "  \"name\": \"Jon DOe\",\n" +
                "  \"about\": \"ewafrew\"\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();
        MultiValueMap map = new LinkedMultiValueMap();
        mapper.readValue(body, Map.class).forEach((k,v) -> map.add(k, v.toString()));



        mvc.perform(post("/listings/new").params(map))
//                .principal(principal))
                .andExpect(view().name("add_listing_success"))
                .andExpect(model().attributeDoesNotExist("error"))
                .andExpect(model().attributeExists("email","listing_id"));
    }
}
//
//@TestConfiguration
//@MockBeans({@MockBean(LoginRepository.class), @MockBean(UserHandlerInterceptor.class)})
//@Import({WebSecurityConfig.class, WebMvcConfiguration.class})
//class MyConfiguration{
//
//
//    @Bean
//    public UrlProperties properties(){
//        return new UrlProperties();
//    }

//    @Bean
//    public WebSecurityConfig securityConfig(){
//        WebSecurityConfig webSecurityConfig = new WebSecurityConfig();
//        webSecurityConfig.setRepository(repository);
//        webSecurityConfig.setProperties(properties());
//        return webSecurityConfig;
//    };
//
//    @Bean
//    public WebMvcConfiguration webMvcConfiguration(){
//        return new WebMvcConfiguration(userHandlerInterceptor);
//    }
//}

