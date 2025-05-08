class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double left = Integer.MAX_VALUE;
        double right = Integer.MIN_VALUE;
        for(int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }
        while(right - left >= 1e-5) {
            double mid = (left + right) / 2;
            if(check(nums, mid, k)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
    public boolean check(int[] nums, double mid, int k) {
        double sum = 0;
        for(int i = 0; i<k; i++) {
            sum += nums[i] - mid;
        }
        if(sum >= 0) {
            return true;
        }
        double pSum = 0;
        double prevPSum = 0;
        for(int i = k; i<nums.length; i++) {
            sum += nums[i] - mid;
            pSum += nums[i-k] - mid;
            prevPSum = Math.min(prevPSum, pSum);
            if(sum - prevPSum >= 0) {
                return true;
            }
        }
        return false;
    }
}