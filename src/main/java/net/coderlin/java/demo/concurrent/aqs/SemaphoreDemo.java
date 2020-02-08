package net.coderlin.java.demo.concurrent.aqs;

import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Title: SemaphoreDemo
 * Description:
 *
 * @author Lin Hui
 * Created on 2020-1-30 12:25
 */
public class SemaphoreDemo {
    private static final int THREAD_COUNT = 500;

    @Test
    public void testSemaphore() {
        ExecutorService threadPool = Executors.newFixedThreadPool(300);
        Semaphore semaphore = new Semaphore(20);
        for (int i = 0; i < THREAD_COUNT; i++) {
            int threadNum = i;
            threadPool.execute(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("已运行线程数量：" + (20 - semaphore.availablePermits()) + "可运行线程数量：" + semaphore.availablePermits());
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //信号量最好在finally释放，若try发生异常，则仍能释放信号量，不会导致后续线程池阻塞。
                    semaphore.release();
                }
            });
        }
        while (true) {
        }
    }

    public static void test(int threadnum) throws InterruptedException {
        //模拟请求的耗时操作
        Thread.sleep(100);
        System.out.println("Thread Num:" + threadnum);
        //模拟请求的耗时操作
        Thread.sleep(100);
    }
}
