package Maths.BitManipulatio;

class FindUniqueNumber {
    static int findUnique(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) { // Process each bit position
            int bitCount = 0;
            for (int num : nums) {
                if ((num & (1 << i)) != 0) {
                    bitCount++;
                }
            }
            if (bitCount % 3 != 0) {
                result |= (1 << i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3,3,3,4, 2}; // Example input
        System.out.println(findUnique(nums)); // Output the unique number
    }
}