package Leetcode.Sorting;
import java.util.ArrayList;

public class FIndAllDuplicates {
    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 7, 8, 2, 3, 1 };
        cycle(arr);
        System.out.println(findDuplicates(arr));
    }

    static ArrayList<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> List = new ArrayList<Integer>(1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                List.add(nums[i]);
            }
        }
        return List;
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
