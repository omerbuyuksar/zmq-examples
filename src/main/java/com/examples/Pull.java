package com.examples;

import org.zeromq.ZMQ;

import java.util.Date;

/**
 * Created by omer on 3/10/16.
 */
public class Pull {

    public static void main(String[] args) {
        ZMQ.Context ctx= ZMQ.context(1);
        ZMQ.Socket puller= ctx.socket(ZMQ.PULL);
        puller.bind("tcp://*:5560");
        System.out.println("Puller socket started");
        while(true){
            String str=puller.recvStr();
            System.out.println("Time:" +(new Date()).toString()+" Recieved: "+str);
        }
    }
}
