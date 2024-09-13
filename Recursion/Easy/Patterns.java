package Recursion.Easy;

public class Patterns {
    public static void main(String[] args) {
        // pattern1(5);
        // pattern3(5,0);
        triangle2(4, 0);
        triangle(4, 0);
    }

    static void triangle2(int r, int c) {
        if (r == 0) {
            return;
        }
        if (r > c) {
            triangle2(r, c+1);
            System.out.print("* ");
        } else {
            triangle2(r-1, 0);
            System.out.println();
        }
    }

    static void triangle(int r, int c) {
        if (r == 0) {
            return;
        }
        if (r > c) {
            System.out.print("* ");
            triangle(r, ++c);
        } else {
            System.out.println();
            triangle(--r, 0);
        }
    }

    static void pattern3(int r, int c) {
        if (r == 0) {
            return;
        }
        if (c == r) {
            System.out.println();
            pattern3(--r, 0);
            return;
        }
        System.out.print("* ");
        pattern3(r, ++c);
    }

    static void pattern1(int n) {
        if (n == 0) {
            return;
        }
        pattern2(n);
        System.out.println();
        pattern1(--n);
    }

    static void pattern2(int n) {
        if (n == 0) {
            return;
        }
        System.out.print("* ");
        pattern2(--n);
    }
}
