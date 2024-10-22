package BitManipulation;

public class Manipulation {
    public static void main(String[] args) {
        // int[] arr = { 2, 3, 5, 6, 6, 3, 2 };
        // System.out.println(findThUniqeue(arr));
        // int[] arr2 = { 2, 2, 2, 3, 3, 3, 5, 5, 5, 6 };
        // int ans = findThUniqeueInOddNumbers(arr2);
        // System.out.println(ans);
        // System.out.println(nthMagicNumber(6));
        // System.out.println((int)(Math.log(6) / Math.log(2)) + 1);
        // for (int i = 1; i < 10; i++) {
        //     System.out.println(1 << i); // pascal's triangle's sum of row
        // }
        // for (int i = 0; i <= 32; i++) {
        //     System.out.println(i + " " + isPowerOftwo(i));
        // }
        // System.out.println(pow(2, 4));
        // System.out.println(7 - (7 & 7-1));
        // System.out.println(Integer.toBinaryString(10));
        // System.out.println(setBits(10));
        // for (int i = 0; i < 10; i++) {
        //     System.out.println(i + " " + xorOf0ToB(i));
        //     System.out.println(i + " " + xor(i));
        // }
        System.out.println(xorOf0ToB(9)^xorOf0ToB(2));
    }

    static int xor(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans ^= i;
        }

        return ans;
    }

    static int xorOf0ToB(int n){
        if (n % 4 == 0) {
            return n;
        } else if (n % 4 == 1) {
            return 1;
        } else if (n % 4 == 2) {
            return n+1;
        } else {
            return 0;
        }
    }

    static int setBits(int n) {
        int count = 0;
        while (n > 0) {
            n &= n-1;
            count++;
        }

        return count;
    }

    static int pow(int n, int power) {
        int ans = 1;
        int base = n;
        while (power > 0) {
            if ((power & 1) == 1) {
                ans *= base;
            }
            base *= base;
            power >>= 1;
        }

        return ans;
    }

    static boolean isPowerOftwo(int n) {
        if (n == 0) {
            return false;
        }

        return (n & (n-1)) == 0;
    }

    static int nthMagicNumber(int n) {
        int result = 0;
        int base = 5;
        while (n > 0) {
            result += (n & 1) * base;
            n >>= 1;
            base *= 5;
        }

        return result;
    }

    static int findThUniqeueInOddNumbers(int[] arr) {
        int result = 0;
        for (int i = 0; i < 31; i++) {
            int sum = 0;
            int bit = (1 << i);

            for (int num : arr) {
                if ((num & bit) != 0) {
                    sum++;
                }
            }

            if (sum % 3 != 0) {
                result |= bit;
            }
        }

        return result;
    }

    static int findThUniqeue(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum ^= num;
        }

        return sum;
    }

    static int setIthBit0(int n, int i) {
        return n & ~(1 << (i - 1));
    }

    static int setIthBit1(int n, int i) {
        return n | (1 << (i - 1));
    }

    static int findIthBit(int n, int i) {
        return (n & (1 << (i - 1))) == 0 ? 0 : 1;
    }

    static long baseBToDecimal(long num, long base) {
        long ans = 0;
        int power = 0;
        while (num > 0) {
            ans += (num % 10) * (long) Math.pow(base, power++);
            num /= 10;
        }

        return ans;
    }

    static long decimalToBaseB(long num, long base) {
        long sum = 0;
        boolean isZero = false;

        while (num > 0) {
            sum = (sum * 10) + (num % base);
            if (sum == 0 && (num % base) == 0) {
                isZero = true;
            }
            num /= base;
        }

        long ans = 0;
        while (sum > 0) {
            ans = (ans * 10) + (sum % 10);
            sum /= 10;
        }

        if (isZero) {
            ans = (ans * 10);
        }

        return ans;
    }
}
