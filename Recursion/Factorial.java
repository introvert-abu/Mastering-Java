package Recursion;

public class Factorial {
    public static void main(String[] args) {
        int ans = fact(6);
        System.out.println(ans);
    }

    static int fact(int n) {
        if (n == 2) {
            return 2;            
        }

        return n * fact(n - 1);
    }
}
