package leetcode;

import java.time.Instant;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * f(0) = 1; 没有台阶时，1种就行
 * f(1) = 1; 一阶台阶时，1种就能到达
 * f(2) = 2; 二阶台阶时，[[1,1],[2]] 2种
 * f(n) = f(n-1) + f(n-2)
 *
 * @author warlock.deng
 * Created at 2021/3/17
 */
public class ClimbStairs {

    public static void main(String[] args) {
        long start = Instant.now().toEpochMilli();
        int a = climbStairs(42);
        long climbStairsEnd = Instant.now().toEpochMilli();
        System.out.println("climbStairs use time:" + (climbStairsEnd - start));
        int d = climbStairsDynamic(42);
        long climbStairsDynamicEnd = Instant.now().toEpochMilli();
        System.out.println("climbStairsDynamic use time:" + (climbStairsDynamicEnd - climbStairsEnd));
        String ssss = "";

    }

    private static int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    private static int climbStairsDynamic(int n) {
        int[] arr = new int[n + 1];

        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

}
