package com.senla.controller.handler;

import com.senla.controller.handler.dto.ErrorMessageDto;
import com.senla.exception.ProviderNotFoundException;
import com.senla.exception.UserFoundException;
import com.senla.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorMessageDto errorMessageDto(UserNotFoundException userNotFoundException) {
        return new ErrorMessageDto(
                "Пользователь с id=" + userNotFoundException.getId() + " не найден"
        );
    }

    @ExceptionHandler(RuntimeException.class)
    public ErrorMessageDto catchRuntimeException(UserFoundException userFoundException) {
        return new ErrorMessageDto("Логин " + userFoundException.getLogin() + " занят");
    }

//    @ExceptionHandler(RuntimeException.class)
//    public ErrorMessageDto catchRuntimeException() {
//        return new ErrorMessageDto("ERROR");
//    }
}
