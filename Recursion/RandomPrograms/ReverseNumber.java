package Recursion.RandomPrograms;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(reverse(12345, 0));
    }

    static int reverse(int n, int num) {
        if (n == 0) {
            return num;
        }

        return reverse(n / 10, (num * 10) + (n % 10));
    }
}
