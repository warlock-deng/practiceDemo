package array;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Test2 {

    private static LinkedBlockingQueue<Node> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {

    }


    private static void level(Node root) {

        queue.add(root);
        while (!queue.isEmpty()) {
            Node curr = queue.peek();
            System.out.println(curr.value);
            queue.add(curr.left);
            queue.add(curr.right);
        }


    }

    class Node {

        private int value;

        private Node left;

        private Node right;


    }


}
