import java.util.ArrayList;
import java.util.List;

public class PrintSubsetsEqualsToN {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int n = 6;
        List<List<Integer>> ans = new ArrayList<>();
        Boolean[][] dp = new Boolean[arr.length][n + 1];
        getSubsets(ans, dp, new ArrayList<>(), arr, n, 0);
        System.out.println(ans);
    }

    private static boolean getSubsets(List<List<Integer>> ans, Boolean[][] dp, List<Integer> subset, int[] arr, int n,
            int i) {
        if (n == 0) {
            ans.add(new ArrayList<>(subset));
            return true;
        }
        if (i == arr.length || n < 0) {
            return false;
        }
        if (dp[i][n] != null && dp[i][n] == false) {
            return false;
        }
        
        subset.add(arr[i]);
        boolean take = getSubsets(ans, dp, subset, arr, n - arr[i], i + 1);
        subset.remove(subset.size() - 1);

        boolean nonTake = getSubsets(ans, dp, subset, arr, n, i + 1);
        
        return take || nonTake;
    }
}
