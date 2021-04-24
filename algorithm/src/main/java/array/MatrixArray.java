package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 螺旋矩阵
 *
 * @author warlock.deng
 * Created at 2021/4/23
 */
public class MatrixArray {

    public static void main(String[] args) {
        int[][] matrix = new int[1][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        //matrix[0][3] = 4;

//        matrix[1][0] = 5;
//        matrix[1][1] = 6;
//        matrix[1][2] = 7;
//        // matrix[1][3] = 8;
//
//        matrix[2][0] = 9;
//        matrix[2][1] = 10;
//        matrix[2][2] = 11;
        //matrix[2][3] = 12;

        List<Integer> list = matrix(matrix);

        String test = "";
    }

    private static List<Integer> matrix(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        ArrayList<Integer> list = new ArrayList<>(rows * columns);
        int left = 0;
        int right = columns - 1;
        int top = 0;
        int bottom = rows - 1;
        while (left <= right && top <= bottom) {

            for (int column = left; column <= right; column++) {
                list.add(matrix[top][column]);
            }

            for (int row = top + 1; row <= bottom; row++) {
                list.add(matrix[row][right]);
            }

            if (left < right && top < bottom) {

                for (int column = right - 1; column > left; column--) {
                    list.add(matrix[bottom][column]);
                }

                for (int row = bottom; row > top; row--) {
                    list.add(matrix[row][left]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }

        return list;
    }

    private static List<Integer> matrix1(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;

        List<Integer> list = new ArrayList<>(rows * columns);
        int top = 0, left = 0, right = columns - 1, bottom = rows - 1;

        while (left <= right && top <= bottom) {

            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if (right == left || bottom == top) {
                break;
            }
            for (int i = right; i >= left; i--) {
                list.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }


}
