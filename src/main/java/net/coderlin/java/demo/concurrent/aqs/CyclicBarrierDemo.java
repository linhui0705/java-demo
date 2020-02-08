package net.coderlin.java.demo.concurrent.aqs;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Title: CyclicBarrierDemo
 * Description:
 *
 * @author Lin Hui
 * Created on 2020-1-30 12:55
 */
public class CyclicBarrierDemo {
    private static final int THREAD_COUNT = 10;

    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    @Test
    public void testCyclicBarrierAwait() throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < THREAD_COUNT; i++) {
            int threadNum = i;
            Thread.sleep(1000);
            threadPool.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void test(int threadnum) throws InterruptedException, BrokenBarrierException, TimeoutException {
        System.out.println("Thread-" + threadnum + " is ready. Number waiting: " + cyclicBarrier.getNumberWaiting());
        //CyclicBarrier阻拦线程，每拦到5个线程就放一批线程通过
        cyclicBarrier.await(60, TimeUnit.SECONDS);
        System.out.println("Thread-" + threadnum + " is finish. Number waiting: " + cyclicBarrier.getNumberWaiting());
    }
}
