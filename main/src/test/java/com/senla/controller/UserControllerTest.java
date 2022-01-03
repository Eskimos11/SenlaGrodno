package com.senla.controller;

import com.senla.WebApplicationTest;
import com.senla.api.dao.UserDao;
import com.senla.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest extends WebApplicationTest {
//
//    @Autowired
//    private UserDao userDao;
//
//    @Test
//    void createUser() throws Exception {

//        assertEquals(0, userDao.getAll().size());
//
//        final String userDto = """
//                        {
//                           "name": "smith"
//                        }
//                """;
//        mockMvc.perform(
//                        post("/users")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .accept(MediaType.APPLICATION_JSON)
//                                .content(userDto)
//                ).andExpect(status().is2xxSuccessful())
//                .andDo(print())
//                .andExpect(jsonPath("$.id").exists());
//
//        assertNotNull(userDao.getByName("smith"));
//    }


//    @Test
//    public void userShouldBeDeletedById() throws Exception {
//        final User petya = userDao.save(User.builder()
//                .username("petya")
//                .build());
//
//        mockMvc.perform(
//                delete("/users/" + petya.getId())
//        ).andExpect(status().is2xxSuccessful());
//
//        final User user = userDao.getById(petya.getId());
//
//        assertNull(user);
//    }
//    @Test
//    public void userShouldReturnWithCorrectFields() throws Exception {
//        final User petya = userDao.save(User.builder()
//                .username("petya")
//                .build());
//
//        mockMvc.perform(
//                        get("/users/" + petya.getId())
//                ).andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.id").value(petya.getId()))
//                .andExpect(jsonPath("$.username").value(petya.getUsername()));
//    }

//    @Test
//    void getById() {
//    }
//
//    @Test
//    void updateCustomer() {
//    }
}