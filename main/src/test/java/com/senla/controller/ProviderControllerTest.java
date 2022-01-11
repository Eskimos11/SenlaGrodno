package com.senla.controller;


import com.senla.WebApplicationTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


class ProviderControllerTest extends WebApplicationTest {
//
//    @Autowired
//    private ProviderDao providerDao;
//
//    @Test
//    public void userShouldBeDeletedById() throws Exception {
//        final Provider title = providerDao.save(Provider.builder()
//                .title("Cola")
//                .build());
//
//        mockMvc.perform(
//                delete("/providers/" + title.getId())
//        ).andExpect(status().is2xxSuccessful());
//
//        final Provider provider = providerDao.getById(title.getId());
//
//        assertNull(provider);
//    }
////
//    @Test
//    public void providerShouldReturnWithCorrectFields() throws Exception {
//        final Provider provider = providerDao.save(Provider.builder()
//                .title("Cola")
//                .build());
//
//        mockMvc.perform(
//                get("/providers/" + provider.getId())
//        ).andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.id").value(provider.getId()))
//                .andExpect(jsonPath("$.title").value(provider.getTitle()));
//    }
//
//
//
//    @Test
//    public void shouldReturnErrorTextWhenProviderNotExists() throws Exception {
//        mockMvc.perform(
//                get("/providers/12")
//        ).andExpect(status().isNotFound())
//                .andExpect(jsonPath("$.message").value("Пользователь с id=12 не найден"));
//    }
}