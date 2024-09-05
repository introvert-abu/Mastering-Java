public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        int[] arr = { 8, 6, 4, 3, 2, 1 };
        int target = 1;
        int ans = orderAgnosticBinarySearch(arr, target, 0, arr.length - 1);
        System.out.println(ans);
    }

    static int orderAgnosticBinarySearch(int[] arr, int target, int start, int end) {
        if (arr[start] < arr[end]) {
            while (start <= end) {
                int m = start + (end - start) / 2;
                if (arr[m] == target) {
                    return m;
                } else if (target < arr[m]) {
                    end = m - 1;
                } else {
                    start = m + 1;
                }
            }
            return -1;
        } else {
            while (start <= end) {
                int m = start + (end - start) / 2;
                if (arr[m] == target) {
                    return m;
                } else if (target > arr[m]) {
                    end = m - 1;
                } else {
                    start = m + 1;
                }
            }
            return -1;
        }
    }
}