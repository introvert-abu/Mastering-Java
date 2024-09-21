package DSA.DataStructures.Strings;

public class StringBuilderrr {
    public static void main(String[] args) {
        // This will be O(n^2)
        String alphabets = "";
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            alphabets += ch;
        }
        System.out.println(alphabets);

        StringBuilder alpha = new StringBuilder("");
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            alpha.append(ch);
        }
        System.out.println(alpha);
    }
}
