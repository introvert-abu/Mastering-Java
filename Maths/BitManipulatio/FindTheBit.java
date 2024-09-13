package Maths.BitManipulatio;

public class FindTheBit {
    public static void main(String[] args) {
        System.out.println(findBit(5, 3));
    }

    static int findBit(int n, int i) {
        n >>= i - 1; 
        return n & 1;
    }
}
