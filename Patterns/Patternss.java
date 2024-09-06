package Patterns;

public class Patternss {
    public static void main(String[] args) {
        pattern9(4);
    }
    
    static void pattern9(int n) {
        int originalN = n;
        n = 2 * n;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int cell = originalN - Math.min(Math.min(i,j),Math.min(n-i,n-j)) + 1;
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    
    /* 
    static void pattern8(int n) {
        for (int i = 1; i < (2 * n); i++) {
            int c = (i < n) ? i : (2 * n) - i;
            int noOfSpaces = n - c;
            for (int j = 0; j < noOfSpaces; j++) {
                System.out.print("  ");
            }
            for (int j = c; j > 1; j--) {
                System.out.print(j + " ");
            }
            for (int j = 1; j <= c ; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    
    static void pattern7(int n) {
        for (int i = 1; i <= n; i++) {
            int noOfSpaces = n - i;
            for (int j = 0; j < noOfSpaces; j++) {
                System.out.print("  ");
            }
            for (int j = i; j > 1; j--) {
                System.out.print(j + " ");
            }
            for (int j = 1; j <= i ; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void pattern6(int n) {
        for (int i = 0; i < (2 * n) - 1 ; i++) {
            int times = (i < n) ? (i + 1) : (2 * n) - i - 1;
            int noOfSpaces = n - times;
            for (int j = 0; j < noOfSpaces; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < times; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern5(int n) {
        for (int i = 0; i < (2 * n) - 1 ; i++) {
            int noOfSpaces = (i < n) ? (n / 2) - i + 1 : i - n + 1;
            int noOfStars = (i < n) ? (i * 2) + 1 : ((2 * n) - i - 1) * 2 - 1;
            for (int j = 0; j < noOfSpaces; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < noOfStars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern4(int n) {
        for (int i = 0; i < (2 * n) - 1 ; i++) {
            int times = (i < n) ? (i + 1) : (2 * n) - i - 1;
            for (int j = 0; j < times; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern3(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < i+2; j++) {
                System.out.print(j + " ");
            }            
            System.out.println();
        }
    }

    static void pattern2(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                System.out.print("*");
            }            
            System.out.println();
        }
    }

    static void pattern1(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print("*");
            }            
            System.out.println();
        }
    }
    */
}
