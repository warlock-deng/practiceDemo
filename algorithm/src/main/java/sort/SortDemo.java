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
        Integer[] integers = {1, 2, 4, 4, 5};
        int inde = binarySearch(integers, 5);
        //testFastSort(tg);
        //testMaopao(tg);
        //Integer[] mg = mergeSort(tg);

        //chageSort(tg);

        changeSortRecursion(tg, 0);
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

    private static int binarySearch(Integer[] tg, int v) {
        int left = 0;
        int right = tg.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (tg[mid] == v) {
                return mid;
            }

            if (tg[mid] < v) {
                left = mid + 1;
            }
            if (tg[mid] > v) {
                right = mid - 1;
            }

        }
        return tg.length + 1;
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

    private static void chageSort(Integer[] data) {
        for (int i = 0; i < data.length; i++) {
            Integer resultIndex = changeSort(data, i);
            if (resultIndex > -1 && resultIndex < data.length) {
                swap(data, resultIndex, i);
            }
        }

    }

    private static void changeSortRecursion(Integer[] data, int index) {
        if (index > data.length - 1) {
            return;
        }

        int resultIndex = -1;
        Integer head = data[index];
        for (int i = index + 1; i < data.length; i++) {
            if (head > data[i]) {
                head = data[i];
                resultIndex = i;
            }
        }
        if (resultIndex > -1 && resultIndex < data.length) {
            swap(data, index, resultIndex);
        }
        index++;
        changeSortRecursion(data, index);
    }

    private static Integer changeSort(Integer[] data, int index) {
        Integer start = data[index];
        Integer resultIndex = -1;
        for (int i = index + 1; i < data.length; i++) {
            if (data[i] < start) {
                resultIndex = i;
                start = data[i];
            }
        }
        return resultIndex;
    }

    private static void swap(Integer[] data, int index1, int index2) {
        Integer t = data[index1];
        data[index1] = data[index2];
        data[index2] = t;
    }

}
