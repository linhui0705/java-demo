package net.coderlin.java.demo.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Title: StreamsDemo
 * Description:
 *
 * @author Lin Hui
 * Created on 2020-1-30 12:08
 */
public class StreamsDemo {
    List<String> stringList;

    public StreamsDemo() {
        stringList = new ArrayList<>();
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("bbb1");
        stringList.add("aaa1");
        stringList.add("bbb3");
        stringList.add("ccc");
        stringList.add("bbb2");
        stringList.add("ddd1");
    }

    @Test
    public void testFilterDemo() {
        stringList.stream().filter(s -> s.startsWith("a")).forEach(System.out::println);
    }

    @Test
    public void testSortedDemo() {
        stringList.stream().filter(s -> s.startsWith("a")).sorted().forEach(System.out::println);
        System.out.println("------");
        stringList.stream().sorted((a, b) -> a.compareTo(b)).forEach(System.out::println);
    }

    @Test
    public void testMapDemo() {
        //stringList.stream().map(m -> m.toUpperCase()).forEach(s -> System.out.println(s));
        stringList.stream().map(String::toUpperCase).forEach(System.out::println);
    }

    @Test
    public void testMatchDemo() {
        Assert.assertTrue(stringList.stream().anyMatch(s -> s.startsWith("a")));
        Assert.assertFalse(stringList.stream().allMatch(s -> s.startsWith("a")));
        Assert.assertTrue(stringList.stream().noneMatch(s -> s.startsWith("z")));
    }

    @Test
    public void testCountDemo() {
        Assert.assertEquals(3, stringList.stream().filter(s -> s.startsWith("b")).count());
    }

    @Test
    public void testSequentialSort() {
        int max = 10000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        long t0 = System.nanoTime();
        long count = values.stream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
    }

    @Test
    public void testParallelSort() {
        int max = 10000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        long t0 = System.nanoTime();
        long count = values.parallelStream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
    }

    @Test
    public void testRemoveListElement() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        //反例：用remove方法删除元素，会抛出ConcurrentModificationException
//        for (Integer i : list) {
//            if (i == 4) {
//                list.remove(i);
//            }
//        }

        //正例：
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i == 4) {
                iterator.remove();
            }
        }
        list.forEach(s -> System.out.println(s));
    }

    @Test
    public void testCAS() {
        AtomicInteger atomicInteger = new AtomicInteger(100);
        System.out.println(atomicInteger.compareAndSet(99, 103));
        System.out.println(atomicInteger);

        System.out.println(atomicInteger.compareAndSet(100, 103));
        System.out.println(atomicInteger);
    }
}
