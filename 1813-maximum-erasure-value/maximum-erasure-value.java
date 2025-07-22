class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int max = 0;
        int lmax = 0;
        Set<Integer> st = new HashSet<>();
        int i = 0;
        for(int j = 0; j < n; j++) {
            while(st.contains(nums[j])) {
                lmax -= nums[i];
                st.remove(nums[i++]);
            }
            lmax += nums[j];
            st.add(nums[j]);
            max = Math.max(max, lmax);
        }
        return max;
    }
}