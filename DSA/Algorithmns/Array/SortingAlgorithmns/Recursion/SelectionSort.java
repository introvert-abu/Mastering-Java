package DSA.Algorithmns.Array.SortingAlgorithmns.Recursion;
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 4, 3, 7, 8, 2, 5 };
        selection(arr, arr.length - 1, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void selection(int[] arr, int r, int c, int max) {
        if (r == 0) return;
        if (r > c - 1) {
            if (arr[c] > arr[max]) {
                max = c;
            }
            selection(arr, r, ++c, max);
        } else {
            int temp = arr[r];
            arr[r] = arr[max];
            arr[max] = temp;
            selection(arr, --r, 0, 0);
        }
    }
}