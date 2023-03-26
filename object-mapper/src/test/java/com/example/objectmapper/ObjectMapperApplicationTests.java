package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("---------------");

        var objectMapper = new ObjectMapper();

        //object -> text
        // object mapper는 get메소드를 활용한다.
        // objectMapper가 참조하는 클래스에서는 get으로 시작하는 함수를 따로 만들지 않아야 한다.
        var user = new User("Steve",10, "010-8785-8950");
        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        // text -> object
        // object mapper는 default 생성자를 필요로 한다.
        var objectUser = objectMapper.readValue(text, User.class);
        System.out.println(objectUser);

    }

}
