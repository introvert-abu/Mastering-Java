package RandomStuffs;
import java.util.Arrays;

public class Sort {
    public void bubbleSort(int[] arr) {
        boolean swap;
        for (int i = 0; i < arr.length - 1; i++) {
            swap = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = false;
                }
            }
            if (swap) {
                break;
            }
        }
    }

    public void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int last = arr.length - 1 - i;
            int maxIndex = findMax(arr, 0, last);
            swap(arr, last, maxIndex);
        }
    }

    private void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private int findMax(int[] arr, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }

    public void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public void mergeSort(int[] arr, int s, int e) {
        if (e - s == 1) {
            return;
        }

        int m = s + (e - s) / 2;

        mergeSort(arr, s, m);
        mergeSort(arr, m, e);

        mergeInPlace(arr, s, m, e);
    }

    private void mergeInPlace(int[] arr, int s, int m, int e) {
        int[] mix = new int[e - s];

        int lp = s;
        int rp = m;
        int mp = 0;

        while (lp < m && rp < e) {
            if (arr[lp] < arr[rp]) {
                mix[mp] = arr[lp];
                lp++;
            } else {
                mix[mp] = arr[rp];
                rp++;
            }
            mp++;
        }

        while (lp < m) {
            mix[mp] = arr[lp];
            lp++;
            mp++;
        }

        while (rp < e) {
            mix[mp] = arr[rp];
            rp++;
            mp++;
        }

        for (int i = 0; i < mix.length; i++) {
            arr[s + i] = mix[i];
        }
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int s = low;
        int e = high;
        int m = s + (e - s) / 2;
        int pivot = arr[m];

        while (s <= e) {
            while (arr[s] < pivot) {
                s++;
            }
            while (arr[e] > pivot) {
                e--;
            }
            if (s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }

        quickSort(arr, low, e);
        quickSort(arr, s, high);
    }

    public void countSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();

        int[] freqArray = new int[max + 1];
        for (int num : arr) {
            freqArray[num]++;
        }
        int index = 0;
        for (int i = 0; i < freqArray.length; i++) {
            for (int j = 0; j < freqArray[i]; j++)
                arr[index++] = i;
        }
    }
}