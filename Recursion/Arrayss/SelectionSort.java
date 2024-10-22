package Recursion.Arrayss;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        selectionSort(arr, 0, arr.length, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr, int r, int c, int max) {
        if (c == 1) {
            return;
        }

        if (r < c) {
            if (arr[r] > arr[max]) {
                selectionSort(arr, r+1, c, r);
            } else {
                selectionSort(arr, r+1, c, max);
            }
        } else {
            int temp = arr[max];
            arr[max] = arr[r - 1];
            arr[r - 1] = temp;
            selectionSort(arr, 0, c-1, 0);
        }
    }

    static void sS(int[] arr, int r) {
        if (r == 0) {
            return;
        }

        int index = largestElement(arr, 0, r, arr[r], r);
        int temp = arr[r];
        arr[r] = arr[index];
        arr[index] = temp;
        sS(arr, r - 1);
    }

    static int largestElement(int[] arr, int i, int last, int max, int maxIndex) {
        if (i == last) {
            return maxIndex;
        }

        if (arr[i] > max) {
            max = arr[i];
            maxIndex = i;
        }

        return largestElement(arr, ++i, last, max, maxIndex);
    }
}