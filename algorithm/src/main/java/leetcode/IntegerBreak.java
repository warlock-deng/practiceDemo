package leetcode;


import java.time.Instant;

/**
 * https://leetcode-cn.com/problems/integer-break/
 * <p>
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * </p>
 *
 *
 * 状态定义：
 * f(1) = 1;
 * f(2) = 1;
 * f(3) = 2
 *
 * f(n):考虑将n拆分为i个数，且乘积最大
 * f(n) = 1 * f(n-1) | 2 * f(n-2) | 3 * f(n-3) | ... | (n-1) * f(1)
 *
 * 状态转移方程：
 * f(n) = max()
 *
 *
 * @author warlock.deng
 * Created at 2021/3/19
 */
public class IntegerBreak {

    public static void main(String[] args) {
        int n = 30;
        long start = Instant.now().toEpochMilli();
        int result = integerBreak(n);
        long integerBreakEnd = Instant.now().toEpochMilli();
        System.out.println("integerBreak use time:" + (integerBreakEnd - start));

        int result1 = integerBreakMemory(n, new int[n + 1]);
        long integerBreakMemoryEnd = Instant.now().toEpochMilli();
        System.out.println("integerBreakMemory use time:" + (integerBreakMemoryEnd - integerBreakEnd));

        int result2 = dynamicProgramming(n);
        long dynamicProgrammingEnd = Instant.now().toEpochMilli();
        System.out.println("dynamicProgramming use time:" + (dynamicProgrammingEnd - integerBreakMemoryEnd));

        String test = "";
    }


    private static int integerBreak(int n) {
        if (n == 1) {
            return 1;
        }

        int result = -1;
        for (int i = 1; i < n; i++) {
            result = Math.max((i * (n - i)), Math.max(result, i * integerBreak(n - i)));
        }

        return result;
    }


    private static int integerBreakMemory(int n, int[] memo) {
        if (n == 1) {
            return 1;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        int result = -1;
        for (int i = 1; i < n; i++) {
            result = Math.max((i * (n - i)), Math.max(result, i * integerBreakMemory(n - i, memo)));
        }

        memo[n] = result;
        return result;
    }

    private static int dynamicProgramming(int n) {
        if (n < 2) {
            return 1;
        }

        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                //将数字i分解成j + (i-j) 两部分；或者分解成 j  *  {(i-j)再次分解} 两部分
                memo[i] = Math.max(memo[i], Math.max((j * (i - j)), j * memo[i - j]));
            }

        }

        return memo[n];
    }

}
