class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int l = queries.length;
        int s = 0;
        if(!canTransform(nums, queries, l)) {
            return -1;
        }
        while (s <= l) {
            int mid = (s+l) /2;
            if(canTransform(nums, queries, mid)) {
                l = mid -1;
            } else {
                s = mid +1;
            }
        }
        return s;
    }
    public boolean canTransform(int[] nums, int[][] queries, int k) {
        int len = nums.length;
        int[] diff = new int[len+1];
        for(int i = 0; i<k; i++) {
            int[] q = queries[i];
            int start = q[0];
            int end = q[1];
            int val= q[2];
            diff[start] += val;
            diff[end+1] -= val;
        }
        int sum = 0;
        for(int i = 0; i<len; i++) {
            sum += diff[i];
            if(sum < nums[i]) {
                return false;
            }
        }
        return true;
    }
}