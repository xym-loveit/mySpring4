package com.xym.spring4.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author xym
 */
public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception {

        HomeController homeController = new HomeController();
        MockMvc build = MockMvcBuilders.standaloneSetup(homeController).build();
        build.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.view().name("home"));
    }
}