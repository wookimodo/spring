package com.company.ioc;

public class Main {

    public static void main(String[] args){
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        // Encoder자체를 변경하는 것이 아니라, 주입시키는 객체를 변경시키는 것.
        // Encoder encoder = new Encoder(new Base64Encoder());
        Encoder encoder = new Encoder(new UrlEncoder());
        String result = encoder.encode(url);

        System.out.println(result);
    }
}
