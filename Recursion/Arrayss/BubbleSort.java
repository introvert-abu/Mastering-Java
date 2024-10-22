package Recursion.Arrayss;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        bS(arr, arr.length - 1, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void bS(int[] arr, int r, int c) {
        if (c == arr.length-1) {
            return;
        }

        if (r > c) {
            if (arr[r - 1] > arr[r]) {
                int temp = arr[r - 1];
                arr[r - 1] = arr[r];
                arr[r] = temp;
            }
            bS(arr, r - 1, c);            
        } else {
            bS(arr, arr.length-1, c+1);
        }
    }
}
