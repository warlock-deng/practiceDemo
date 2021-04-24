package javaobject.thread;


import java.util.concurrent.*;

/**
 * @author Warlock.deng
 * Created at 2019-09-29
 */
public class FutureDemo {

    static class FutureCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("do in ");
            Thread.sleep(5000);
            return "Down";
        }
    }

    private static void futureTest() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new FutureCallable());

        Thread.sleep(1000);
        String result = future.get();
        System.out.println(result);
        executorService.shutdown();
    }

    private static void futureTask() throws Exception {
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("do in ");
                Thread.sleep(5000);
                return "Down";
            }
        });
        new Thread(futureTask).start();
        Thread.sleep(1000);
        String result = futureTask.get();
        System.out.println(result);
    }


    static class ForkJoinTaskDemo extends RecursiveTask<Integer> {

        public static final int threshold = 2;

        private int start;

        private int end;

        public ForkJoinTaskDemo(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public ForkJoinTaskDemo() {
            super();
        }

        @Override
        protected Integer compute() {
            int sum = 0;

            boolean isCompute = (end - start) <= threshold;
            if (isCompute) {
                for (int i = start; i <= end; i++) {
                    sum += i;
                }
            } else {
                int middle = (start + end) / 2;
                ForkJoinTaskDemo leftTask = new ForkJoinTaskDemo(start, middle);
                ForkJoinTaskDemo rightTask = new ForkJoinTaskDemo(middle + 1, end);
                leftTask.fork();
                rightTask.fork();

                int leftResult = leftTask.join();
                int rightResult = rightTask.join();

                sum = leftResult + rightResult;
            }
            return sum;
        }
    }


    public static void main(String[] args) throws Exception {
        //futureTest();

        ForkJoinTaskDemo forkJoinTaskDemo = new ForkJoinTaskDemo(1, 100);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future<Integer> future = forkJoinPool.submit(forkJoinTaskDemo);

        int result = future.get();
        System.out.println(result);

    }
}
