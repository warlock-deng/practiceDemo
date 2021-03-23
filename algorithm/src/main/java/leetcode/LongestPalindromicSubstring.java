package leetcode;

import java.util.List;

/**
 * 最长回字文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * f(i)  =  s
 *
 * @author warlock.deng
 * Created at 2021/3/22
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {

    }

    public static void palindromicSubstring(List<String> result, String str, int index, StringBuilder stringBuilder) {
        if (index == 0 || index == (str.length() - 1)) {
            result.add(stringBuilder.toString());
        }


        for (int i = index + 1; i < str.length(); i++) {
            int preIndex = 2 * index - i;
            if (str.charAt(i) == str.charAt(preIndex)){
                String rs = str.charAt(preIndex)+"" + str.charAt(index) + str.charAt(i);

            }
        }
    }

}
