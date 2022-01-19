package com.senla.controller.handler;

import com.senla.controller.handler.dto.ErrorMessageDto;
import com.senla.entity.DiscountCard;
import com.senla.exception.*;
import liquibase.pro.packaged.E;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.NoResultException;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorMessageDto errorMessageDto(UserNotFoundException userNotFoundException) {
        return new ErrorMessageDto(
                "Пользователь с id=" + userNotFoundException.getId() + " не найден"
        );
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CardNotFoundException.class)
    public ErrorMessageDto errorMessageDto(CardNotFoundException cardNotFoundException) {
        return new ErrorMessageDto(
                "Карта с id=" + cardNotFoundException.getId() + " не найдена"
        );
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoResultException.class)
    public ErrorMessageDto errorMessageDto(NoResultException noResultException) {
        return new ErrorMessageDto("Карта не найдена");
    }

    @ExceptionHandler(UserFoundException.class)
    public ErrorMessageDto catchRuntimeException(UserFoundException userFoundException) {
        return new ErrorMessageDto("Логин " + userFoundException.getLogin() + " занят");
    }
    @ExceptionHandler(DiscountCardFoundException.class)
    public ErrorMessageDto catchRuntimeException(DiscountCardFoundException discountCardFoundException) {
        return new ErrorMessageDto("Карту уже приложили");
    }

    @ExceptionHandler(RuntimeException.class)
    public ErrorMessageDto catchRuntimeException() {
        return new ErrorMessageDto("ERROR");
    }
}
