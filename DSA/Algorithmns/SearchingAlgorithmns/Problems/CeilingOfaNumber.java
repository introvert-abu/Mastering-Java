package Problems;

public class CeilingOfaNumber {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 6, 8, 9, 22, 44, 66 };
        int target = 67;
        System.out.println(ceiling(arr, target));
    }

    static int ceiling(int[] arr, int target) {
        if (target > arr[arr.length - 1]) {
            return -1;
        }
        if (arr.length <= 1) {
            return 0;
        }
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == target) {
                return m;
            } else if (arr[l] == target) {
                return l;
            } else if (arr[r] == target) {
                return r;
            } else if (m != 0 && arr[m] > target && arr[m - 1] < target) {
                return m;
            } else if (l != 0 && arr[l] > target && arr[l - 1] < target) {
                return l;
            } else if (m != 0 && arr[r] > target && arr[r - 1] < target) {
                return r;
            } else if (arr[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
