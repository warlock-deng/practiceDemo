package javaobject.thread;

/**
 * @author warlock.deng
 * Created at 2019/9/13
 */
public class MyThread implements Runnable {

    private String name;

    private String value;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread name:" + name);
        this.value = "thread name is runed:" + name;
    }

    public String getValue() {
        return this.value;
    }
}
