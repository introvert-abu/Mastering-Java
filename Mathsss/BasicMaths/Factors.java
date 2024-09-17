package Mathsss.BasicMaths;
import java.util.ArrayList;

public class Factors {
    public static void main(String[] args) {
        int n = 20;
        ArrayList<Integer> factors = new ArrayList<Integer>();
        for (int i = 1;i <= Math.sqrt(n);i++) {
            if (n % i == 0) {
                System.out.println(i);                
                if (i != (n/i)) {
                    factors.add(n/i);
                }
            }
        }
        for (int i = factors.size() - 1;i >= 0;i--) {
            System.out.println(factors.get(i));
        }
    }
}