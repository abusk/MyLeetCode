class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int subc = 0; 
        int j = 0;
        while(j < nums.length) {
            if(nums[j] == 0) {
                subc++;
            } else {
               subc = 0;
            }
            ans += subc;
            j++;
        }
        return ans;
    }
}