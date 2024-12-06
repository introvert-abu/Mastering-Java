import java.util.Arrays;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = { 16, 17, 4, 3, 5, 2 };
        replaceElements(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void replaceElements(int[] arr) {
        int n = arr.length;
        int greaterElement = -1;
        int prevGraterElement = greaterElement;
        for (int i = n-1; i >= 0; i--) {
            greaterElement = Math.max(greaterElement, arr[i]);            
            arr[i] = prevGraterElement;
            prevGraterElement = greaterElement;
        }
    }
}