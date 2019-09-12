package tree;

import java.util.Random;

/**
 * @author warlock.deng
 * Created at 2019/9/11
 */
public class BinaryTreeSet<E extends Comparable> implements Set<E> {

    private BinaryTree<E> binaryTree;

    public BinaryTreeSet() {
        binaryTree = new BinaryTree<>();
    }

    @Override
    public void add(E e) {
        binaryTree.add(e);
    }

    @Override
    public void remove(E e) {
        binaryTree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return binaryTree.contains(e);
    }

    @Override
    public int getSize() {
        return binaryTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return binaryTree.isEmpty();
    }

    @Override
    public String toString() {
        return binaryTree.toString();
    }

    public static void main(String[] args) {
        BinaryTreeSet<Integer> binaryTreeSet = new BinaryTreeSet<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int re = random.nextInt(10);
            binaryTreeSet.add(re);
        }

        System.out.println(binaryTreeSet);
    }

}
