package Recursion.RandomPrograms;

public class Patterns {
    public static void main(String[] args) {
        pattern1(5, 0);
    }

    static void pattern1(int n, int n2){
        if (n == 0) {
            return;
        }

        if (n2 < n) {
            pattern1(n, n2+1);            
            System.out.print("* ");
        } else {
            pattern1(n-1, 0);
            if (n != 1) {
                System.out.println();
            }
        }
    }
}
