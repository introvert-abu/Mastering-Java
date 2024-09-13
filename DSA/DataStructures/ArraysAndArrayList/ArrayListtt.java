package DSA.DataStructures.ArraysAndArrayList;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListtt {
    public static void main(String[] args) {
        // Single dimensional ArrayList
        ArrayList<Integer> numbers = new ArrayList<>(10);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        System.out.println(numbers);
        numbers.set(0, null);
        System.out.println(numbers);
        System.out.println(numbers.contains(5));
        System.out.println(numbers.contains(7));
        numbers.remove(5);
        System.out.println(numbers);
        System.out.println(numbers.get(4));

        // Two dimensional ArrayList
        Scanner input = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> numbers2 = new ArrayList<>();
        for (int index = 0; index < 3; index++) {
            numbers2.add(new ArrayList<>());
        }
        for (int index = 0; index < 3; index++) {
            for (int i = 0; i < 3; i++) {
                numbers2.get(index).add(input.nextInt());
            }
        }
        input.close();
        System.out.println(numbers2);
    }
}
