package com.vince;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerDemo {
    public static void main(String[] args) {
        //创建一个服务端的Socket(1024-65535)
        try {
            ServerSocket server = new ServerSocket(6666);
            System.out.println("服务器已启动，正在等待客户端的连接....");
            //等待客户端的连接，造成阻塞，如果有客户端连接成功，立即返回Socket对象
            Socket socket = server.accept();
            System.out.println("客户端连接成功"+server.getInetAddress().getHostAddress());
            InputStream inputStream = socket.getInputStream();
            InputStreamReader isR = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isR);
            //通过输入流读取网络数据,如果没有数据会造成阻塞
            String s = br.readLine();
            System.out.println(s);
            //向客户端返回消息
            PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
            ps.println("echo+"+s);
            ps.flush();
            //关闭流
            ps.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
