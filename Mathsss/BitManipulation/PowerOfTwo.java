package Mathsss.BitManipulation;
public class PowerOfTwo {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(isPowerOfTwo(n));
    }

    static boolean isPowerOfTwo (int n) {
        return (n & (n-1)) == 0;
    }
}
