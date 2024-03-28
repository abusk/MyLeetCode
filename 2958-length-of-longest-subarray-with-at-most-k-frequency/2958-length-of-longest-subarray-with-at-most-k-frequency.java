class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int mx = 0;
        while(j < nums.length) {
            while(map.getOrDefault(nums[j], 0) >= k) {
                int vv = map.get(nums[i]);
                map.put(nums[i], vv-1);
                i++;
            }
            int v = map.getOrDefault(nums[j], 0);
            map.put(nums[j], v+1);
            mx = Math.max(mx, j-i+1);
            j++;
        }
        return mx;
    }
}