package com.examples;

import org.zeromq.ZMQ;

import java.util.Date;

/**
 * Created by omer on 3/10/16.
 */
public class Request {

    public static void main(String[] args) {
        long waitTime = 0;
        ZMQ.Context ctx = ZMQ.context(1);
        ZMQ.Socket req = ctx.socket(ZMQ.REQ);
        req.connect("tcp://localhost:5560");
        if (args.length > 0) {
            waitTime = Integer.parseInt(args[0]);
        }
        System.out.println("Wait time="+waitTime);
        while (true) {

            System.out.println("Requested");
            req.send("Request"+ ((waitTime==0) ? " Only one request": ""));

            System.out.println((new Date()).toString()+"Recieved: "+req.recvStr());
            if (waitTime == 0)
                break;
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        req.close();
        ctx.close();
//        ctx.term();
        System.exit(0);
    }
}
