package RandomStuffs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LIS {
    public static void main(String[] args) {
        int[] arr = { 4, 3, 3, 2, 7, 9, 1, 7, 12, 8, 10, 20 };
        List<Integer> ans = lis(arr);
        System.out.println(ans);
    }

    private static List<Integer> lis(int[] arr) {
        int n = arr.length;
        int[] size = new int[n];
        int[] prevIndices = new int[n];

        int maxLen = 1;
        int maxIndex = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && size[i] < size[j] + 1) {
                    size[i] = size[j] + 1;
                    prevIndices[i] = j;
                }
            }
            if (size[i] > maxLen) {
                maxLen = size[i];
                maxIndex = i;
            }
        }

        List<Integer> lis = new ArrayList<>();
        while (maxIndex != prevIndices[maxIndex]) {
            lis.add(arr[maxIndex]);
            maxIndex = prevIndices[maxIndex];
        }

        lis.add(arr[maxIndex]);
        Collections.reverse(lis);

        return lis;
    }
}
