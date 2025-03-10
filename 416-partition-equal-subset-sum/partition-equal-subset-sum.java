class Solution {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for(int i = 0; i<len; i++) {
            sum += nums[i];
        }
        if(sum % 2 != 0) {
            return false;
        }
        int hsum = sum /2;
        boolean dp[][] = new boolean[len+1][hsum +1];
        dp[0][0] = true;
        for(int i = 1; i <= len; i++) {
            for (int j = 1; j<= hsum; j++) {
                if(nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[len][hsum];
    }

    public static void main(String[] args) {
        int [] nums = {6,8,6};
        System.out.println(canPartition(nums));
    }

}