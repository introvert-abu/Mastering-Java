public class SearchInARoatatedArray {
    public static void main(String[] args) {
        int[] nums = { 3,1 };
        int target = 1;
        System.out.println(search(nums, target));
    }

    static int search(int[] nums, int target) {
        int pivot = findMax(nums);
        System.out.println(pivot);
        if (nums[pivot] == target) {
            return pivot;
        }
        int firstSearch = binarySearch(nums, target, 0, pivot - 1);
        if (firstSearch != -1) {
            return firstSearch;
        } else {
            return binarySearch(nums, target, pivot + 1, nums.length - 1);
        }
    }

    static int findMax(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid != nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid != 0 && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            if (nums[0] < nums[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return -1;
    }

    static int binarySearch(int[] nums, int target, int l, int r) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            } else if (target < nums[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
