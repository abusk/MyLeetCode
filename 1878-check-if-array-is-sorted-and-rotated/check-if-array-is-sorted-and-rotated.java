class Solution {
    public boolean check(int[] nums) {
        if(nums.length <= 1) {
            return true;
        }
        int oneBreak = 0;
        if (nums[0] < nums[nums.length-1]) {
            oneBreak++;
        }
        for(int i = 1; i<nums.length; i++) {
            if(nums[i] < nums[i-1]) {
                oneBreak++;
            }
        }
        return oneBreak <= 1;
    }
}