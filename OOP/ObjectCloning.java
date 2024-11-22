package OOP;
import java.util.Arrays;

public class ObjectCloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human abu = new Human("Abu", 21, "ZOHO", 50000, new int[] { 2, 3, 4, 5 });
        Human siddik = (Human) abu.clone();

        // Shallow copying not for premitives
        siddik.arr[0] = 10;
        System.out.println(Arrays.toString(abu.arr));
        System.out.println(Arrays.toString(siddik.arr));
        
        // Deep copy
        Human abu2 = new Human(abu);
        abu2.arr[0] = 1;
        System.out.println(Arrays.toString(abu.arr));
        System.out.println(Arrays.toString(abu2.arr));        
   }
}
