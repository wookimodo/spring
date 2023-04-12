package com.fastcampus.jpa.bookmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // restapi의 요청을 받을 수 있다는 의미
public class HelloWorldController {

    @GetMapping("/hello-world") // http메소드를 get으로 받겠다
    public String helloWorld(){
        return "hello-world";
    }
}
