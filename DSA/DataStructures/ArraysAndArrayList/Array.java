package DSA.DataStructures.ArraysAndArrayList;
import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        System.out.println("Single Dimentional Array");
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(arr));
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Two Dimentional Array");
        int[][] arr2 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        for (int[] a : arr2) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println(Arrays.toString(arr2[0]));
    }
}
