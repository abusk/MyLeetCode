class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int[] state = new int[nums.length];
        int[] sLen = new int[nums.length];
        int max = 1;
        for(int i = 0; i< nums.length; i++) {
            sLen[i] = 1;
        }
        for(int i = 1; i<nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                state[i] = 1;
            } else if(nums[i] < nums[i-1]) {
                state[i] = -1;
            } else {
                state[i] = 0;
            }
        }
        for(int i = 1; i<nums.length; i++) {
            if(state[i] != 0 && state[i] == state[i-1]) {
                sLen[i] = sLen[i-1] + 1;
            } 
        }
        for(int i = 0; i<nums.length; i++) {
            max= Math.max(max, sLen[i]);
        }
        for(int i= 0; i<nums.length; i++) {
            if(state[i] != 0) {
                max = max+1;
                break;
            }
        }
        return max;
    }
}