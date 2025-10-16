class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] pSum = new int[len];
        pSum[0] = nums[0];
        int ans = 0;
        for(int i = 1; i<len; i++) {
            pSum[i] = pSum[i-1] + nums[i];
        }
        for(int i = 0; i<len; i++) {
            int ps = pSum[i];
            if(ps == k) {
                ans += 1;
            }
            for(int j = 0; j<i; j++) {
                int pl = pSum[j];
                if(ps - pl == k) {
                    ans += 1;
                }
            }
        }
        return ans;
    }
}