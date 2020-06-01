package com.caowei;

public class ThreadDemo3 {
    public static void main(String[] args){
        MyRunnable4 mr4 = new MyRunnable4();
        Thread t = new Thread(mr4);
        t.setPriority(Thread.MAX_PRIORITY);  //设置线程优先级，优先级高该线程抢占cpu时间片的机会大
        t.setName("thread-ttt"); //线程起名
        //线程可以分为守护线程和用户线程，当进程中没有用户线程时，虚拟机JVM会退出
        t.setDaemon(true);   //把线程设置为守护线程
        System.out.println(t.isAlive());
        t.start();
        System.out.println(t.isAlive());  //线程是否激活

        for(int i = 0; i < 50;i++){
            System.out.println("main--"+i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i == 5){
                Thread.yield(); //让出本次CPU的执行时间片（让一次 没什么用）
            }
        }
    }
}

class MyRunnable4 implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 50;i++){
            System.out.println("--"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}