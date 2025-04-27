class Solution {
    public int countSubarrays(int[] nums) {
        int i = 0;
        int j = 2;
        int ans = 0;
        while(j < nums.length) {
            int sum = nums[i] + nums[j];
            int trd = nums[(i+j)/2];
            int tsum = 2 * sum;
            if((tsum == trd )) {
                ans++;
            }
            j++;
            i++;
        }
        return ans;
    }
}