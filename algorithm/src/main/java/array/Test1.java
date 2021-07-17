package array;

/**
 * @author warlock.deng
 * Created at 2021/6/1
 */
public class Test1 {


    public static void main(String[] args) {

        int[] arr = {10, 23, 45, 56, 90, 2323, 1, 4, 5};
        System.out.println(get(arr, 23));
        System.out.println(get(arr, 9999));
        System.out.println(get(arr, 1));
    }

    private static int get(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == arr[mid]) {
                return mid;
            }

            if (target > arr[mid] ) {
                if (arr[mid] < arr[right]) {
                    left = mid + 1;
                } else {

                }
            }

            if (target < arr[mid] && arr[left] < arr[mid]) {



                right = mid - 1;
            }else{

            }


            return -1;
        }


    }
