package array;

public class Test1 {

    public static void main(String[] args) {
        int[] arr = {1,3,5,6,6,6,6};
        System.out.println(getIndex(arr,6));
    }


    private static int getIndex(int[] arr,int target ){
        int size = arr.length-1;
        int left = 0;
        int right =size;
        while (left<=right){
            int mid = (left+right) /2;
            if(arr[mid] > target){
                right=mid-1;
            }

            if(arr[mid] < target){
                left = mid+1;
            }

            if(arr[mid] == target){
                while (mid<= size){
                    if(mid==size){
                        return mid;
                    }
                    if(arr[mid] ==arr[mid+1]){
                        mid = mid+1;
                    }else {
                        return mid;
                    }
                }
            }
        }
        return -1;
    }

}
