package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Warlock.deng
 * Created at 2019-09-03
 */
public class SortDemo {
    public static void main(String[] args) {

        int a = Integer.parseInt("2019");

        Map<String, Object> mapTem = new HashMap<>();

        Map<String, Object> map = new HashMap<>();
        map.put("a", 0);

        mapTem = map;

        map.put("b", 1);


        String c = "0";
        Integer[] tg = {50, 12, 65, 8, 23, 69, 99, 56, 65, 18, 12, 21, 2, 10, 7, 24};
        //testFastSort(tg);
        //testMaopao(tg);
        Integer[] mg = mergeSort(tg);

        String assss = "";
    }

    private static void testMaopao(Integer[] tg) {
        for (int i = 0; i < tg.length; i++) {
            for (int j = 0; j < tg.length; j++) {
                if (tg[i] < tg[j]) {
                    int tem = tg[i];
                    tg[i] = tg[j];
                    tg[j] = tem;
                }
            }
        }

        String a = "";
    }

    private static void testFastSort(Integer[] tg) {
        fastSort(tg, 0, tg.length - 1);

        String a = "";
    }

    /***
     * 快速排序
     * @param arr
     * @param begin
     * @param end
     */
    private static void fastSort(Integer[] arr, int begin, int end) {
        if (begin > end) {
            return;
        }
        int i = begin;
        int j = end;
        int k = arr[i];
        while (j > i) {
            while (j > i && arr[j] > k) {
                j--;
            }
            while (j > i && arr[i] <= k) {
                i++;
            }
            if (i < j) {
                int tem = arr[i];
                arr[i] = arr[j];
                arr[j] = tem;
            }
        }
        k = arr[i];
        arr[i] = arr[begin];
        arr[begin] = k;

        fastSort(arr, begin, i - 1);
        fastSort(arr, i + 1, end);
    }

    /**
     * 归并排序
     *
     * @param arr
     * @return
     */
    private static Integer[] mergeSort(Integer[] arr) {
        if (arr.length < 2) {
            return arr;
        }

        int mid = arr.length / 2;

        Integer[] left = Arrays.copyOfRange(arr, 0, mid);
        Integer[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return mergeSort(mergeSort(left), mergeSort(right));
    }

    private static Integer[] mergeSort(Integer[] left, Integer[] right) {
        Integer[] integers = new Integer[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < integers.length; index++) {
            if (i >= left.length) {
                integers[index] = right[j++];
            } else if (j >= right.length) {
                integers[index] = left[i++];
            } else if (left[i] > right[j]) {
                integers[index] = right[j++];
            } else {
                integers[index] = left[i++];
            }
        }

        return integers;
    }


}
