package javaobject.thread;

import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 * @author warlock.deng
 * Created at 2019/9/13
 */
public class ThreadDemo {

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

        deadLock();

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
