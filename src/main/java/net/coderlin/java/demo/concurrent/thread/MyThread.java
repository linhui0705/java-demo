package net.coderlin.java.demo.concurrent.thread;

/**
 * Title: MyThread
 * Description:
 *
 * @author Lin Hui
 * Created on 2020-1-30 15:14
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("My name is MyThread. I'm running now!");
    }
}
