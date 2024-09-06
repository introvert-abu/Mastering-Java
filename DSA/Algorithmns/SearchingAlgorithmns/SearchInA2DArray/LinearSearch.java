package SearchInA2DArray;
import java.util.Arrays;

public class LinearSearch {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int target = 5;
        for (int col = 0; col < arr.length; col++) {
            for (int row = 0; row < arr[col].length; row++) {
                if (arr[row][col]==target){
                    System.out.println(Arrays.toString(new int[]{row,col}));
                    break;
                }
            }
        }
    }
}
