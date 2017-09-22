package com.company;

public class Main {
    public static void main (String [] args) throws InterruptedException{
        int count = 5;
        Timer timer = new Timer();

        Runnable t1 = new Messager(5, timer);
        Runnable t2 = new Messager(7, timer);

        new Thread(t1, "t1").start();
        new Thread(t2, "t2").start();

        for (int i = 0; i < count; i++) {
            synchronized(timer) {
                //Thread.sleep(1000);
                Timer.time++;
                System.out.println(Timer.time);
                timer.notifyAll();
            }
        }
    }
}
