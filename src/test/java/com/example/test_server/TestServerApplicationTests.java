package com.example.test_server;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class TestServerApplicationTests {

//    @Autowired
//    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void testUserController() throws Exception {
        /*mockMvc.perform(MockMvcRequestBuilders.get("/users"))  // Assuming "/users" is a valid endpoint in UserController
                .andExpect(status().isOk())
                .andDo(print());*/
    }

}
