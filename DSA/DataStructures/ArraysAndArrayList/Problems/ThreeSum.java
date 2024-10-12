package DSA.DataStructures.ArraysAndArrayList.Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        // List<List<Integer>> ans1 = brute3Sum(arr);
        // System.out.println(ans1);
        // List<List<Integer>> ans2 = better3Sum(arr);
        // System.out.println(ans2);
        List<List<Integer>> ans3 = optimal3Sum(arr);
        System.out.println(ans3);
    }

    // Optimal
    static List<List<Integer>> optimal3Sum(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();

        if (arr.length < 3) {
            return ans;
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = arr.length - 1;

            while (j < k) {
                List<Integer> triplet = new ArrayList<>();
                int sumOf3 = arr[i] + arr[j] + arr[k];

                if (sumOf3 == 0) {
                    triplet.addAll(List.of(arr[i],arr[j],arr[k]));
                    if (!ans.contains(triplet)) {
                        ans.add(triplet);
                    }
                    k--;
                    j++;
                } else if (sumOf3 > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return ans;
    }

    // BetterOne
    static List<List<Integer>> better3Sum(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<List<Integer>> ansSet = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set = new HashSet<>();
            for (int j = i + 1; j < arr.length; j++) {
                int compliment = 0 - (arr[i] + arr[j]);
                if (set.contains(compliment)) {
                    List<Integer> triplets = new ArrayList<>(List.of(arr[i], arr[j], compliment));
                    Collections.sort(triplets);
                    ansSet.add(triplets);
                }
                set.add(arr[j]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans = List.copyOf(ansSet);

        return ans;
    }

    // Brute Force
    static List<List<Integer>> brute3Sum(int[] arr) {
        HashSet<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> triplets = new ArrayList<>(List.of(arr[i], arr[j], arr[k]));
                        Collections.sort(triplets);
                        set.add(triplets);
                    }
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans = List.copyOf(set);

        return ans;
    }
}
