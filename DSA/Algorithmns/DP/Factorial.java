package DSA.Algorithmns.DP;

public class Factorial {
    public static void main(String[] args) {
        int n = 40;
        System.out.println(iter(n));
    }

    static int iter (int n) {
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    static int[] iterative (int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp;
    }

    static int fact(int n, int[] dp) {
        if (n < 2) {
            return n;
        }
        return dp[n] = fact(n-1, dp) + dp[n-2];
    }
}
