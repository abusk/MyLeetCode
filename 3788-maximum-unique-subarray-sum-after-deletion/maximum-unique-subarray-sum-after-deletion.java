class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> st = new HashSet<>();
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            if(num <= 0) {
                max = Math.max(max, num);
            }
            if(!st.contains(num) && num > 0) {
                st.add(num);
                ans += num;
            }
        }
        if(ans == 0) {
            return max;
        }
        return ans;
    }
}