package Leetcode.Sorting;
import java.util.Arrays;
import java.util.ArrayList;

public class FindAllMissingNumbers {
    public static void main(String[] args) {
        int[] arr = {4,3,2,4,8,2,3,1};
        cycle(arr);
        System.out.println(Arrays.toString(arr));
        ArrayList<Integer> List = new ArrayList<Integer>(1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i+1) {
                List.add(i+1);
            }
        }
        System.out.println(List);
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
