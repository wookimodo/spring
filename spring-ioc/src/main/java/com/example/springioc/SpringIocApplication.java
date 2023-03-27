package com.example.springioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class SpringIocApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIocApplication.class, args);

        ApplicationContext context = ApplicationContextProvider.getContext();
        // component로 관리를 하니까 이제 getBean으로 가져올 수 있음.
        // Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
        // UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);

        // Encoder도 Component화 하면 더이상 new로 생성하는 부분이 없음. 모든 제어권을 스프링에 넘긴 것.
        Encoder encoder = context.getBean("urlEncode",Encoder.class);
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        String result = encoder.encode(url);
        System.out.println(result);

//        encoder.setIEncoder(urlEncoder);
//        result = encoder.encode(url);
//        System.out.println(result);
    }
}

@Configuration // 하나의 클래스에서 여러 개의 bean을 등록할거라는 의미.
class AppConfig{

    @Bean("base64Encode")
    public Encoder encoder(Base64Encoder base64Encoder){
        return new Encoder(base64Encoder);
    }

    @Bean("urlEncode")
    public Encoder encoders(UrlEncoder urlEncoder){
        return new Encoder(urlEncoder);
    }

}
