package javaobject.thread;

import java.time.Instant;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Warlock.deng
 * Created at 2019-09-29
 */
public class AqsDemo {

    public static final int threadCount = 200;

    private static int count = 0;

    public static void main(String[] args) throws Exception {

        reenTrantLock1();


        //cyclicBarrier1();
        //seamPhore2();
        //countDownLatch2();
    }

    private final static Lock reentrantLock = new ReentrantLock();

    private static void reenTrantLock1() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            executorService.execute(() -> {
                try {
                    add();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }

            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(count);
    }

    private static void add() {
        reentrantLock.lock();
        try {
            count++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }


    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    private static void cyclicBarrier1() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Thread.sleep(1000);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            executorService.execute(() -> {
                try {
                    cycleTest(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                }
            });
        }
        System.out.println("finish");
        executorService.shutdown();
    }

    private static void cycleTest(int threadNum) throws Exception {
        Thread.sleep(1000);
        System.out.println(threadNum + " is read");
        cyclicBarrier.await();
        System.out.println(threadNum + " is continue");
    }

    private static void seamPhore2() {

        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            executorService.execute(() -> {
                try {
                    if (semaphore.tryAcquire()) {
                        test(threadNum);
                        semaphore.release();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                }

            });
        }
        System.out.println("finish");
        executorService.shutdown();
    }

    private static void seamPhore1() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    test(threadNum);
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                }

            });
        }
        System.out.println("finish");
        executorService.shutdown();
    }

    private static void countDownLatch2() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            executorService.execute(() -> {
                try {
                    test(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await(1, TimeUnit.SECONDS);
        System.out.println("finish");
        executorService.shutdown();
    }

    private static void countDownLatch1() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            executorService.execute(() -> {
                try {
                    test(threadNum);
                } catch (Exception e) {

                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        System.out.println("finish");
        executorService.shutdown();
    }

    private static void test(int theadNum) throws Exception {
        Thread.sleep(1000);
        System.out.println(Instant.now() + ":" + theadNum);
        //Thread.sleep(1000);
    }

}
