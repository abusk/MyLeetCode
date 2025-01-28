class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int last = nums[nums.length -1];
        int[] dp = new int[last +1];
        for(int i = 0; i<nums.length; i++) {
            dp[nums[i]] = 1;
        }
        for(int i = 0; i<nums.length; i++) {
            int val = nums[i];
            if(!isPerfectSquare(val)) {
                continue;
            }
            int sqrt = (int)Math.sqrt(val);
            dp[val] = dp[sqrt] + 1; 
        }
        int ans = 0;
        for(int i = 0; i <=last; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans < 2 ? -1 : ans;
    }
    public boolean isPerfectSquare(int num) {
        int sqrt = (int)Math.sqrt(num);
        return num == sqrt * sqrt;
    }
}