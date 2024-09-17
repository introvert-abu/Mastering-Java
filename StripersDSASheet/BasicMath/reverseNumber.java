package StripersDSASheet.BasicMath;

public class reverseNumber {
    public static void main(String[] args) {
        System.out.println(reverse(120));
    }

    static int reverse(int x) {
        long reversedX = 0;
        int sign = (x > 0) ? 1 : -1;
        x = Math.abs(x);
        while (x > 0) {
            int last = x % 10;
            reversedX = (reversedX * 10) + last;
            if (reversedX > Integer.MAX_VALUE) {
                return 0;
            }
            x /= 10;
        }
        reversedX = sign * reversedX;
        if (reversedX > Integer.MAX_VALUE || reversedX < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) (reversedX);
    }
}