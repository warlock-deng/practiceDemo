package leetcode;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * @author warlock.deng
 * Created at 2021/5/10
 */
public class LongestPalindrome {

    public static void main(String[] args) {

        String s = "babad";


    }

    private static String longestPalindrome(String s) {
        if ("".equals(s) || s == null) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        int len = s.length();
        int begin = 0;
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        for (int i = 1; i < len; i++) {

            for (int j = 0; j < len; j++) {
                //


            }

        }

        return "";
    }


}
