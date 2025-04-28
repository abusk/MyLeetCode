class Solution {
    public long countSubarrays(int[] nums, long k) {
        long sum = 0;
        long c = 0;
        int i = 0;
        int j = 0;
        long ans = 0;
        while(j < nums.length) {
            sum += nums[j];
            c++;
            long pd = sum * c;
            while(pd >= k) {
                sum -= nums[i];
                c--;
                i++;
                pd = sum * c;
            }
            ans += j - i + 1;
            j++;
        }
        return ans;
    }
}