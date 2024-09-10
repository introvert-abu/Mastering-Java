public class HCF {
    public static void main(String[] args) {
        System.out.println(hcf(12, 18));
        int ans = recursiveHCF(20, 10);
        System.out.println(ans);
        System.out.println(euclidenAlgo(20, 10));
    }

    // O(root(n))
    static int hcf(int n1, int n2) {
        int n = n2 > n1 ? n2 : n1;
        int hcf = 1;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                hcf = i;
            }
            if (n1 % (n / i) == 0 && n2 % (n / i) == 0) {
                hcf = n / i;
            }
        }
        return hcf;
    }

    static int euclidenAlgo(int a, int b) {
        while (a > 0 && b > 0) {
            if (a > b) a = a % b;
            else b = b % a;
        }
        return a > 0 ? a : b;
    }

    // O(log(min(a, b)))
    static int recursiveHCF(int a, int b) {
        if (a == 0) {
            return b;
        }
        return recursiveHCF(b % a, a);
    }
}
