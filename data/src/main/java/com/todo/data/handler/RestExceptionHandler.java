package com.todo.data.handler;

import com.todo.data.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<String> recordNotFoundException(RecordNotFoundException exception){
return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
