package Recursion.SubsetsAndSubsquences;

import java.util.ArrayList; 

public class SubSequences {
    public static void main(String[] args) {
        String up = "abc";
        System.out.println(subSeqeunces("", up));
        System.out.println(subSeqeuncesAscii("", up));
    }

    static ArrayList<String> subSeqeuncesAscii(String p, String up) {
        ArrayList<String> ans = new ArrayList<>();
        if (up.isEmpty()) {
            if (!p.isEmpty()) {
                ans.add(p);
            }
            return ans;
        }

        char ch = up.charAt(0);
                        
        ans.addAll(subSeqeuncesAscii(p + (ch + 0), up.substring(1)));
        ans.addAll(subSeqeuncesAscii(p, up.substring(1)));
        ans.addAll(subSeqeuncesAscii(p + ch, up.substring(1)));

        return ans;
    }

    static ArrayList<String> subSeqeunces(String p, String up) {
        ArrayList<String> ans = new ArrayList<>();
        if (up.isEmpty()) {
            if (!p.isEmpty()) {
                ans.add(p);
            }
            return ans;
        }

        ans.addAll(subSeqeunces(p + up.charAt(0), up.substring(1)));
        ans.addAll(subSeqeunces(p, up.substring(1)));

        return ans;
    }
}
