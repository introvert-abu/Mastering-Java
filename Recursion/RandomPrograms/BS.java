package Recursion.RandomPrograms;

public class BS {
    public static void main(String[] args) {
        int[] arr = {4,5,7,8,9,32,8283,3432432,32423424};
        int target = 7;
        int ans = bs(arr, target, 0, arr.length-1);
        System.out.println(ans);
    }

    static int bs(int[] arr, int target, int l, int r) {
        if (l > r) {
            return -1;
        }

        int m = l + (r - l) / 2;

        if (arr[m] == target) {
            return m;
        } else if (arr[m] > target){
            return bs(arr, target, l, m - 1);
        } else {
            return bs(arr, target, m + 1, r);
        }
    }
}
