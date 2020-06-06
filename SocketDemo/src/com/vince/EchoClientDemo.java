package com.vince;

import java.io.*;
import java.net.Socket;

public class EchoClientDemo {
    public static void main(String[] args) {
        //创建Socket对象，指定要连接的服务器
        try {
            Socket socket = new Socket("127.0.0.1",6666);
            //获取scoket的输入输出流
            PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ps.println("hello,my name is caowei");
            ps.flush();
            //服务器返回数据
            String info = br.readLine();
            System.out.println(info);
            ps.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
