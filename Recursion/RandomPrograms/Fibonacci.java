package Recursion.RandomPrograms;

public class Fibonacci {
    public static void main(String[] args) {
        for (int i = 1; i < 20; i++) {
            System.out.println(fiboIterative(i));
        }
    }

    static int fiboIterative(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }

        int a = 0, b = 1;
        int result = 1;
        int i = 2;
        while (i < n) {
            result = a + b;
            a = b;
            b = result;            
            i++;
        }

        return result;
    }

    static int fibo(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        return fibo(n-1) + fibo(n-2);
    }
}