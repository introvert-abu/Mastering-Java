import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 4, 5 };
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // It is a stable sorting algorithm
    // TC - O(n^2) SC - O(1)
    static void bubbleSort(int[] arr) {
        boolean swap;
        int it =0;
        for (int i = 0; i < arr.length - 1; i++) {
            it++;
            swap = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = false;
                }
            }
            System.out.println(it);
            if (swap) {
                break;
            } 
        }
    }
}
