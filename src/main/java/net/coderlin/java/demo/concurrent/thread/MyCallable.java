package net.coderlin.java.demo.concurrent.thread;

import java.util.concurrent.Callable;

/**
 * Title: MyCallable
 * Description:
 *
 * @author Lin Hui
 * Created on 2020-1-30 15:16
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("Invoking the call method");
        Thread.sleep(3000L);
        System.out.println("My name is MyCallable. I'm running now!");
        return "SUCCESS";
    }
}
