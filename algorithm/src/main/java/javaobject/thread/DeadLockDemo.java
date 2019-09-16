package javaobject.thread;


/**
 * @author warlock.deng
 * Created at 2019/9/16
 */
public class DeadLockDemo implements Runnable {

    private static Object object1 = new Object();
    private static Object object2 = new Object();

    private boolean flag = false;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        String threaName = Thread.currentThread().getName();
        System.out.println(threaName + " is runing");
        if (flag) {
            synchronized (object1) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("lock object1,thread name:" + threaName);

                synchronized (object2) {
                    String threaName2 = Thread.currentThread().getName();
                    System.out.println("lock object2,thread name:" + threaName2);

                }
            }
        } else {
            synchronized (object2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("lock object2,thread name:" + threaName);
                synchronized (object1) {
                    String threaName2 = Thread.currentThread().getName();
                    System.out.println("lock object1,thread name:" + threaName2);

                }
            }
        }


    }
}

