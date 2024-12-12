
public class Search {

    public int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == target) {
                return m;
            } else if (target < arr[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
