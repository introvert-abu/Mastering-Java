package Leetcode.Sorting;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] arr = { 3, 4, -1, 1 };
        System.out.println(firstMissingPositive(arr));
    }

    static int firstMissingPositive(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return missingNumber(nums, min, max);
    }

    static int missingNumber(int[] nums, int min, int max) {
        int n = max;
        int i = 0;
        while (i < n) {
            int correct = nums[i] - min;
            if (nums[i] != n && nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < n; j++) {
            if (nums[j] != j) {
                return j;
            }
        }
        return n;
    }
}
