package com.senla.controller.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.senla.entity.Provider;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class JsonToModelMapper {

    private final ObjectMapper objectMapper;

    public JsonToModelMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    public Provider convertToModel(String model) {
        return objectMapper.readValue(model, Provider.class);
    }
}


