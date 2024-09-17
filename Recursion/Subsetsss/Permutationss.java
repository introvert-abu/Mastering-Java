package Recursion.Subsetsss;
import java.util.ArrayList;

public class Permutationss {
    public static void main(String[] args) {
        System.out.println(permutation("", "abc"));        
        System.out.println(permutationCount("", "abcd"));        
    }

    static void permutations (String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p + " ");
            return;
        }
        char ch = up.charAt(0);

        for (int i=0;i<=p.length();i++) {
            String s = p.substring(0,i);
            String e = p.substring(i);
            permutations(s + ch + e, up.substring(1));
        }
    }

    static ArrayList<String> permutation (String p, String up) {
        ArrayList<String> list = new ArrayList<String>();
        if (up.isEmpty()) {
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);

        for (int i=0;i<=p.length();i++) {
            String s = p.substring(0,i);
            String e = p.substring(i);
            ArrayList<String> perms = permutation(s + ch + e, up.substring(1));
            list.addAll(perms);
        }
        return list;
    }

    static int permutationCount (String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int count = 0;
        char ch = up.charAt(0);

        for (int i=0;i<=p.length();i++) {
            String s = p.substring(0,i);
            String e = p.substring(i);
            count += permutationCount(s + ch + e, up.substring(1));
        }
        return count;
    }
}