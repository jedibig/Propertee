package com.property.controller;

import com.property.controller.util.ModelAttributeName;
import com.property.controller.util.SessionAttributeName;
import com.property.controller.util.UserHandlerInterceptor;
import com.property.controller.util.ViewName;
import com.property.dto.Listing;
import com.property.service.ListingService;
import com.property.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ListingRdbmsController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    UserService service;
    @MockBean
    ListingService listingService;

    @Mock
    List<Listing> listingList;

    MockHttpSession session;

    @BeforeEach
    void setUp() {
        session = new MockHttpSession();
        session.setAttribute(SessionAttributeName.USER_ID, 10);
    }

    @Test
    void getListingsBasicFlow() throws Exception {
        when(listingService.getListingFromUserId(anyLong())).thenReturn(Optional.of(listingList));

        mvc.perform(get("/user/listings").session(session))
            .andExpect(view().name(ViewName.SEARCH_RESULT_PAGE))
            .andExpect(model().attribute(ModelAttributeName.LISTINGS_NOT_FOUND,false))
            .andExpect(model().attributeExists(ModelAttributeName.LIST_LISTINGS));
    }

    @Test
    public void getListingNoListing() throws Exception {
        mvc.perform(get("/user/listings").session(session))
                .andExpect(view().name(ViewName.SEARCH_RESULT_PAGE))
                .andExpect(model().attributeExists(ModelAttributeName.ERROR_MESSAGE));
    }
}
