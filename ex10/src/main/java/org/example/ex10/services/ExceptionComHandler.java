package org.example.ex10.services;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionComHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> commonException(HttpServletRequest req, Exception ex) {

        return ResponseEntity
                .badRequest()
                .body(ex.getMessage() );
    }
}
