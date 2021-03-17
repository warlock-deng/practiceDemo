package algorithm;

import java.util.ArrayList;
import java.util.List;

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


    }


    private static List<String> letterCombinations(String number) {
        char[] numbers = number.toCharArray();


        return null;
    }


}
