public class FindMinimuminRotatedSortedArrayII154 {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{2,2,2,0,1}));
    }

    static int findMin(int[] nums) {
        int pivot = findMax(nums);
        if (pivot == -1) {
            return nums[0];
        } else {
            return nums[pivot + 1];
        }
    }


    static int findMax(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid != nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid != 0 && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            if (start != 0 && nums[start] < nums[start - 1]) {
                return start - 1;
            }
            if (end != nums.length - 1 && nums[end] > nums[end + 1]) {
                return end;
            }
            if (nums[start] == nums[mid]) {
                start++;
            }
            if (nums[end] == nums[mid]) {
                end--;
            }
            if (nums[0] < nums[mid]) {
                start = mid + 1;
            } else if (nums[0] > nums[mid]) {
                end = mid;
            }
        }
        return -1;
    }
}