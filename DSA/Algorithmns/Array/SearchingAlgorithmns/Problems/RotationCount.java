package DSA.Algorithmns.Array.SearchingAlgorithmns.Problems;

public class RotationCount {
    public static void main(String[] args) {
        int[] nums = { 15, 18, 2, 3, 6, 12 };
        int pivot = findMax(nums);
        System.out.println(pivot + 1);
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
