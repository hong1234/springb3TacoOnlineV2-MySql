package com.hong.flyway.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.UUID;
import java.math.BigDecimal;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import org.springframework.http.MediaType;

import com.hong.flyway.config.SecurityConfiguration;
import com.hong.flyway.config.HttpConverterConfig;
// import com.hong.flyway.domain.CategoryEntity;
// import com.hong.flyway.domain.ProductEntity;
// import com.hong.flyway.domain.Product;
import com.hong.flyway.service.OrderService; 
import com.hong.flyway.controller.OrderController;
import com.hong.flyway.repository.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

import org.springframework.test.context.ContextConfiguration;

// @SpringBootTest 
// @AutoConfigureMockMvc
// public class OrderControllerTest {
//     @Autowired
//     private MockMvc mockMvc;   
    
//     @Test
//     @WithMockUser(username = "admin2", password = "admin", roles = "ADMIN")
//     // @WithMockUser(username = "admin2", roles = {"ADMIN"})
//     // @WithMockUser
//     void testGetProduct() throws Exception {
//         mockMvc
//         .perform(get("/api/v1/products/510a0d7e-8e83-4193-b483-e27e09ddc34d"))
//         .andDo(print())
//         .andExpect(status().isOk())
//         .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//         // .andExpect(content().string(containsString("JavaScript for Gurus")))
//         // .andExpect(jsonPath("$.title").value(product.getTitle()))
//         .andExpect(jsonPath("$.title").value("JavaScript for Gurus"))
//         .andExpect(jsonPath("$.description").value("book for Gurus"))
//         ;
//     }
// }


// @WebMvcTest(OrderController.class)
// @Import(SecurityConfiguration.class)
@SpringBootTest 
@AutoConfigureMockMvc
@WithMockUser
public class OrderControllerTest {

    // @Autowired
    // private WebApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService; 

    // @Test
	// void contextLoads() {
        // assertNotNull(context); 
	// }

    // @BeforeEach
    // public void setup() {
    //     mockMvc = MockMvcBuilders
    //     .webAppContextSetup(context)
    //     .apply(springSecurity())
    //     .build();
    // }

    @Test
    // @WithMockUser(username = "admin", roles = {"ADMIN"})
    // @WithMockUser
    // @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    void testGetOrder() throws Exception {
        mockMvc
        .perform(get("/api/v1/order/bb93a930-3095-4c54-acc1-b7d724ab9131"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        // .andExpect(jsonPath("$.title").value("JavaScript for Gurus"))
        // .andExpect(jsonPath("$.description").value("book for Gurus"))
        ;
    }

}
