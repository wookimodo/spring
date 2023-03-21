package com.company.design;

import com.company.design.adapter.Cleaner;
import com.company.design.adapter.Electronic110V;
import com.company.design.adapter.HairDryer;
import com.company.design.adapter.SocketAdapter;
import com.company.design.aop.AopBrowser;
import com.company.design.proxy.Browser;
import com.company.design.proxy.BrowserProxy;
import com.company.design.proxy.IBrowser;
import com.company.design.singleton.AClazz;
import com.company.design.singleton.BClazz;
import com.company.design.singleton.SocketClient;

import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {

        /*
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();
        // AClazz, BClazz에서 SocketClient를 생성하는 것이 아니라, SocketClient 자신을 통해서만 생성되도록.
        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();
        // 그래서 true
        System.out.println("두 개의 객체가 동일한가?");
        System.out.println(aClient.equals(bClient));


        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);


        Browser browser = new Browser("www.naver.com");
        browser.show();

        IBrowser browser = new BrowserProxy("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();

         */

        AtomicLong start = new AtomicLong();
        AtomicLong end  = new AtomicLong();

        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                ()->{
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                ()->{
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
        );
        aopBrowser.show();
        System.out.println("loading time : " + end.get());
        aopBrowser.show();
        System.out.println("loading time : " + end.get());

    }

    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }
}