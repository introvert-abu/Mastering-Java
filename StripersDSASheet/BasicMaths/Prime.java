public class Prime {
    public static void main(String[] args) {
        int n = 132;
        int c = 2;
        boolean isPrime = true;
        while (c * c <= n) {
            if (n % c == 0) {
                isPrime = false;
                break;
            }
            c++;
        }
        System.out.println(isPrime);
    }
}
