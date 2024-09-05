package Leetcode.Sorting;
import java.util.Arrays;

public class FindErrNum {
    public static void main(String[] args) {
        int[] arr = {2,3,2,1};
        System.out.println(Arrays.toString(findErrorNums(arr)));        
    }

    static int[] findErrorNums(int[] nums) {
        cycle(nums);
        for (int i=0;i<nums.length;i++) {
            int correct = i + 1;
            if (nums[i] != correct) {
                return new int[] {nums[i],correct};
            }
        }
        return new int[] {-1,-1};
    }

    static void cycle(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            } else {
                i++;
            }
        }
    }
}
