package com.company.design.singleton;

public class SocketClient {

    private static SocketClient socketClient = null;

    // 싱글톤은 기본 생성자로 생성할 수 없도록 막아야 함.
    private SocketClient(){

    }

    public static SocketClient getInstance(){
        if(socketClient==null){
            socketClient = new SocketClient();
        }
        return socketClient;
    }
    public void connect(){
        System.out.println("connect");
    }
}
