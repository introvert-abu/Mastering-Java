package Problems;

public class RotatedArrayBinarySearch2 {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 5, 6, 7, 1, 2 };
        System.out.println(binary(arr, 4));
    }

    static int binary(int[] arr, int t) {
        int pivot = pivot(arr);
        if (pivot == 0) {
            return bn(arr, t, 0, arr.length - 1);
        }
        if (arr[pivot] == t) {
            return pivot;
        }
        if (t > arr[0]) {
            return bn(arr, t, 0, pivot - 1);
        }
        return bn(arr, t, pivot + 1, arr.length - 1);
    }

    static int pivot(int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        while (s < e) {
            int m = s + (e - s) / 2;
            if (arr[m] > arr[e]) {
                s = m + 1;
            } else {
                e = m;
            }
        }
        return s;
    }

    static int bn(int[] arr, int t, int s, int e) {
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (arr[m] == t) {
                return m;
            } else if (arr[m] > t) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return -1;
    }
}
