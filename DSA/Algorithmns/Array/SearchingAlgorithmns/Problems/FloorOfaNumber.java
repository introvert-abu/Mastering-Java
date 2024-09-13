package DSA.Algorithmns.Array.SearchingAlgorithmns.Problems;

public class FloorOfaNumber {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 6, 7, 8, 22, 44, 66 };
        int target = 1;
        System.out.println(floor(arr, target));
    }

    static int floor(int[] arr, int target) {
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
            } else if (m != arr.length - 1 && arr[m] < target && arr[m + 1] > target) {
                return m;
            } else if (l != arr.length - 1 && arr[l] < target && arr[l + 1] > target) {
                return l;
            } else if (r != arr.length - 1 && arr[r] < target && arr[r + 1] > target) {
                return r;
            } else if (arr[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
}
