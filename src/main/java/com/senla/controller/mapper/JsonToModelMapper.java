package com.senla.controller.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.senla.controller.dto.CustomerDto;
import com.senla.controller.dto.ProviderDto;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class JsonToModelMapper {

    private final ObjectMapper objectMapper;

    public JsonToModelMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

//    @SneakyThrows
//    public ProviderDto convertToModel(String model) {
//        return objectMapper.readValue(model, ProviderDto.class);
//    }
//    @SneakyThrows
//    public CustomerDto convertToModel(String model) {
//        return objectMapper.readValue(model, CustomerDto.class);
//    }
}


