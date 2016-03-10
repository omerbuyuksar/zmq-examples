package com.examples;

/**
 * Created by omer on 3/10/16.
 */

import org.zeromq.*;

import java.util.Date;

public class Reply {
    public static void main(String[] args) {
        ZMQ.Context ctx= ZMQ.context(1);
        ZMQ.Socket reply= ctx.socket(ZMQ.REP);
        reply.bind("tcp://*:5560");
        System.out.println("Reply socket started");
        while(true){
            String str=reply.recvStr();
            System.out.println("Time:" +(new Date()).toString()+" Recieved: "+str);
            System.out.println("Sending: Hello world");
            reply.send("Hello World");
        }
    }
}
