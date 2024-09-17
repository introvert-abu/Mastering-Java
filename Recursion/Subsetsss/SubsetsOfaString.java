package Recursion.Subsetsss;

import java.util.ArrayList;

public class SubsetsOfaString {
    public static void main(String[] args) {
        ArrayList<String> ans = subset2("", "abc");
        System.out.println(ans);
    }

    static ArrayList<String> subset(String p, String up,ArrayList<String> list) {
        if (up.isEmpty()) {
            if (!p.isEmpty()) {
                list.add(p);                
            }
            return list;
        }
        char ch = up.charAt(0);

        subset(p+ch,up.substring(1),list);
        subset(p,up.substring(1),list);

        return list;
    }

    static ArrayList<String> subset2(String p, String up) {
        ArrayList<String> list = new ArrayList<>();
        if (up.isEmpty()) {
            if (!p.isEmpty()) {
                list.add(p);
            }
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subset2(p, up.substring(1));
        ArrayList<String> right = subset2(p + ch, up.substring(1));

        left.addAll(right);

        return left;
    }
}
