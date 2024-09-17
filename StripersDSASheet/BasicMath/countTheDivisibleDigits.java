package StripersDSASheet.BasicMath;

public class countTheDivisibleDigits {
    public static void main(String[] args) {
        int n = 10;
        int originalN = 10;
        int count = 0;
        while (n > 0) {
            int last = n % 10;
            if (last != 0 && (originalN % last) == 0) {
                count++;                
            } 
            n /= 10;
        }
        System.out.println(count);
    }    
}