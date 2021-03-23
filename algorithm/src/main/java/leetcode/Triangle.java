package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/triangle/
 * 给定一个三角形的数字阵列，选择一条自顶向下的路径，使得沿途的所有数字之和最小。（第一步只能移动到相邻的格子中）
 * 如下所示的三解形阵列，其最小路径和为11 (2+3+5+1)
 * [
 * *****[2],
 * ****[3,4]
 * ***[6,5,7]
 * **[4,1,8,3]
 * ]
 * <p>
 * f[0][0] = c[0][0];
 * f[1][0] = f[0][0] + c[1][0]
 * f[1][1] = f[0][0] + c[1][1]
 *
 * @author warlock.deng
 * Created at 2021/3/17
 */
public class Triangle {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>() {{
            add(
                    new ArrayList<Integer>() {{
                        add(2);
                    }});
            add(
                    new ArrayList<Integer>() {{
                        add(3);
                        add(4);
                    }});
            add(
                    new ArrayList<Integer>() {{
                        add(6);
                        add(5);
                        add(7);
                    }});
            add(
                    new ArrayList<Integer>() {{
                        add(4);
                        add(1);
                        add(8);
                        add(3);
                    }});
        }};


        Integer result = breadthFirstResult(triangle);

        String a = "";
    }

    private static int triangle(List<List<Integer>> triangle) {

        return 0;
    }

    private static Integer breadthFirstResult(List<List<Integer>> triangle) {
        List<Integer> listResult = new ArrayList<>();
        for (List<Integer> list : triangle) {
            List<Integer> term = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Integer integer = list.get(i);
                if (listResult.size() > 0) {
                    for (int j = 0; j < listResult.size(); j++) {
                        if ((i - j) == 0 || (i - j) == 1) {
                            Integer r = listResult.get(j);
                            Integer rs = r + integer;
                            term.add(rs);
                        }
                    }
                } else {
                    term.add(integer);
                }
            }
            listResult = term;
        }

        return listResult.get(0);
    }

    private static Map<String, Integer> breadthFirst(List<List<Integer>> triangle) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> listResult = new ArrayList<>();
        for (List<Integer> list : triangle) {
            List<Integer> term = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Integer integer = list.get(i);
                if (listResult.size() >= i) {
                    for (int j = 0; j < listResult.size(); j++) {
                        if (i == j || i == j + 1) {
                            Integer r = listResult.get(j);
                            Integer rs = r + integer;
                            term.add(rs);
                        }
                    }
                } else {
                    map.put(integer + "->", integer);
                    term.add(integer);
                }
            }
            listResult = term;
        }
        return map;
    }


}
