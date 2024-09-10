package Recursion;

public class FibonacciNumbers {
    public static void main(String[] args) {
        int fibonacciNumber = fibonacci(6);
        System.out.println(fibonacciNumber);
    }

    static int fibonacci(int n) {
        if (n < 3) {
            return n - 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
