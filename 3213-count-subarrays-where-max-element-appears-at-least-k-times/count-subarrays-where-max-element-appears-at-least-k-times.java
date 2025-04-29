class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            max = Math.max(max, num);
        }
        int i = 0;
        int j = 0;
        int c = 0;
        long ans =0;
        while(j < nums.length) {
            if(nums[j] == max) {
                c++;
                while(c == k) {
                    ans += nums.length -j;
                    if(nums[i] == max) {
                        c--;
                    }
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
}