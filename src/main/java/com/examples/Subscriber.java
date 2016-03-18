package com.examples;

import org.zeromq.ZMQ;

import java.util.Date;

/**
 * Created by omer on 3/10/16.
 */
public class Subscriber {
    public static void main(String[] args) throws InterruptedException {

        ZMQ.Context ctx = ZMQ.context(1);
        ZMQ.Socket sub = ctx.socket(ZMQ.SUB);
        if (args.length > 0)
            sub.subscribe(args[0].getBytes());
        else
            sub.subscribe("".getBytes());
        sub.connect("tcp://localhost:5560");
        System.out.println("Sub socket started");

        while (true) {
            System.out.println(new Date().toString()+" Topic: "+sub.recvStr());
            System.out.println(new Date().toString()+" Msg: "+sub.recvStr());
            Thread.sleep(100);
        }
    }

}
