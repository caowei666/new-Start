package com.caowei;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * JDK1.5之后的线程池
 */
public class ThreadDemo5 {
    public static void main(String[] args) {
        //创建线程池的4种方式
        //1创建一个单线程的线程池
//        ExecutorService es = Executors.newSingleThreadExecutor();
//        es.execute(new MyRunable6());
//        es.execute(new MyRunable6());
//        es.shutdown();

        //2创建固定大小的线程池
//        ExecutorService es = Executors.newFixedThreadPool(2);
//        es.execute(new MyRunable6());
//        es.execute(new MyRunable6());
//        es.shutdown();

        //3创建可缓存的线程池（不怎么用）
//        ExecutorService es = Executors.newCachedThreadPool();

        //4创建一个大小无限制的线程池，必须有初始容量
        ScheduledExecutorService es = Executors.newScheduledThreadPool(10);
        es.schedule(new MyRunable6(),3000, TimeUnit.MILLISECONDS);
    }
}

class MyRunable6 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"--"+i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
