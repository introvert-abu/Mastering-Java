package Maths.BitManipulatio;

public class NoOfDigits {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(Integer.toBinaryString(n));
        int b = 2; // Base value
        
        int noOfDigits = (int)(Math.log(n) / Math.log(b)) + 1; // (int) log(baseb)(n)+ 1
        System.out.println(noOfDigits);
    }
}
