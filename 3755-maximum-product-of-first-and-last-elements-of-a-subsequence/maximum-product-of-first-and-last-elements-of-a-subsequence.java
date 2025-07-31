class Solution {
    public long maximumProduct(int[] nums, int m) {
        long max= Long.MIN_VALUE;
        int l = nums.length;
        int [] maxS = new int[nums.length];
        maxS[l-1] = nums[l-1];
        for(int i = l-2; i>=0; i--) {
            if(maxS[i+1] > nums[i]) {
                maxS[i] = maxS[i+1];
            } else {
                maxS[i] = nums[i];
            }
        }

        int [] minS = new int[nums.length];
        minS[l-1] = nums[l-1];
        for(int i = l-2; i>=0; i--) {
            if(minS[i+1] < nums[i]) {
                minS[i] = minS[i+1];
            } else {
                minS[i] = nums[i];
            }
        }

        for(int i = 0; i<l; i++) {
            long n1 = nums[i];
            if(i+m-1 < l) {
                long n21 = maxS[i + m-1];
                long n22 = minS[i+m -1];
                max = Math.max(max, Math.max(n1 * n21, n1 * n22));
            }
        }
        return max;
    }
}