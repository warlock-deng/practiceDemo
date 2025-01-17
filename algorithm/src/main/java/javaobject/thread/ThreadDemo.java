package javaobject.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * @author warlock.deng
 * Created at 2019/9/13
 */
public class ThreadDemo {

    private static int state = 0;

    public static void main(String[] args) throws Exception {

        //  mainThreadWait();
        //callable();
//        threadPoll();
//
//        StringBuilder stringBuilder = new StringBuilder();
//
//        StringBuffer stringBuffer = new StringBuffer();

        String a1 = "a1";
        String a2 = "a2";
        String a3 = "a3";

        String a4 = a1 + a2;
        String a5 = a3 + "a5";

        //deadLock();


        Semaphore semaphore = new Semaphore(10);

        AtomicBoolean atomicBoolean = new AtomicBoolean();

        ReentrantLock reentrantLock = new ReentrantLock(true);
        int count = 60;
        Thread thread1 = new Thread(() -> {
            while (state < count) {
               // reentrantLock.lock();
                synchronized (a1) {
                    if (state % 3 == 0) {
                        System.out.println("a");
                        state++;
                    }
                }
               // reentrantLock.unlock();
            }
        });

        Thread thread2 = new Thread(() -> {
            while (state < count) {
                //reentrantLock.lock();
                synchronized (a1) {
                    if (state % 3 == 1) {
                        System.out.println("b");
                        state++;
                    }
                }
                //reentrantLock.unlock();
            }
        });

        Thread thread3 = new Thread(() -> {
            while (state < count) {
                //reentrantLock.lock();
                synchronized (a1) {
                    if (state % 3 == 2) {
                        System.out.println("c");
                        state++;
                    }
                }
                //reentrantLock.unlock();
            }
        });


        thread1.start();
        thread2.start();
        thread3.start();




        ExecutorService executorService = Executors.newCachedThreadPool();

        ThreadLocal<String> threadLocal = new ThreadLocal<>();


    }

    private static void deadLock() {
        Thread thread1 = new Thread(new DeadLockDemo(true));
        Thread thread2 = new Thread(new DeadLockDemo(false));

        thread1.start();
        thread2.start();
    }

    private static void threadPoll() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallable());

        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);

        //AbstractQueuedSynchronizer abstractQueuedSynchronizer = new ReentrantLock();
        //AbstractQueuedLongSynchronizer

        String result = future.get();

        System.out.println(result);


        executorService.shutdown();
    }

    private static void callable() throws Exception {
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        new Thread(futureTask).start();

        String task = futureTask.get();
        System.out.println(task);

    }

    private static void mainThreadWait() throws Exception {
        MyThread myThread = new MyThread("thread1");
        Thread thread = new Thread(myThread);
        thread.start();
        while (myThread.getValue() == null) {
            sleep(100);
        }
        System.out.println(myThread.getValue());
        System.out.println("finish");
    }


}
