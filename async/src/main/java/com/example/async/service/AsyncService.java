package com.example.async.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class AsyncService {

    @Async("async-thread")
    public CompletableFuture run(){
        // hello()를 별도의 쓰레드에서 실행시켜줌
        return new AsyncResult(hello()).completable();
    }

    @Async //비동기로 동작할 수 있도록
    public String hello() {
        for(int i = 0; i<10;i ++){
            try {
                Thread.sleep(2000);
                log.info("thread sleep");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "async hello";
    }
}
