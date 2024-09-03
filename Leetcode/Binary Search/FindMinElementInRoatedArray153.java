public class FindMinElementInRoatedArray153 {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
    }

    static int findMin(int[] nums) {
        int pivot = findMax(nums);
        if (pivot == -1) {
            return nums[0];
        } else {
            return nums[pivot + 1];
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
}