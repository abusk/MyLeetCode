class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int state = 0;
        int max = 1;
        int lmax = 1;
        for(int i = 1; i<nums.length; i++) {
            if(nums[i] > nums[i-1] && state == 0) {
                state = 1;
                lmax = 2;  
            } else if(nums[i] < nums[i-1] && state == 0) {
                state = -1;
                lmax = 2; 
            } else if((nums[i] > nums[i-1] && state == 1) || (nums[i] < nums[i-1] && state == -1)){
                lmax += 1; 
            } else if(nums[i] > nums[i-1] && state == -1){
                state = 1;
                lmax = 2; 
            } else if(nums[i] < nums[i-1] && state == 1){
                state = -1;
                lmax = 2; 
            } else {
                state = 0;
                lmax = 1;
            }
            max = Math.max(max, lmax);
        }
        return max;
    }
}