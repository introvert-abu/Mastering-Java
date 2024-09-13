package Maths.BitManipulatio;

public class FindTheNonDuplicateNumber {
    public static void main(String[] args) {
        int[] arr = {2,4,3,5,4,3,2};
        System.out.println(findUnique(arr));
    }

    static int findUnique(int[] arr) {
        int unique = 0;

        for (int i : arr) {
            unique ^= i;            
        }

        return unique;
    }
}
