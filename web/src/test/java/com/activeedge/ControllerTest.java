package com.activeedge;

import com.activeedge.models.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void registerAdminApiTest() throws Exception {
        Employee employee = new Employee();
        employee.setFirst_name("Name");
        employee.setLast_name("Surname");

        ObjectMapper mapper = new ObjectMapper();

        this.mockMvc.perform(post("/create-employee")
                .contentType("application/json")
                .content(mapper.writeValueAsString(employee)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
    }


}