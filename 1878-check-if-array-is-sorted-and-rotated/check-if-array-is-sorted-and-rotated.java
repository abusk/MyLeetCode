class Solution {
    public boolean check(int[] nums) {
        boolean oneBreak = false;
        if (nums[0] < nums[nums.length-1]) {
            oneBreak = true;
        }
        for(int i = 1; i<nums.length; i++) {
            if(nums[i] < nums[i-1] && !oneBreak) {
                oneBreak = true;
            } else if(nums[i] < nums[i-1] && oneBreak) {
                return false;
            }else if(nums[i] >= nums[i-1]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}