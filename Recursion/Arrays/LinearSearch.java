package Recursion.Arrays;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        // int[] arr = { 4, 3, 2, 6, 7 };
        // System.out.println(linear(arr, 7));
        int[] arr2 = { 4, 3, 2, 6, 7, 4 };
        ArrayList<Integer> ans = findAllIndices2(arr2, 4, 0);
        System.out.println(ans);
        // System.out.println(findAllIndices(arr2,4, new ArrayList<>(), 0));
    }

    static ArrayList<Integer> findAllIndices2(int[] arr, int target, int in) {
        ArrayList<Integer> list = new ArrayList<>();
        if (in == arr.length) {
            return list;
        }
        if (arr[in] == target) {
            list.add(in);
        }
        ArrayList<Integer> ansFromBelow = findAllIndices2(arr, target, ++in);
        list.addAll(ansFromBelow);
        return list;
    }

    static ArrayList<Integer> findAllIndices(int[] arr, int target, ArrayList<Integer> list, int in) {
        if (in == arr.length) {
            return list;
        }
        if (arr[in] == target) {
            list.add(in);
        }
        return findAllIndices(arr, target, list, ++in);
    }

    static int linear(int[] arr, int target) {
        return helper(arr, target, 0);
    }

    static int helper(int[] arr, int target, int in) {
        if (arr.length == in) {
            return -1;
        } else if (arr[in] == target) {
            return in;
        }
        return helper(arr, target, ++in);
    }
}
