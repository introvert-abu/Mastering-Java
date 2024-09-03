public class SearchInRoatatedArrayWithDuplicates {
    public static void main(String[] args) {
        System.out.println(search(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1 }, 2));
    }

    static boolean search(int[] nums, int target) {
        int pivot = findMax(nums);
        if (pivot == -1) {
            int normalBinarySearch = binarySearch(nums, target, 0, nums.length - 1);
            if (normalBinarySearch != -1) {
                return true;
            } else {
                return false;
            }
        }
        if (nums[pivot] == target) {
            return true;
        }
        int firstSearch = binarySearch(nums, target, pivot + 1, nums.length - 1);
        if (firstSearch != -1) {
            return true;
        } else {
            int secondSearch = binarySearch(nums, target, 0, pivot - 1);
            if (secondSearch != -1) {
                return true;
            }
        }
        return false;
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
            if (start != 0 && nums[start] < nums[start - 1]) {
                return start - 1;
            }
            if (end != nums.length - 1 && nums[end] > nums[end + 1]) {
                return end;
            }
            if (nums[start] == nums[mid]) {
                start++;
            }
            if (nums[end] == nums[mid]) {
                end--;
            }
            if (nums[0] < nums[mid]) {
                start = mid + 1;
            } else if (nums[0] > nums[mid]) {
                end = mid;
            }
        }
        return -1;
    }
}