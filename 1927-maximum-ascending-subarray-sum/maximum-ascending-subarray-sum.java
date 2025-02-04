class Solution {
    public int maxAscendingSum(int[] nums) {
        int[] sums = new int[nums.length];
        for(int i = 0; i<nums.length; i++) {
            sums[i] = nums[i];
        }
        int max = sums[0];
        for(int i = 1; i<nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                sums[i] += sums[i-1];
    
            }
            max = Math.max(max, sums[i]);
        }
        return max;
    }
}