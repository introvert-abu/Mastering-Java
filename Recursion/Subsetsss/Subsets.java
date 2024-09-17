package Recursion.Subsetsss;

import java.util.ArrayList;

public class Subsets {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2 };
        ArrayList<ArrayList<Integer>> ans = sub(arr);
        System.out.println(ans);

    }

    static ArrayList<ArrayList<Integer>> sub(int[] arr) {
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<Integer>());
        int s = 0;
        int e = 0;
        for (int i=0;i<arr.length;i++) {
            if (i > 0 && arr[i] == arr[i-1]) {
                s = e + 1;
            }
            e = outer.size() - 1;
            int n = outer.size();
            for (int j = s; j < n; j++) {
                ArrayList<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);                
            }
        }

        outer.remove(0);

        return outer;
    }
}
