package Recursion.Easy;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(palindrome(121));
    }

    static boolean palindrome(int n) {
        return n == reverse(n);
    }

    static int reverse(int n) {
        int digits = (int) (Math.log10(n));
        return helper(n, digits);
    }

    static int helper(int n, int digits) {
        if (n % 10 == n) {
            return n;
        }
        return (n % 10) * (int) Math.pow(10, digits) + helper(n / 10, digits - 1);
    }
}
