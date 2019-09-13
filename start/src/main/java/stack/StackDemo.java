package stack;


/**
 * @author warlock.deng
 * Created at 2019/9/8
 */
public class StackDemo {

    public static void main(String[] args) {


        Queue<Integer> loopQueue = new LoopQueue<>(4);

        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);

            if (i % 3 == 2) {
                loopQueue.dequeue();
                System.out.println(loopQueue);
            }
        }


        Array array = new Array<Integer>();

        for (Integer i = 1; i < array.getCapacity(); i++) {
            array.addLast(i);
        }

        System.out.println(array.toString());

        array.addLast(30);
        System.out.println(array.toString());

        array.addLast(34);
        System.out.println(array.toString());

        array.removeLast();
        System.out.println(array.toString());


        Stack<Integer> stack = new ArrayStack<>(5);
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);

        Queue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }

    }


}
