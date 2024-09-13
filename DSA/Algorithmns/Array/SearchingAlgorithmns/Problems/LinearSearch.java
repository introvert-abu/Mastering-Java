package DSA.Algorithmns.Array.SearchingAlgorithmns.Problems;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = { 2, 4, 67, 8, 9 };
        int target = 9;
        System.out.println(isThere(arr, target));
    }

    // Linear Search 
    // TC - O(n)
    static int isThere(int[] arr, int target) {
        int iterations = 0;
        for (int i = 0; i < arr.length; i++) {
            iterations++;
            if (arr[i] == target) {
                System.out.println("No of iterations : " + iterations);
                return i;
            }
        }
        System.out.println("No of iterations : " + iterations);
        return -1;
    }
}