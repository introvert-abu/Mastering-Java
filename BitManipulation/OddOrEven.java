package BitManipulation;

public class OddOrEven {
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 15;
        System.out.println(and(n1));
        System.out.println(and(n2));
        System.out.println(or(n1));
        System.out.println(or(n2));
        System.out.println(xor(n1));
        System.out.println(xor(n2));
    }

    static String and(int n) {
        return (n & 1) == 1 ? "Odd" : "Even"; // and 1 get the same number and 0 get 1
    }

    static String or(int n) {
        return (n | 1) == n ? "Odd" : "Even"; // or 0 get the same number or 1 get 1
    }

    static String xor(int n) {
        return (n ^ 1) == n-1 ? "Odd" : "Even"; // xor opposite get opposite xor same get the same
    }
}
