package DSA.Algorithmns.Array.SortingAlgorithmns.SortingAlgorithms;
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 1,2,-1,0 };
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // TC - O(n^2) SC - O(1)
    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int last = arr.length - 1 - i;
            int maxIndex = findMax(arr, 0, last);
            swap(arr, last, maxIndex);
        }
    }

    static void swap(int[] arr,int first,int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static int findMax(int[] arr,int start,int end){
        int max = start;
        for (int i = start; i <= end; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }
}
