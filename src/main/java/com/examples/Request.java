package com.examples;

import org.zeromq.ZMQ;

import java.util.Date;

/**
 * Created by omer on 3/10/16.
 */
public class Request {

    public static void main(String[] args) throws InterruptedException {
        long waitTime = 0;
        ZMQ.Context ctx = ZMQ.context(1);
        ZMQ.Socket req = ctx.socket(ZMQ.REQ);
        req.connect("tcp://localhost:5560");
        if (args.length > 0) {
            waitTime = Integer.parseInt(args[0]);
        }
        while (true) {

            System.out.println("Requested");
            req.send("Request" + ((waitTime == 0) ? " Only one request" : ""));

            System.out.println((new Date()).toString() + "Recieved: " + req.recvStr());
            if (waitTime == 0)
                break;
            Thread.sleep(waitTime);

        }
        req.close();
        ctx.close();
        System.exit(0);
    }
}
