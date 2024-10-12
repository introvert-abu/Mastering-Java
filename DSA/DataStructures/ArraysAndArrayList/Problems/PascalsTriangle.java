package DSA.DataStructures.ArraysAndArrayList.Problems;

import java.util.ArrayList;

public class PascalsTriangle {
    public static void main(String[] args) {
        // int ans = findElement(4, 3);
        // System.out.println(ans);
        // ArrayList<Integer> ans = generateRow(5);
        // System.out.println(ans);
        ArrayList<ArrayList<Integer>> ans = printTriangle(5);
        ans.forEach(a -> System.out.println(a));
    }

    static ArrayList<ArrayList<Integer>> printTriangle(int row) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int col = 1; col <= row; col++) {
            ans.add(generateRow(col));
        }

        return ans;
    }

    static ArrayList<Integer> generateRow(int row) {
        ArrayList<Integer> ans = new ArrayList<>();
        int element = 1;
        ans.add(element);
        for (int col = 1; col < row; col++) {
            element = element * (row - col);
            element = element / col;
            ans.add(element);
        }

        return ans;
    }

    static int findElement(int r, int c) {
        r = r - 1;
        c = c - 1;
        int ans = 1;
        for (int i = 0; i < c; i++) {
            ans = ans * r--;
            ans = ans / (i + 1);
        }

        return ans;
    }
}
