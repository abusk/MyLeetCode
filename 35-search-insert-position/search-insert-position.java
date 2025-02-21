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
            if(target > nums[mid]) {
                s = mid+1;
            } else {
                e = mid-1;
            }
        }
        return s;
    }
}