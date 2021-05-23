package javaobject.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author warlock.deng
 * Created at 2021/5/13
 */
public class LoopABC implements Runnable {

    private static int count = 0;

    private Object lock = new Object();

    private static ReentrantLock reentrantLock;



    @Override
    public void run() {
        while (count < 10) {
            try {
                switch (count % 3) {
                    case 0:
                        System.out.println("a");
                        break;
                    case 1:
                        System.out.println("b");
                        break;
                    case 2:
                        System.out.println("c");
                        break;
                }
                count++;
            } finally {

            }
        }
    }
}


