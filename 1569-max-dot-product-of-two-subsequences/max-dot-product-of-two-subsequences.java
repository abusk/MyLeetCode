class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        Map<String, Integer> memo = new HashMap<>();
        int res = dp(nums1, nums2, 0, 0, memo);
        if(res == 0) {
            int m1 = Arrays.stream(nums1).max().getAsInt();
            int m11 = Arrays.stream(nums1).min().getAsInt();
            int m2 = Arrays.stream(nums2).max().getAsInt();
            int m21 = Arrays.stream(nums2).min().getAsInt();
            if(m1 < 0) {
                res = m1 * m21;
            } else if(m2 < 0) {
                res = m2 * m11;
            } else if (m1 < 0 && m2 < 0){
                res = m11 * m21;
            } else {
                res = m1 * m2;
            }
        }
        return res;
    }
    public int dp(int[] nums1, int[] nums2, int i, int j, Map<String, Integer> memo) {
        if(i >= nums1.length || j >= nums2.length) {
            return 0;
        }
        String key = i + ":" + j;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        int take = nums1[i] * nums2[j] + dp(nums1, nums2, i+1, j+1, memo);
        int notTake = Math.max(dp(nums1, nums2, i+1, j, memo), dp(nums1, nums2, i, j+1, memo));
        int res = Math.max(take, notTake);
        memo.put(key, res);
        return memo.get(key);
    }
}