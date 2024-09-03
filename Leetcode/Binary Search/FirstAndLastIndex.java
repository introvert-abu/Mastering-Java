import java.util.Arrays;

public class FirstAndLastIndex {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[] { 1, 2, 3, 3, 4, 66, 77 }, 3)));
    }

    static int[] searchRange(int[] nums, int target) {
        int[] ans = { -1, -1 };
        ans[0] = searchIndex(nums, target, true);
        if (ans[0] != -1) {
            ans[1] = searchIndex(nums, target, false);
        }
        return ans;
    }

    static int searchIndex(int[] nums, int target, boolean isFirstIndex) {
        int ans = -1;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                ans = m;
                if (isFirstIndex) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
}
