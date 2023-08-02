package com.example.SkyTravel.controller;

import com.example.SkyTravel.model.User;
import com.example.SkyTravel.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @MockBean
    UserService mockedService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getUserByIdTest() throws Exception {
        User testUser = new User();
        testUser.setDisplay_name("test");
        testUser.setEmail("test@test.com");
        testUser.setPassword("password");
        testUser.setUser_id(1);

        when(mockedService.getUserById(1)).thenReturn(testUser);

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //assert
                .andExpect((jsonPath("display_name").value("test")));

    }

    @Test
    public void postUserCreatesNewUserTest() throws Exception {
        User testUser = new User();
        testUser.setDisplay_name("test");
        testUser.setEmail("test@test.com");
        testUser.setPassword("password");
        testUser.setUser_id(1);

        when(mockedService.postUser(any())).thenReturn(testUser);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/users/register")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testUser))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(HttpStatus.CREATED.value(), result.getResponse().getStatus());
    }

    @Test
    public void postUserReturnsErrorIfGivenNullUserTest() throws Exception {
        User testUser = new User();
        testUser.setDisplay_name("test");
        testUser.setEmail("test@test.com");
        testUser.setPassword("password");
        testUser.setUser_id(1);

        when(mockedService.postUser(any())).thenReturn(null);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/users/register")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testUser))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(HttpStatus.PRECONDITION_FAILED.value(), result.getResponse().getStatus());
    }
}
