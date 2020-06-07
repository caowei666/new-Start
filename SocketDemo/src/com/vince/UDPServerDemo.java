package com.vince;

import java.io.IOException;
import java.net.*;

public class UDPServerDemo {
    public static void main(String[] args) {
        String info = "good good 学习，天天 up";
        byte[] bytes = info.getBytes();
        try {
            //封装一个数据报包
            /**
             * 参数：数据包数据，分组数据偏移量，分组数据长度，目的地址，目的端口号
             * 我给别人发数据对方端口是8000
             */
            DatagramPacket dp = new DatagramPacket(bytes,0,bytes.length, InetAddress.getByName("127.0.0.1"),8000);
            //本程序的端口（别人给我发端口是9000）
            DatagramSocket socket = new DatagramSocket(9000);
            socket.send(dp);
        } catch (UnknownHostException | SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
