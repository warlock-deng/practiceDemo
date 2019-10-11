package javaobject;


/**
 * @author Warlock.deng
 * Created at 2019-09-05
 */
public class NumberDemo {


    private static void parseInt(String s) {
        char[] chars = s.toCharArray();
        int radix = 10;
        int result = 0;
        for (char c : chars) {
            int digit = Character.digit(c, radix);
            result *= radix;
            result += digit;
        }

        String a = String.valueOf(result);
    }


    private static void Fibonacci() {


//        for (int i = 1; i < 20; i++) {
//            int res = Fibonacci(i);
//            System.out.println(res);
//        }
    }

    /**
     * 递归实现斐波那契数列
     *
     * @param n 数
     * @return 结果
     */
    private static int fibonacci(int n) {
        count++;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (arr[n] == null) {
            arr[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }
        return arr[n];
    }

    /**
     * 非递归实现
     *
     * @param n 数
     * @return 结果
     */
    private static int fibonaccib(int n) {
        int res = 1;
        int first = 1;
        int two = 1;
        while (n > 2) {
            res = first + two;
            first = two;
            two = res;
            n--;
        }
        return res;
    }

    private static Integer[] arr;

    private static int count = 0;

    public static void main(String[] args) {

        long s = 499999999L * 499999999;

//        parseInt("2019");
//
//        // Fibonacci();
//
//        Integer.parseInt("2019");

//        int b1 = 10;
//        int b2 = 20;
//
//        int b11 = b1++;
//
//        int b22 = ++b2;
//
//        System.out.println(b11);
//        System.out.println(b22);
//
//        long t = 12007036;
//
//        long t1 = t % 20;
//
//        String str = String.valueOf(t);
//        int a = str.hashCode();
//        int a1 = Math.abs(a) >> 5;
//
//        int t2 = a1 % 20;

        int n = 40;
        arr = new Integer[n + 1];

        int result = fibonacci(n);
        System.out.println(count);
        System.out.println(result);
        String test = "";
    }
}
