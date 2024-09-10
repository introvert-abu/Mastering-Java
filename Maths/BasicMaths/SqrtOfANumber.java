public class SqrtOfANumber {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(sqrt(n,4));
    }

    static double sqrt(int n ,int p) {
        int start = 0;
        int end = n;
        double ans = 0;
        while (start <= end) {
            int mid = start + (end - start) /  2;
            if (mid <= n / mid) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        double incr = 0.1;
        for (int i = 0; i < p; i++) {
            while (ans * ans <= n) {
                ans += incr;
            }
            ans -= incr;
            incr /= 10;
        }
        return ans;
    }
}