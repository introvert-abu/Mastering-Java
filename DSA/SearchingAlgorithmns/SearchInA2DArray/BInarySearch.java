package SearchInA2DArray;
import java.util.Arrays;

public class BInarySearch {
    public static void main(String[] args) {
        int[][] arr = {
                { 10, 18, 30},
                { 15, 26, 37},
                { 19, 30, 41}
        };
        int target = 18;
        System.out.println(Arrays.toString(search(arr, target)));
    }

    static int[] search(int[][] matrix, int target) {
        int row = 0;
        int col = matrix.length - 1;
        while (row < matrix.length && col >=0) {
            if (matrix[row][col] == target) {
                return new int[] { row, col };
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return new int[] { -1, -1 };
    }
}
