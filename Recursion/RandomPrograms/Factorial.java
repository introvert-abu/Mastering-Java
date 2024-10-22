package Recursion.RandomPrograms;

public class Factorial {
    public static void main(String[] args) {
        int n = 10;
        int ans = fact(n);
        System.out.println("Factorial of " + n + " -> "+  ans);
    }

    static int fact(int n) {
        if (n == 1) return 1;

        return n * fact(n-1);
    }
}
