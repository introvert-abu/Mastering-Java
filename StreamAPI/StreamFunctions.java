package StreamAPI;

import java.util.Arrays;
import java.util.List;

public class StreamFunctions {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 6, 3, 3, 46, 8, 8);

        // int result = 0;
        // for (Integer integer : nums) {
        //     result += integer;
        // }


        int result = nums.stream().reduce(0, (a, b) -> a + b);

        System.out.println(result);
    }
}
