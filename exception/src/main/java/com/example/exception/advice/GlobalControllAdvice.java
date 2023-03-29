package com.example.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllAdvice {

    @ExceptionHandler(value = Exception.class) // 우선 모든 예외를 잡아보자.
    public ResponseEntity exception(Exception e){
        System.out.println(e.getClass().getName());
        System.out.println("--------------------");
        System.out.println(e.getLocalizedMessage());
        System.out.println("--------------------");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }

    // globalcontrolleradvice가 있더라도 이게 우선됨. 이렇게 지정해줄 수 있음.
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
