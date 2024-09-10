public class FindIfArrayIsRotatedAndSorted {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 3, 4 };
        System.out.println(check(arr));
    }

    static boolean check(int[] nums) {
        int pivot = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                pivot = i + 1;
                break;
            }
        }
        if (pivot == 0) {
            return traverse(nums, 0, nums.length - 1);
        } else {
            if (nums[0] < nums[nums.length -1]) {
                return false;
            }
            boolean firstSearch = traverse(nums, pivot, nums.length - 1);
            if (!firstSearch) {
                return false;
            } else {
                return traverse(nums, 0, pivot - 1);
            }
        }
    }

    static boolean traverse(int arr[], int start, int end) {
        for (int i = start; i < end; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
