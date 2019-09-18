package javaobject.thread;

import stack.LinkedListQueue;
import stack.Queue;

import java.util.Random;

/**
 * 消费者，生产者代码
 *
 * @author Warlock.deng
 * Created at 2019-09-18
 */
public class ProducerConsumerDemo {

    private static final int DEFAULT_LINK_SIZE = 10;

    private Queue<Integer> queue = new LinkedListQueue<>();

    private class Producer extends Thread {

        @Override
        public void run() {
            send();
        }

        private void send() {
            while (true) {
                synchronized (queue) {
                    if (queue.getSize() == DEFAULT_LINK_SIZE) {
                        queue.notify();

                        try {
                            queue.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    Random random = new Random();
                    int test = random.nextInt();
                    queue.enqueue(test);
                    System.out.println("生产了一条消息：" + test);
                    queue.notify();

                    try {
                        Thread.sleep(700);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    private class Consumer extends Thread {

        @Override
        public void run() {
            consumer();
        }

        private void consumer() {
            while (true) {
                synchronized (queue) {
                    if (queue.getSize() == 0) {
                        queue.notify();
                        try {
                            queue.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    Integer i = queue.dequeue();
                    System.out.println("消费了一条消息：" + i);
                    queue.notify();

                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }


    public static void main(String[] args) {
        ProducerConsumerDemo producerConsumerDemo = new ProducerConsumerDemo();
        Producer producer = producerConsumerDemo.new Producer();
        Consumer consumer = producerConsumerDemo.new Consumer();

        producer.start();
        consumer.start();
    }


}
