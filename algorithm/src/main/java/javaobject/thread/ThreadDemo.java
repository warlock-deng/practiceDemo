package javaobject.thread;

import java.util.concurrent.FutureTask;

import static java.lang.Thread.*;

/**
 * @author warlock.deng
 * Created at 2019/9/13
 */
public class ThreadDemo {

    public static void main(String[] args) throws Exception {

        //  mainThreadWait();
        callable();
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
