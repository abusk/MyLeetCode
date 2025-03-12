class Solution {
    public static int maximumCount(int[] nums) {
        int pos = positiveBs(nums);
        int neg = negativeBs(nums);
        return Math.max(pos, neg);
    }
    public static int positiveBs(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end) {
            int mid = (start + end) /2;
            if((mid == 0 && nums[mid] > 0) || (nums[mid] > 0 && nums[mid-1] <= 0)) {
                return nums.length - mid;
            }
            if(nums[mid] <= 0) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return 0;
    }
    public static int negativeBs(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end) {
            int mid = (start + end) /2;
            if((mid == nums.length-1 && nums[mid] < 0) || (nums[mid] < 0 && nums[mid+1] >= 0)) {
                return mid+1;
            }
            if(nums[mid] < 0) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2};
        System.out.println(maximumCount(nums));
    }
}