package Leetcode.Sorting;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] arr = {0,2,4,1};
        System.out.println(missingNumber(arr));
    }

    static int missingNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int correct = nums[i];
            if (nums[i] != n && nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0;j < n;j++) {
            if (nums[j] != j) {
                return j;
            }
        }
        return n;
    }

}
