

public class Armstong {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            if(isArmstrong(i)){
                System.out.println(i);
                
            }
        }
    }

    static boolean isArmstrong(int num) {
        int original = num;
        int sum = 0;
        while (num > 0) {
            int lastNum = num % 10;
            sum += lastNum * lastNum * lastNum;
            num /= 10;
        }
        return original == sum;
    }
}