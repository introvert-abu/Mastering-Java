public class SecondMaxAndMax {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,6,7,8};
        int[] arr2 = {6,6};
        System.out.println(findMax(arr));
        System.out.println(findMax(arr2));
    }   

    static int findMax(int[] arr) {
        int max = 0;
        int secondMax = 0;
        for (int num : arr) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num != max) {
                secondMax = num;
            }
        }
        return secondMax != 0 ? secondMax : -1;
    }
}
