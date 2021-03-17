package tree;

import javax.swing.border.EtchedBorder;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author Warlock.deng
 * Created at 2019-09-04
 */
public class BinaryDemo {
    public static void main(String[] args) {
        Integer[] tg = {50, 12, 65, 8, 23, 69, 99, 56, 65, 18, 12, 21, 2, 10, 7, 24};
        List<Integer> list = Arrays.stream(tg).collect(Collectors.toList());
        Collections.sort(list);


    }

    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            String[] strings = s1.split("");
            for (int i = 0; i < strings.length; i++) {
                if (!s2.contains(strings[i])) {
                    return false;
                }
            }
            return true;
        }
    }

}
