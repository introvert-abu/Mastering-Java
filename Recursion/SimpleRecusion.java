package Recursion;

public class SimpleRecusion {
    public static void main(String[] args) {
        printNum(1);
    }

    // Recursion is simply a function calling itself
    static void printNum(int n) {
        // Base Condition
        if (n > 5 ) {
            return;
        }
        System.out.println(n);

        // This is called tail recursion
        // This is the last function
        printNum(n+1);
    }
}
