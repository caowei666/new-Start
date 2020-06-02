package com.caowei;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 1、多线程共享数据时会发生线程不安全的情况
 * 2、多线程共享数据必须用同步
 * 3、实现同步的三种方式：
 * （1）使用同步代码块
 *  （2）使用同步方法
 *   （3）使用同步锁（更灵活）
 *  同步会牺牲性能换取安全所以同步的代码块要保持简短，把不随数据变化的相关代码移除同步块
 *  不要阻塞
 *4、线程死锁：在一个同步方法中调用了另一个对象的同步方法，可能产生死锁
 */
public class ThreadDemo4 {
    public static void main(String[] args) {
        MyRunnable5 mr5 = new MyRunnable5();
        Thread t1 = new Thread(mr5);
        Thread t2 = new Thread(mr5);
        t1.start();
        t2.start();
    }
}

class MyRunnable5 implements Runnable{
    private int ticket = 10;//售票
    @Override
    public void run() {
        for(int i = 0;i < 300;i++){
//            synchronized (" "){
//                if(ticket>0){
//                    ticket--;
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("您购买的票剩余"+ticket+"张");
//                }
//            }
//            method();
            method2();
        }
    }

    //第二种 同步方法:同步的对象时this
    private  synchronized void method(){
        if(ticket>0){
            ticket--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("您购买的票剩余"+ticket+"张");
        }
    }

    //第三种
    //互斥锁
    ReentrantLock lock = new ReentrantLock();
    private void method2(){
        lock.lock();
        if(ticket>0){
            ticket--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("您购买的票剩余"+ticket+"张");
        }
        lock.unlock();
    }
}
