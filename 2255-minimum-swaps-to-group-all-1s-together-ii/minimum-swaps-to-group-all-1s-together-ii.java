class Solution {
    public int minSwaps(int[] nums) {
        int to = 0;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] == 1) {
                to++;
            }
        }
        int maxZ = 0;
        for(int i = 0; i< to; i++) {
            if(nums[i] == 0) {
                maxZ++;
            }
        }

        int start = 1;
        int end = to;
        int minS = maxZ;
        for(; start<nums.length; start++) {
            if(nums[start-1] == 0) {
                maxZ--;
            }
            end = end % nums.length;
            if(nums[end] == 0) {
                maxZ++;
            }
            end++;
            minS = Math.min(minS, maxZ);
        }
        return minS;
    }
}