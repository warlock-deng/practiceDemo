package tree;

/**
 * @author warlock.deng
 * Created at 2019/9/10
 */
public class MainDemo {

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree=new BinaryTree<>();
        int[] nums = {6, 3, 8, 12, 2, 9, 45, 41, 67};
        for (int num : nums) {
            binaryTree.add(num);
        }

        binaryTree.preOrder();
    }


}
