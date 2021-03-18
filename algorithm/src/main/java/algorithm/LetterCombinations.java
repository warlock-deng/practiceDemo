package algorithm;


import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;


/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * <p>
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 2:a,b,c
 * 3:d,e,f
 * 4:g,h,i
 * 5:j,k,l
 * 6:m,n,o
 * 7:p,q,r,s
 * 8:t,u,v
 * 9:w,x,y,z
 *
 * @author warlock.deng
 * Created at 2021/3/17
 */
public class LetterCombinations {

    private static List<String[]> digitsLetter = new ArrayList<String[]>() {{
        add(new String[]{});
        add(new String[]{});
        add(new String[]{"a", "b", "c"});
        add(new String[]{"d", "e", "f"});
        add(new String[]{"g", "h", "i"});
        add(new String[]{"j", "k", "l"});
        add(new String[]{"m", "n", "o"});
        add(new String[]{"p", "q", "r", "s"});
        add(new String[]{"t", "u", "v"});
        add(new String[]{"w", "x", "y", "z"});
    }};

    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        String test = "2545";
        List<String> result = new ArrayList<>();
        backtrack(result, 0, test, new StringBuilder());

        List<String> resultQueue = list(test);

        String teseet = "";
    }


    /**
     * 回溯法；深度优化算法
     *
     * @param result        存放结果
     * @param index         索引
     * @param letter        字符串
     * @param stringBuilder 合并的数据
     */
    private static void backtrack(List<String> result, int index, String letter, StringBuilder stringBuilder) {
        if (index == letter.length()) {
            result.add(stringBuilder.toString());
            return;
        }

        int nb = Character.digit(letter.charAt(index), 10);
        String[] letters = digitsLetter.get(nb);
        for (String s : letters) {
            stringBuilder.append(s);
            backtrack(result, index + 1, letter, stringBuilder);
            stringBuilder.deleteCharAt(index);
        }

    }

    /**
     * 广度优化算法
     *
     * @param digits 字符串
     * @return 列表
     */
    private static List<String> list(String digits) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            int nb = Character.digit(digits.charAt(i), 10);
            String[] letters = digitsLetter.get(nb);
            List<String> result = new ArrayList<>();
            for (String s : letters) {
                if (res.size() > 0) {
                    for (String s1 : res) {
                        String t = s1 + s;
                        result.add(t);
                    }
                } else {
                    result.add(s);
                }
            }
            res = result;
        }

        return res;
    }


}
