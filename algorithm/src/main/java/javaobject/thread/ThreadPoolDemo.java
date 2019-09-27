package javaobject.thread;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author Warlock.deng
 * Created at 2019-09-27
 */
public class ThreadPoolDemo {

    private static final int clientTotal = 5000;

    private static final int threadTotal = 200;

    private static int count = 0;

    private static AtomicInteger count1 = new AtomicInteger();

    private static LongAdder count2 = new LongAdder();

    private static AtomicReference<Integer> count3 = new AtomicReference<>(0);

    private static AtomicIntegerFieldUpdater<ThreadPoolDemo> updater = AtomicIntegerFieldUpdater.newUpdater(ThreadPoolDemo.class, "count4");

    public volatile int count4 = 0;


    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        //System.out.println(count1.get());
        System.out.println(count2);



    }

    private static void add() {
        //count1.incrementAndGet();
        count2.increment();
    }


}
