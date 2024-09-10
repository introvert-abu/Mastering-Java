package Recursion.Easy;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(12345));
        System.out.println(prodOfDigits(12345));
    }

    static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        int ld = n % 10;
        n /= 10;
        return ld + sumOfDigits(n);
    }

    static int prodOfDigits(int n) {
        if (n % 10 == n) {
            return n;
        }
        int ld = n % 10;
        n /= 10;
        return ld * prodOfDigits(n);
    }
}
