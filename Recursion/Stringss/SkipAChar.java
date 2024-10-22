package Recursion.Stringss;

public class SkipAChar {
    public static void main(String[] args) {
        System.out.println(skip("acuba"));
    }

    static String skip(String p){
        if (p.isEmpty()) {
            return "";
        }

        if (p.charAt(0) == 'a') {
            return skip(p.substring(1));
        } else {
            return p.charAt(0) + skip(p.substring(1));
        }
    }

    static String skipChar2(String p) {
        StringBuilder up = new StringBuilder();
        if (p.isEmpty()) {
            return up.toString();
        }

        if (p.charAt(0) != 'a') {
            up.append(p.charAt(0));
        }

        up.append(skipChar2(p.substring(1)));

        return up.toString();
    }

    static String skipChar(String p, StringBuilder up) {
        if (p.isEmpty()) {
            return up.toString();
        }

        if (p.charAt(0) != 'a') {
            up.append(p.charAt(0));
        }

        return skipChar(p.substring(1), up);
    }
}
