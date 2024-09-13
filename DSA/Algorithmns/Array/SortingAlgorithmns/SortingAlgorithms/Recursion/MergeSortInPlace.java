package DSA.Algorithmns.Array.SortingAlgorithmns.SortingAlgorithms.Recursion;

import java.util.Arrays;

public class MergeSortInPlace {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        mergeSortInPlace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSortInPlace(int[] arr, int s, int e) {
        if (e - s == 1) {
            return;
        }

        int m = s + (e - s) / 2;

        mergeSortInPlace(arr, s, m);
        mergeSortInPlace(arr, m, e);

        mergeInPlace(arr, s, m, e);
    }

    static void mergeInPlace(int[] arr, int s, int m, int e) {
        int[] mix = new int[e - s];

        int lp = s;
        int rp = m;
        int mp = 0;

        while (lp < m && rp < e) {
            if (arr[lp] < arr[rp]) {
                mix[mp] = arr[lp];
                lp++;
            } else {
                mix[mp] = arr[rp];
                rp++;
            }
            mp++;
        }

        while (lp < m) {
            mix[mp] = arr[lp];
            lp++;
            mp++;
        }

        while (rp < e) {
            mix[mp] = arr[rp];
            rp++;
            mp++;
        }

        for (int i = 0; i < mix.length; i++) {
            arr[s + i] = mix[i];
        }
    }
}
