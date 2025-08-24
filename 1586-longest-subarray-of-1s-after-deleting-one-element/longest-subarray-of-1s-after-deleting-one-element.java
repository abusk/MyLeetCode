class Solution {
    public int longestSubarray(int[] nums) {
        int nz = 0;
        int first = 0;
        int last = 0;
        int max = 0;
        while(last < nums.length) {
            if(nums[last] == 0) {
                nz++;
            }
            while(nz > 1) {
                if(nums[first] == 0) {
                    nz--;
                }
                first++;
            }
            max = Math.max(max, last - first);
            last++;
        }
        return max;
    }
}