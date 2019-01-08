package com.newton.enhance.ioservice.socket;


import java.net.Socket;
import java.util.Date;

public class IOClient {

    public static void main(String[] args) {
        new Thread(() -> {
            try {

                //连接服务端的socket
                Socket socket = new Socket("127.0.0.1", 8000);


                //写点内容
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        socket.getOutputStream().flush();
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e) {
            }
        }).start();
    }


}
