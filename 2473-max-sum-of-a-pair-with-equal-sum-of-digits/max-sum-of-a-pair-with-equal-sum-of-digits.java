class Solution {
    public int maximumSum(int[] nums) {
        int [] dc = new int[nums.length];
        int len = nums.length;
        for(int i = 0; i<len; i++) {
            dc[i] = dsum(nums[i]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        for(int i = 0; i < len; i++) {
            if(map.containsKey(dc[i])) {
                ans = Math.max(ans, map.get(dc[i]) + nums[i]);
                map.put(dc[i], Math.max(map.get(dc[i]), nums[i]));
            } else {
                map.put(dc[i], nums[i]);
            }
        }
        return ans;
    }
    public int dsum(int num) {
        int sum = 0;
        while(num != 0) {
            sum += num %  10;
            num /= 10;
        }
        return sum;
    }
}