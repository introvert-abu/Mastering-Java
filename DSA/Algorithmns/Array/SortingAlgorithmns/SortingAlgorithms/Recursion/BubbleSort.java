package DSA.Algorithmns.Array.SortingAlgorithmns.SortingAlgorithms.Recursion;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 3, 5, 6, 8, 0, 2, 3, 5 };
        bubble(arr, arr.length - 1, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void bubble(int[] arr, int r, int c) {
        if (r == 0) return;
        if (r > c + 1) {
            if (arr[c] > arr[c+1]) {
                int temp = arr[c+1];
                arr[c+1] = arr[c];
                arr[c] = temp;
            }
            bubble(arr, r, ++c);
        } else {
            bubble(arr, --r, 0);            
        } 
    }
}
