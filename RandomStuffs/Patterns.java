package RandomStuffs;

public class Patterns {
    public static void main(String[] args) {
        pattern(9);
    }

    static void pattern(int n) {
        int spaces = 0;
        int spaces2 = n-2;
        int mid = (n / 2) + 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }

            System.out.print(i);
            
            if (i < mid) {
                spaces++;
            } else if (i >= mid) {
                spaces--;
            } 

            for (int j = 0; j < spaces2; j++) {
                System.out.print(" ");
            }

            if (i < mid) {
                spaces2 -= 2;
            } else if (i >= mid) {
                spaces2 += 2;
            }

            if (i != mid) {
                System.out.print(i);
            }

            System.out.println();
        }
    }
}
