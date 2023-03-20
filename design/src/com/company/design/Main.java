package com.company.design;

import com.company.design.singleton.AClazz;
import com.company.design.singleton.BClazz;
import com.company.design.singleton.SocketClient;

public class Main {
    public static void main(String[] args) {

        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();
        // AClazz, BClazz에서 SocketClient를 생성하는 것이 아니라, SocketClient 자신을 통해서만 생성되도록.
        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();
        // 그래서 true
        System.out.println("두 개의 객체가 동일한가?");
        System.out.println(aClient.equals(bClient));

    }
}