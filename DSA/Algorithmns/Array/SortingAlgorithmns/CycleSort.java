package DSA.Algorithmns.Array.SortingAlgorithmns;

import java.util.Arrays;

public class CycleSort {
    public static void main(String[] args) {
        int[] arr = { 2, 2, 1, 1, 1, 2, 2 };
        cycle(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void cycle(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] == arr[correctIndex]) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            }
        }
    }
}
