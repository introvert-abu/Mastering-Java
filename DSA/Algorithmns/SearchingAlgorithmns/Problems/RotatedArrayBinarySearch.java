package Problems;

public class RotatedArrayBinarySearch {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 1, 2 };
        System.out.println(binary(arr, 4));
    }

    static int binary(int[] arr, int t) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (arr[m] == t) {
                return m;
            }
            if (arr[s] <= arr[m]) {
                if (arr[s] <= t && t < arr[m]) {
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            } else {
                if (arr[m] < t && t <= arr[e]) {
                    s = m + 1;
                } else {
                    e = m - 1;
                }
            }
        }
        return -1;
    }
}
