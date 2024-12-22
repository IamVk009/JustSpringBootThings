package com.productivity.todoapp.todoservice.exception;

import com.productivity.todoapp.todoservice.response.ApiErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ToDoNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleToDoException(ToDoNotFoundException exception, HttpServletRequest request) {
        ApiErrorResponse errorResponse
                = new ApiErrorResponse(
                UUID.randomUUID().toString(),
                exception.getMessage(),
                exception.getHttpStatus().value(),
                exception.getHttpStatus().name(),
                request.getRequestURI(),
                request.getMethod());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
