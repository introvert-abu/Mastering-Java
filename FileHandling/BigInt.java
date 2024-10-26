package FileHandling;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigInt {
    public static void main(String[] args) {
        BigInteger num1 = new BigInteger("5435435345435345435344534534543534534534534");
        BigInteger num2 = new BigInteger("5435435345435345435344534534543534534534534");
        System.out.println(num1.add(num2));
        System.out.println(num1.subtract(num2));
        System.out.println(num1.multiply(num2));
        System.out.println(num1.divide(num2));
        System.out.println(num1.negate());

        BigDecimal num3 = new BigDecimal("83034928103982093.230982013");
        BigDecimal num4 = new BigDecimal("83034234928103982093.230982013");
        System.out.println(num3.add(num4));
        System.out.println(num3.subtract(num4));
        System.out.println(num3.multiply(num4));
        System.out.println(num3.divide(num3));
        System.out.println(num3.negate());
    }
}
