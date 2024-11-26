package com.example.avaliacao03_final.exceptions;

import com.example.avaliacao03_final.dtos.GlobalExceptionDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice(assignableTypes = {MyController.class}) - example for handling with specific controllers
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GlobalExceptionDto EntityError(HttpServletRequest req, EntityNotFoundException ex) {
        return new GlobalExceptionDto(
                HttpStatus.BAD_REQUEST,
                ex.getMessage()
        );
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GlobalExceptionDto GenericError(HttpServletRequest req, RuntimeException ex) {
        return new GlobalExceptionDto(
                HttpStatus.BAD_REQUEST,
                ex.getMessage()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GlobalExceptionDto NotValidException(HttpServletRequest req, MethodArgumentNotValidException ex) {
        return new GlobalExceptionDto(
                HttpStatus.BAD_REQUEST,
                ex.getAllErrors().get(0).getDefaultMessage()
        );
    }
}
