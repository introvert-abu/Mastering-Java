package Recursion.Arrays;

public class IsSorted {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        System.out.println(isSorted(arr));
    }

    static boolean isSorted(int[] arr) {
        boolean isAsc = arr[0] < arr[arr.length - 1] ? true : false;
        return helper(arr, 0, isAsc);
    }

    static boolean helper(int[] arr, int i, boolean isAsc) {
        if (isAsc) {
            if (arr[i] > arr[i + 1]) {
                return false;
            } else if (arr.length - 2 == i) {
                return true;
            }
        } else {
            if (arr[i] < arr[i + 1]) {
                return false;
            } else if (arr.length - 2 == i) {
                return true;
            }
        }
        return helper(arr, ++i, isAsc);
    }
}
