package DSA.DataStructures.ArraysAndArrayList.Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AllSubSets {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 8, 2, 2, 2 };
        // List<List<Integer>> subsets = findingAllSubsets(arr);
        // System.out.println(subsets);
        // List<Integer> ans = longestSubsetWithSumOfK(arr, 5);
        // System.out.println(ans);
        int ans = findingLengthOfLongestSubset(arr, 6);
        System.out.println(ans);
        // int ans = longestSubsetWithSumOfKNegatives(arr, 16);
        // System.out.println(ans);
    }

    // Finding the longest subset optimal(handles all numbers)
    static int longestSubsetWithSumOfKNegatives(int[] arr, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int preSum = 0;
        int finalLength = 0;
        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];

            if (preSum == k) {
                finalLength = i+1;
            }

            int rem = preSum - k;
            if (hash.containsKey(rem)) {
                finalLength = Math.max(finalLength, i - hash.get(rem));
            }

            if (!hash.containsKey(preSum)) {
                hash.put(preSum, i);
            }
        }

        return finalLength;
    }

    // Finding the longest subset optimal(only for positives)
    static int findingLengthOfLongestSubset(int[] arr, int k) {
        int l = 0, r = 0;
        int length = 0, sum = 0;

        while (r < arr.length) {
            sum += arr[r++];

            while (l <= r && sum > k) {
                sum -= arr[l++];
            }

            if (sum == k && r - l > length) {
                length = r - l;
            }
        }

        return length;
    }

    // Finding the longest subset(brute force)
    static List<Integer> longestSubsetWithSumOfK(int[] arr, int kk) {
        int length = -1;
        int sum = 0;
        List<Integer> finalAns = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                sum = 0;
                List<Integer> ans = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                    ans.add(arr[k]);
                    if (sum == kk && ans.size() > length) {
                        length = ans.size();
                        finalAns = ans;
                    }
                }
            }
        }

        return finalAns;
    }

    // Finding all the subsets
    static List<List<Integer>> findingAllSubsets(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                List<Integer> inner = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    inner.add(arr[k]);
                }
                outer.add(inner);
            }
        }

        return outer;
    }
}
