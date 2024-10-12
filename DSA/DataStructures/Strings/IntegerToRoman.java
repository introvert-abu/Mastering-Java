package DSA.DataStructures.Strings;

public class IntegerToRoman {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            System.out.print(intToRoman(i) + " ");
        }
    }

    static String intToRoman(int num) {
        StringBuilder s = new StringBuilder();
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] romanChars = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                s.append(romanChars[i]);
                num -= values[i];
            }
        }

        return s.toString();
    }
}
