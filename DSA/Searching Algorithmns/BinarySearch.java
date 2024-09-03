public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int target = 2;
        System.out.println("Index : " + binarySearch(arr, target));
    }

    // Binary Search
    // There is a OrderAgnostics BinarySearch where you dont know the order is in
    // acs or desc
    // You can compare the first and last element based on which is greater you know
    // how to sort
    // TC - O(logn)
    static int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == target) {
                return m;
            } else if (target < arr[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
