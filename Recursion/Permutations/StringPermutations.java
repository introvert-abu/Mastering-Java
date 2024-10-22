package Recursion.Permutations;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        permutations(result, new StringBuilder(), "abc");
        System.out.println(result);
    }

    static void permutations(List<String> result, StringBuilder combo, String s){
        if (s.isEmpty()) {
            result.add(new String(combo));
            return;
        }

        char ch = s.charAt(0);
        for (int i = 0; i <= combo.length(); i++) {
            combo.insert(i, ch);
            permutations(result, combo, s.substring(1));
            combo.deleteCharAt(i);
        }
    }
}
