package javaobject.thread;

import java.util.concurrent.Callable;

/**
 * @author warlock.deng
 * Created at 2019/9/13
 */
public class MyCallable implements Callable {

    @Override
    public Object call() throws Exception {
        String value = "test";
        System.out.println("ready to task");
        Thread.sleep(5000);
        System.out.println("task done");
        return value;
    }
}
