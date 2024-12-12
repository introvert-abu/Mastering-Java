

public class LargestDigit {
    public static void main(String[] args) {
        int n = 273;
        int sum = n * (n + 1) / 2;
        System.out.println(sum);
        int biggest = 0;
        while (sum > 0) {
            biggest = Math.max(biggest, sum % 10);
            sum /= 10;
        }
        System.out.println(biggest);
    }
}
