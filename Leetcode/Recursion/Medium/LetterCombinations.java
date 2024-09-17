package Leetcode.Recursion.Medium;
// import java.util.ArrayList;

import java.util.ArrayList;

public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println(letterCombinations("79"));
    }

    static ArrayList<String> letterCombinations(String digits) {
        return helper("",digits);
    }

    static ArrayList<String> helper (String p, String up) {
        ArrayList<String> list = new ArrayList<String>();
        if (up.isEmpty()) {
            list.add(p);
            return list;
        } 
        int digit = up.charAt(0) - '0';
        int s = digit == 8 || digit == 9 ? ((digit - 1) * 3) + 1 : (digit - 1) * 3;
        int e = digit == 7 || digit == 8 ? (digit * 3) + 1 : digit == 9 ? (digit * 3) + 2 : (digit * 3);

        for (int i = s; i < e; i++) {
            char ch = (char) (94 + i);
            ArrayList<String> combinations = helper(p + ch, up.substring(1));
            list.addAll(combinations);
        }
        return list;
    }
}
