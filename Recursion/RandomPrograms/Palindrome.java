package Recursion.RandomPrograms;

public class Palindrome {
    public static void main(String[] args) {
        int n = 12121;
        boolean ans = isPalindrome(n);
        System.out.println(ans);
    }

    static boolean isPalindrome(int n) {
        return n == ReverseNumber.reverse(n, 0);
    }
}
