package com.examples;

import org.zeromq.ZMQ;

import java.util.Date;
import java.util.Random;

/**
 * Created by omer on 3/10/16.
 */
public class Push {
    public static void main(String[] args) throws InterruptedException {
        ZMQ.Context ctx= ZMQ.context(1);
        ZMQ.Socket pusher= ctx.socket(ZMQ.PUSH);
        String str="";
        if(args.length>0){
            str=args[0];
            pusher.setHWM(1);
        }
        pusher.connect("tcp://localhost:5560");
        System.out.println("Pusher socket started");
        Random rand = new Random();
        while(true){
            int r= rand.nextInt(100)+1;
            pusher.send("Push message"+r+str);
            System.out.println("Pushed message"+r+str);
            Thread.sleep(100);
        }
    }
}
