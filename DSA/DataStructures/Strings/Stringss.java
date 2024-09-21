package DSA.DataStructures.Strings;
import java.util.Arrays;

public class Stringss {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] nums = arr;
        arr[0] = 0;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(nums));

        // Strings that are initialized here will be at string pool which is in heap
        String name = "Siddik";
        String name1 = name;
        name = "Abu";
        System.out.println(name);
        System.out.println(name1);

        // If you create object of string like this it will be stored at heap directly 
        String naam = new String("Abu"); 
        String naam2 = new String("Abu");
        System.out.println(naam == naam2);

        // .equals() method only compares the value it doesnt care whether it is a different object or not
        System.out.println(naam.equals(naam2));
        String naam3 = naam2; 
        System.out.println(naam2 == naam3);
    }
}