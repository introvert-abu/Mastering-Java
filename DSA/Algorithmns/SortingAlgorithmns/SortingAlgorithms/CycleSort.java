package SortingAlgorithms;
import java.util.Arrays;

public class CycleSort {
    public static void main(String[] args) {
        int[] arr = { 5, 3, 1, 2, 4 ,7,6,8,9,10};
        cycle(arr);
        System.out.println(Arrays.toString(arr));
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
