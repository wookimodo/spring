package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main(){
        return "main.html";
    }

    // ResponseEntity

    @ResponseBody // ResponseBody 를 통해서 json을 내려줄 수도 있음.
    // pageController에서는 ResponseBody를 안내려주는 것이 바람직하고, 내려줘야 한다면 이렇다는 것.
    // ApiController를 따로 만들어서 함.
    @GetMapping("/user")
    public User user(){
        // 타입 추론이 가능한 var
        var user = new User();
        user.setName("YeongUk");
        user.setAddress("관악구");
        return user;
    }
}
