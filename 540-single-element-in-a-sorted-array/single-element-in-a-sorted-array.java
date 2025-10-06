class Solution {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }
        int left = 0;
        int right = len-1;
        while(left < right) {
            int mid = (left + right) /2;
            boolean isMidEven = (right - mid) % 2 == 0;
            if(nums[mid+1] == nums[mid]) {
                if(isMidEven) {
                    left = mid + 2;
                } else {
                    right = mid -1;
                }
            } else if(nums[mid -1] == nums[mid]) {
                if(isMidEven) {
                    right = mid -2;
                } else {
                    left = mid+1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[left];
    }
}