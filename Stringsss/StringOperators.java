package Stringsss;
import java.util.ArrayList;

public class StringOperators {
    public static void main(String[] args) {
        System.out.println('a' + 'b'); // Adding the ascii values
        System.out.println('a' + 3); // Acsii stuff
        System.out.println((char) ('a' + 3)); // Acsii stuff

        // This is called Operator Overloading
        // We cant overload an operator by ourselves this is the only exception
        System.out.println("a" + "b"); // concadinating the strings

        // This will convert integer to Integer and it will call toString which usually does for integers to print
        // Means 1 will be converted to "1"
        System.out.println("a" + 1);
        System.out.println("Abu " + new ArrayList<>());
        System.out.println("Abu " + Integer.valueOf(50));
        
        // System.out.println(new Integer(56) + new ArrayList<>());  This is a Error 
        // To concadinate you need atleast one of those value must be String data type
        System.out.println(Integer.valueOf(50)+" "+new ArrayList<>());
    }
}
