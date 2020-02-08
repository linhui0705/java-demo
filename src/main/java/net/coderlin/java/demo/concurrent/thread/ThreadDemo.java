package net.coderlin.java.demo.concurrent.thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Title: ThreadDemo
 * Description:
 * 创建线程的四种方式
 *
 * @author Lin Hui
 * Created on 2020-1-30 15:17
 */
public class ThreadDemo {
    @Test
    public void testThread() throws ExecutionException, InterruptedException {
        //Thread
        Thread thread1 = new MyThread();
        thread1.start();

        //Runnable
        Thread thread2 = new Thread(new MyRunnable());
        thread2.start();

        //Callable and Future
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        Thread thread3 = new Thread(futureTask);
        thread3.start();
        //MyCallable 线程阻塞3秒后返回结果，futureTask.get()会一直等待，直到线程返回结果
        System.out.println(futureTask.get());
        //MyCallable 线程阻塞3秒后返回结果，futureTask.get(1, TimeUnit.SECONDS)若超过1秒，会抛出超时异常TimeoutException
        //System.out.println(futureTask.get(1, TimeUnit.SECONDS));

        //ThreadPoolExecutor
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 5L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        executor.execute(() -> System.out.println("My name is ThreadPoolExecutor. I'm running now!"));
    }
}
