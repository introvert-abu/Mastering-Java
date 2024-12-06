import java.util.Arrays;

public class EquilibriumIndex {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int index = find(arr);
        System.out.println(index);
    }

    private static int find(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        int preSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum - preSum - arr[i] == preSum) {
                return i;
            }
            preSum += arr[i];
        }
        return -1;
    }
}
