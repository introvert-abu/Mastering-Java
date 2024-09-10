package Recursion.Easy;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int ans = binarySearch(arr, 5, 0, arr.length - 1);
        System.out.println(ans);
    }

    static int binarySearch(int[] arr, int target, int s, int e) {
        if (s > e) {
            return -1;
        }

        int m = s + (e - s) / 2;
        if (arr[m] == target) {
            return m;
        } else if (arr[m] > target) {
            return binarySearch(arr, target, s, m - 1);
        } else if (arr[m] < target) {
            return binarySearch(arr, target, m + 1, e);
        }

        return -1;
    }
}
