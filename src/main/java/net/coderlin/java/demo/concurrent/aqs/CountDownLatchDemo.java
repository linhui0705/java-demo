package net.coderlin.java.demo.concurrent.aqs;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Title: CountDownLatchDemo
 * Description:
 *
 * @author Lin Hui
 * Created on 2020-1-30 12:45
 */
public class CountDownLatchDemo {
    private static final int THREAD_COUNT = 1000;

    @Test
    public void testCountDownLatch() throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        for (int i = 0; i < THREAD_COUNT; i++) {
            int threadNum = i;
            threadPool.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        threadPool.shutdown();
        System.out.println("FINISH");
    }

    public static void test(int threadnum) throws InterruptedException {
        //模拟请求的耗时操作
        Thread.sleep(100);
        System.out.println("Thread Num:" + threadnum);
        //模拟请求的耗时操作
        Thread.sleep(100);
    }
}
