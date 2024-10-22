package Recursion.RandomPrograms;

public class CountDigits {
    public static void main(String[] args) {
        System.out.println(countDigit(121212121, 1));
    }

    static int countDigit(int n, int digit) {
        if (n == 0) {
            return n;
        }

        int rem = n % 10;
        boolean isDigit = rem == digit;

        return isDigit ? 1 + countDigit(n / 10, digit) : countDigit(n / 10, digit);
    }
}
