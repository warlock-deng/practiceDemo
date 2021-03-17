package algorithm;


import java.time.Instant;

/**
 * 斐波那契数列
 * <p>
 * f(0) = 0;
 * f(1) =1;
 * f(n) = f(n-1) + f(n-2)  (n>1)
 * </p>
 *
 * @author warlock.deng
 * Created at 2021/3/16
 */
public class Fibonacci {

    public static void main(String[] args) {
        long start = Instant.now().toEpochMilli();
        long s = loop(42);
        long loopEnd = Instant.now().toEpochMilli();
        System.out.println("loop use time:" + (loopEnd - start));
        long ss = recursion(42);
        long recursionEnd = Instant.now().toEpochMilli();
        System.out.println("recursionEnd use time:" + (recursionEnd - loopEnd));

        arr = new Long[43];
        long s3 = recursionUpgrade(42);
        long recursionUpgrade = Instant.now().toEpochMilli();
        System.out.println("recursionUpgrade use time:" + (recursionUpgrade - recursionEnd));

        long s4 = dynamicProgramming(42);
        long dynamicProgramming = Instant.now().toEpochMilli();
        System.out.println("dynamicProgramming use time:" + (dynamicProgramming - recursionUpgrade));

        String aaa = "";
    }

    /**
     * 循环版本
     *
     * @param n 0
     * @return 0
     */
    private static long loop(int n) {

        long first = 0;
        long second = 1;
        if (n == 0) {
            return first;
        }
        if (n == 1) {
            return second;
        }
        long result = 0;
        for (int i = 2; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }

    /**
     * 递归版本（自上而下）
     *
     * @param n 0
     * @return 0
     */
    private static long recursion(int n) {
        if (n == 0) {
            return 0L;
        }
        if (n == 1) {
            return 1L;
        }
        return recursion(n - 1) + recursion(n - 2);
    }


    private static Long[] arr;

    /**
     * 递归升级版
     *
     * @param n 0
     * @return 0
     */
    private static long recursionUpgrade(int n) {
        if (n == 0) {
            return 0L;
        }
        if (n == 1) {
            return 1L;
        }

        Long result = arr[n];
        if (result == null) {
            arr[n] = recursionUpgrade(n - 1) + recursionUpgrade(n - 2);
        }
        return arr[n];
    }

    /**
     * 动态规划版本(自下而上)
     *
     * @param n 0
     * @return 0
     */
    private static long dynamicProgramming(int n) {
        Long[] resultArr = new Long[n + 1];
        resultArr[0] = 0L;
        resultArr[1] = 1L;
        for (int i = 2; i <= n; i++) {
            resultArr[i] = resultArr[i - 1] + resultArr[i - 2];
        }
        return resultArr[n];
    }

}
