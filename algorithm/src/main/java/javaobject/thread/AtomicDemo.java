package javaobject.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author Warlock.deng
 * Created at 2019-09-27
 */
public class AtomicDemo {

    //解决cas aba问题; 添加了版本号
    private AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(0, 0);

    private static final int clientTotal = 5000;

    private static final int threadTotal = 200;

    private AtomicBoolean close = new AtomicBoolean(false);

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();

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


    }


}
