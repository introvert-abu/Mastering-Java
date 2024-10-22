package Recursion.Arrayss;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {44,3,4,5,6,44,22,11,44};
        int target = 44;
        // System.out.println(contains(arr, target, 0));
        // System.out.println(elementIndex(arr, target, 0));
        System.out.println(findAllIndices(arr, target, 0));
    }

    static boolean contains(int[] arr, int target, int i) {
        if (i == arr.length) {
            return false;
        }

        return arr[i] == target || contains(arr, target, ++i);
    }

    static int elementIndex(int[] arr, int target, int i) {
        if (i == arr.length) {
            return -1;
        }

        return arr[i] == target ? i : elementIndex(arr, target, ++i);
    }

    static ArrayList<Integer> findAllIndices(int[] arr, int target, int i){
        ArrayList<Integer> ans = new ArrayList<>();
        if (i == arr.length) {
            return ans;
        }

        if (arr[i] == target) {
            ans.add(i);
        }

        ans.addAll(findAllIndices(arr, target, ++i));

        return ans;
    } 
}
