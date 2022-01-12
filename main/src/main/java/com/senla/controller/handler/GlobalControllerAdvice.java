package com.senla.controller.handler;

import com.senla.controller.handler.dto.ErrorMessageDto;
import com.senla.exception.ProviderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProviderNotFoundException.class)
    public ErrorMessageDto errorMessageDto(ProviderNotFoundException providerNotFoundException) {
        return new ErrorMessageDto(
                "Пользователь с id=" + providerNotFoundException.getId() + " не найден"
        );
    }

//    @ExceptionHandler(RuntimeException.class)
//    public ErrorMessageDto catchRuntimeException() {
//        return new ErrorMessageDto("ERROR");
//    }
}
