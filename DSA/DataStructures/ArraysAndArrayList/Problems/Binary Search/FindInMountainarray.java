public class FindInMountainarray {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(finalAnswer());
        long endTime = System.nanoTime();
        double time = ((double)endTime-startTime)/1000000;
        System.out.println(time);
    }

    static int finalAnswer() {
        int[] arr = { 1, 3, 4, 5, 6, 3, 1 };
        int target = 1;
        if (arr.length < 3) {
            return orderAgnosticBinarySearch(arr, target, 0, arr.length - 1);
        } else {
            int peak = findPeakElement(arr);
            if (arr[peak] == target) {
                return peak;
            }
            int firstSearch = orderAgnosticBinarySearch(arr, target, 0, peak - 1);
            if (firstSearch != -1) {
                return firstSearch;
            } else {
                return orderAgnosticBinarySearch(arr, target, peak + 1, arr.length -1 );
            }
        }
    }

    static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            }
        }
        return start;
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