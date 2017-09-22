package com.company;

public class Messager implements Runnable {
    int time;
    public Timer timer;

    Messager(int time, Timer timer) {
        this.time = time;
        this.timer = timer;
    }

    public void waitTime() {
        synchronized (timer) {
            try {
                timer.wait(1000);
                System.out.println("================");
                System.out.println("The time is : " + this.time);
            } catch (InterruptedException e) {
            }
        }
    }
    public void run() {
        waitTime();
    }
}
