public class FindTheNthMagicNumber {
    public static void main(String[] args) {
        System.out.println(fintNum(4));
    }   
    
    static int fintNum(int n) {
        int ans = 0;
        int base = 5;
        while (n > 0) {
            if ((n & 1) == 1) {
                int lastDigit = n & 1;
                ans += (lastDigit * base);                
            }
            base *= 5;
            n >>= 1;
        }
        return ans;
    }
}