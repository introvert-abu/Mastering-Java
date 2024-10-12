package DSA.DataStructures.ArraysAndArrayList.Problems;

import java.util.Arrays;

class nextPermutations {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 1 };
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void nextPermutation(int[] arr) {
        int n = arr.length;
        int pivot = -1;

        for (int i = n - 1; i > 0; i--) {
            if (arr[i - 1] < arr[i]) {
                pivot = i - 1;
                break;
            }
        }

        if (pivot == -1) {
            reverse(arr, 0, n - 1);
            return;
        }

        for (int i = n - 1; i > pivot; i--) {
            if (arr[i] > arr[pivot]) {
                swap(arr, pivot, i);
                break;
            }
        }

        reverse(arr, pivot + 1, n - 1);
    }

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
