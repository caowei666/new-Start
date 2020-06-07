package com.vince.mina;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        //创建连接
        NioSocketConnector connector = new NioSocketConnector();
        DefaultIoFilterChainBuilder chain = connector.getFilterChain();
        //chain.addLast("myChain",new ProtocolCodecFilter(new TextLineCodecFactory()));
        //设定过滤器以对象为单位
        chain.addLast("objectFilter",new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));

        connector.setHandler(new MinaClientHandler());
        connector.setConnectTimeoutMillis(10000);
        //连接服务器
        ConnectFuture cf = connector.connect(new InetSocketAddress("localhost",9999));
        cf.awaitUninterruptibly();//等待连接成功
        Scanner input = new Scanner(System.in);
        while (true){
//            System.out.println("请输入消息：");
//            String info = input.nextLine();
//            //发送消息
//            cf.getSession().write(info);

            //以对象的方式传输数据
            Message msg = new Message();
            System.out.println("from:");
            msg.setFrom(input.nextLine());
            System.out.println("to:");
            msg.setTo(input.nextLine());
            System.out.println("info:");
            msg.setInfo(input.nextLine());
            msg.setType("send");
            cf.getSession().write(msg);
        }
        //等待服务器连接关闭，此连接才结束
        //cf.getSession().getCloseFuture().awaitUninterruptibly();
        //connector.dispose();
    }
}
