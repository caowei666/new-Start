package com.caowei;

public class ThreadDemo1 {
    public static void main(String[] args){
        MyThread mt = new MyThread();
        mt.start(); //启动线程

        //推荐
        MyRunnable mr = new MyRunnable();  //自己需要的逻辑。同时可以继承别的类
        Thread t2 = new Thread(mr);  //放入线程中执行
        t2.start();
    }
}

/**
 * 实现线程的第一种方式：继承thread类
 */
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0;i<50;i++){
            //输出当前线程的名字
            System.out.println(super.currentThread().getName()+"-"+i);
//            System.out.println(Thread.currentThread().getName()+"-"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
/**
 *实现线程的第二种方式：实现runnable接口
 */
class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+"-"+i);
            try {
                Thread.sleep(500);  //线程休眠 当前线程暂停指定毫秒数，释放cpu的时间片
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
