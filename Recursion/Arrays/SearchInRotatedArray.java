package Recursion.Arrays;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 1, 2 };
        System.out.println(findIndex(arr, 2));
    }

    static int findIndex(int[] arr, int t) {
        return helper(arr, t, 0, arr.length - 1);
    }

    static int helper(int[] arr, int t, int s, int e) {
        if (s > e) {
            return -1;
        }
        int m = s + (e - s) / 2;
        if (arr[m] == t) {
            return m;
        }
        if (arr[s] <= arr[m]) {
            if (t >= arr[s] && t < arr[m]) {
                return helper(arr, t, s, m - 1);
            } else {
                return helper(arr, t, m + 1, e);
            }
        } else {
            if (t > arr[m] && t <= arr[e]) {
                return helper(arr, t, m + 1, e);
            } else {
                return helper(arr, t, s, m - 1);
            }
        }
    }
}
