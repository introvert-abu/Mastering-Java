package Recursion.Permutations;

import java.util.ArrayList;
import java.util.List;

public class ArrayPermutaions {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        permutations(result, new ArrayList<>(), new int[] { 1, 2, 3 }, 0);
        System.out.println(result);
    }

    static void permutations(List<List<Integer>> result, ArrayList<Integer> perm, int[] arr, int i) {
        if (i == arr.length) {
            result.add(new ArrayList<>(perm));
            return;
        }

        for (int j = 0; j <= perm.size(); j++) {
            perm.add(j, arr[i]);
            permutations(result, perm, arr, i+1);
            perm.remove(j);
        }
    }
}
