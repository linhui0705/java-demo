package net.coderlin.java.demo.concurrent.thread;

/**
 * Title: MyRunnable
 * Description:
 *
 * @author Lin Hui
 * Created on 2020-1-30 15:15
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("My name is MyRunning. I'm running now!");
    }
}
