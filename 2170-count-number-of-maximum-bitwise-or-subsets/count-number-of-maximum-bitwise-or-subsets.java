class Solution {
    public static int total = 0;
    public static int countMaxOrSubsets(int[] nums) {
        int max = 0;
        total = 0;
        for(int num : nums) {
            max |= num;
        }
        dp(nums, 0, 0, max, true);
        return total;
    }
    public static void dp(int[] nums, int i, int or, int max, boolean isTake) {
        if(or == max && isTake) {
            total += 1;
        }
        if(i >= nums.length) {
            return;
        }
        int newOr = or | nums[i];
        dp(nums, i+1, newOr, max, true);
        dp(nums, i+1, or, max, false);
    }
}