package com.vince;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MutilClientDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //创建Socket对象，指定要连接的服务器
        try {
            Socket socket = new Socket("127.0.0.1",6666);
            //获取scoket的输入输出流
            PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("请输入：");
            String info = input.nextLine();
            ps.println(info);
            ps.flush();
            //服务器返回数据
            String s = br.readLine();
            System.out.println(s);
            ps.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

