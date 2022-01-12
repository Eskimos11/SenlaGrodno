package com.senla.controller;

import com.senla.WebApplicationTest;
import com.senla.api.dao.UserDao;
import com.senla.controller.dto.UserDto.UserCreateDto;
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


    @Autowired
    private UserDao userDao;

//    @Test
//    public void userShouldBeCreated() throws Exception {
//
//        assertEquals(0, userRepository.getAll().size());
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
//        assertNotNull(userRepository.getByName("smith"));
//    }

    @Test
    public void userShouldBeDeletedById() throws Exception {
        final User petya = userDao.save(User.builder()
                .username("petya")
                .build());

        mockMvc.perform(
                delete("/users/" + petya.getId())
        ).andExpect(status().is2xxSuccessful());

        final User user = userDao.getById(petya.getId());

        assertNull(user);
    }

    @Test
    public void userShouldReturnWithCorrectFields() throws Exception {
        final User petya = userDao.save(User.builder()
                .username("petya")
                .build());

        mockMvc.perform(
                        get("/users/" + petya.getId())
                ).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").value(petya.getId()))
                .andExpect(jsonPath("$.username").value(petya.getUsername()));
    }

//    @Test
//    public void userNameShouldBeUpdated() throws Exception {
//        final User petya = userDao.save(User.builder()
//                .username("petya")
//                .build());
//
//        final String userUpdateDto = String.format("""
//                {
//                   "name": "smith",
//                   "id": %s
//                }
//                """, petya.getId());
//
//        mockMvc.perform(
//                        put("/users/")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(userUpdateDto)
//                ).andExpect(status().is2xxSuccessful())
//                .andDo(print())
//                .andExpect(jsonPath("$.id").value(petya.getId()))
//                .andExpect(jsonPath("$.name").value("smith"));
//
//        final User smith = userRepository.getByName("smith");
//        assertEquals(smith.getId(), petya.getId());
//    }

    @Test
    public void shouldReturnErrorTextWhenUserNotExists() throws Exception {
        mockMvc.perform(
                        get("/users/12")
                ).andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Пользователь с id=12 не найден"));
    }
}