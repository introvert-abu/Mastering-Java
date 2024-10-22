package Recursion.Stringss;

public class SkipAString {
    public static void main(String[] args) {
        System.out.println(skip("OranappgeAppleBanana"));
    }

    static String skip(String up){
        if (up.isEmpty()) {
            return "";
        }

        if (up.toLowerCase().startsWith("app") && !up.toLowerCase().startsWith("apple")) {
            return skip(up.substring(3));
        } else {
            return up.charAt(0) + skip(up.substring(1));
        }
    }
}
