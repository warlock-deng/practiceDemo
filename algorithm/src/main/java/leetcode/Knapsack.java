package leetcode;

/**
 * 0-1背包问题
 * 有一个背包，它的容量为c,现在有n种不同的物品，
 * 编号为0，1，...n-1,其中每一件物品的重量为w(i)，价值为v(i)。
 * 问可以向这个背包中放哪些物品，使得在不超过背包容量的基础上，物品的总价值最大
 *
 * <p>
 * 状态定义：f(n,c) 考虑将n个物品放进容量为C的背包，使得价值最大；
 * f(i,c) = f(i-1,c) 或者  f(i,c) = v(i) +f(i-1,c-w(i)) 中取最大值，
 * <p>
 * <p>
 * 状态转移方程：
 * <p>
 * 即：f(i,c) = max(f(i-1,c),v(i)+f(i-1,c-w(i)))
 *
 * @author warlock.deng
 * Created at 2021/3/19
 */
public class Knapsack {

    public static void main(String[] args) {
        int n = 10;
        int c = 20;
        memo = new int[n][c + 1];

    }


    private static int knapsack(int[] value, int[] weight, int c, int index) {
        if (index < 0 || c < 1) {
            return 0;
        }

        int res = knapsack(value, weight, c, index - 1);
        if (c >= weight[index]) {
            res = Math.max(res, (value[index] + knapsack(value, weight, c - weight[index], index - 1)));
        }
        return res;
    }

    private static int[][] memo;

    private static int knapsackMemo(int[] value, int[] weight, int c, int index) {
        if (index < 0 || c < 1) {
            return 0;
        }

        if (memo[index][c] != 0) {
            return memo[index][c];
        }

        int res = knapsack(value, weight, c, index - 1);
        if (c >= weight[index]) {
            res = Math.max(res, (value[index] + knapsack(value, weight, c - weight[index], index - 1)));
            memo[index][c] = res;
        }
        return res;
    }

    private static int dynamicProgramming(int[] value, int[] weight, int c) {
        int[][] memo = new int[c][value.length + 1];

        return 0;
    }

}
