package com.examples;

import org.zeromq.ZMQ;

import java.util.Date;

/**
 * Created by omer on 3/10/16.
 */
public class Publisher {

    public static void main(String[] args) throws InterruptedException {
        ZMQ.Context ctx= ZMQ.context(1);
        ZMQ.Socket pub = ctx.socket(ZMQ.PUB);
        pub.bind("tcp://*:5560");
        System.out.println("Pub socket started");
        while(true){
            pub.sendMore("EURUSD");
            pub.send(" ucuz");
            pub.sendMore("GBPUSD");
            pub.send(" pahalı");
            Thread.sleep(100);
            System.out.println("Published:" +(new Date()).toString());
        }
    }
}
