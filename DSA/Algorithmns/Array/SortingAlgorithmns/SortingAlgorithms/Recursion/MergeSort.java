package DSA.Algorithmns.Array.SortingAlgorithmns.SortingAlgorithms.Recursion;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 4, 3, 3, 7, 9, 2, 8 };
        int[] ans = mergeSort(arr);
        System.out.println(Arrays.toString(ans));
    }

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int m = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, m));
        int[] right = mergeSort(Arrays.copyOfRange(arr, m, arr.length));

        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        int[] mix = new int[left.length + right.length];

        int lp = 0;
        int rp = 0;
        int mp = 0;

        while (lp < left.length && rp < right.length) {
            if (left[lp] < right[rp]) {
                mix[mp] = left[lp];
                lp++;
            } else {
                mix[mp] = right[rp];
                rp++;
            }
            mp++;
        }

        while (lp < left.length) {
            mix[mp] = left[lp];
            lp++;
            mp++;
        }

        while (rp < right.length) {
            mix[mp] = right[rp];
            rp++;
            mp++;
        }

        return mix;
    }
}