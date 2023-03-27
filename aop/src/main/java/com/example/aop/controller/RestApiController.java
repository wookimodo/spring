package com.example.aop.controller;

import com.example.aop.annotation.Decode;
import com.example.aop.annotation.Timer;
import com.example.aop.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name){
        return id + " " + name;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user){
        return user;
    }

    @Timer // 직접 만든 annotation
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {
        //db logic_2초 있다가 종료되도록 함.
        Thread.sleep(1000*2);
    }

    @Decode
    @PutMapping("/put")
    public User put(@RequestBody User user){
        System.out.println("put");
        System.out.println(user);
        return user;
    }
}
