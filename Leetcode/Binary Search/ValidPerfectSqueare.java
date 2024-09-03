public class ValidPerfectSqueare {
    public static void main(String[] args) {
        System.err.println(isPerfectSquare(16));
    }    

    static boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        long start = 1;
        long end = num;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (mid * mid > num) {
                end = mid - 1;
            } else if (mid * mid < num) {
                start = mid + 1;
            } else {return true;}
        }
        return false;
    }
}