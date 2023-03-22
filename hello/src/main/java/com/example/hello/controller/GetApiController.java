package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path="/hello") // http://localhost:8080/api/get/hello
    public String hello(){
        return "get Hello";
    }
    // 예전 방식
    // RequestMapping은 get, post, put, delete 모두 작동하기 때문에, method 지정 가능
    @RequestMapping(path="/hi",method = RequestMethod.GET) // http://localhost:8080/api/get/hi
    public String hi(){
        return "get hi";
    }

    // http://localhost:8080/api/get/path-variable/{name}
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable String name){
        System.out.println("PathVariable : " + name);
        return name;
    }
    /* // 변수 이름을 다르게 하고 싶을때는 이렇게 짬.
    // http://localhost:8080/api/get/path-variable/{name}
    @GetMapping("/path-variable/{id}")
    public String pathVariable(@PathVariable(name="id") String pathName){
        System.out.println("PathVariable : " + pathName);
        return pathName;
    }
     */
    // 쿼리파라미터 받기(key,value로)
    // http://localhost:8080/api/get/query-param?user=steve&email=steve@gmail.com&age=31
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String,String> queryParam){

        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry ->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+"="+entry.getValue()+"\n");
        });

        return sb.toString();
    }

    //key값들을 명확하게 지정하고 싶을때
    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return  name + " "+ email + " " + age;
    }

    // 현업에서 가장 많이 쓰는 방식
    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }


}
