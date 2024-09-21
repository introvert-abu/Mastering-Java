package Leetcode.Sorting;

public class FindDuplicateNUmber {
    public static void main(String[] args) {
        int[] arr = {1,3,4,3,2};
        cycle(arr);
        System.out.println(findDuplicate(arr));
    }

    static int findDuplicate(int[] nums) {
        return nums[nums.length-1];
    }

    static void cycle(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] == arr[correctIndex]) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            }
        }
    }
}
