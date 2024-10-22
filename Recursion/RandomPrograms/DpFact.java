package Recursion.RandomPrograms;

import java.util.HashMap;

public class DpFact {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < 20; j++) {
            System.out.println(dpFact(j, map));
        }

        dpF(100);
    }

    static void dpF(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] % MOD + dp[i - 2] % MOD;
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]);
        }
    }

    static int dpFact(int n, HashMap<Integer, Integer> map) {
        if (n < 2) {
            map.put(0, 0);
            map.put(1, 1);
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }

        map.put(n - 1, dpFact(n - 1, map) % MOD);

        return (map.get(n - 1) + map.get(n - 2)) % MOD;
    }
}
