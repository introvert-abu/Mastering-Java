import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        input.close();
        System.out.println(isPrime(num));
    }

    static boolean isPrime(int num) {
        if (num == 2) {
            return true;
        }
        if (num <= 1 || num % 2 == 0) {
            return false;
        }
        int c = 2;
        while (c * c <= num) {
            if (num % c == 0) {
                return false;
            }
            c++;
        }
        return true;
    }
}