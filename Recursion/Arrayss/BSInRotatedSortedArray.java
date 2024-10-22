package Recursion.Arrayss;

public class BSInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = { 5, 1, 3 };
        int target = 3;
        System.out.println(contains(arr, target, 0, arr.length - 1));
    }

    static int contains(int[] arr, int target, int s, int e) {
        if (s > e) {
            return -1;
        }
        int m = s + (e - s) / 2;

        if (arr[m] == target) {
            return m;
        }

        if (arr[s] <= arr[m]) {
            if (arr[s] <= target && arr[m] > target) {
                return contains(arr, target, s, m - 1);
            } else {
                return contains(arr, target, m + 1, e);
            }            
        } else {
            if (arr[m] < target && arr[e] >= target) {
                return contains(arr, target, m + 1, e);
            } else {
                return contains(arr, target, s, m - 1);
            }
        }
    }
}
