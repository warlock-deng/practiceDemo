package search;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Warlock.deng
 * Created at 2019-09-03
 */
public class SearchDemo {

    public static void main(String[] args) {
        Integer[] tg = {50, 12, 65, 8, 23, 69, 99, 56, 65, 18, 12, 21, 2, 10, 7, 24};
        //testMaopao(tg);
        List<Integer> list = Arrays.stream(tg).collect(Collectors.toList());
        Collections.sort(list);

        twoPointsSearch(list.toArray(new Integer[list.size()]), 2);
    }

    private static void twoPointsSearch(Integer[] tg, int s) {
        int low = 0;
        int hight = tg.length - 1;
        int mid = 0;
        while (low <= hight) {
            mid = (low + hight) / 2;
            if (tg[mid] < s) {
                low = mid + 1;
            }
            if (tg[mid] > s) {
                hight = mid - 1;
            }

            if (tg[mid] == s) {
                break;
            }
        }
        int result = tg[mid];

    }

}
