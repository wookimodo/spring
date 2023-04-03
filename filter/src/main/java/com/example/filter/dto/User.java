package com.example.filter.dto;

import lombok.*;

//lombok 활용
@Data // getter,setter,toString 등 안만들어줘도 됨.
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private int age;
}
