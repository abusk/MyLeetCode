class Solution {
    public int searchInsert(int[] nums, int target) {
        return bs(nums, target);
    }
    public int bs(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;
        while(s <= e) {
            int mid = s + (e-s)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(mid == 0 && target <= nums[mid]) {
                return 0;
            }
            if(mid > 0 && target > nums[mid-1] && target <= nums[mid]) {
                return mid;
            }
            if(target > nums[mid]) {
                s = mid+1;
            } else {
                e = mid-1;
            }
        }
        return target > nums[e] ? e+1 : 0;
    }
}