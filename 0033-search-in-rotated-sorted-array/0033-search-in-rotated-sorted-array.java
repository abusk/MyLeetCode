class Solution {
    private int findPivot(int[] nums) {
        int i = 0; 
        int j = nums.length-1;
        while(i <= j) {
            int mid = (i + j)/2;
            if(nums[mid] > nums[nums.length-1]) {
                i = mid+1;
            } else{
                j = mid-1;
            }
        }
        return i;
    }
    public int binary(int[] nums, int i, int j, int target) {
        while(i <=j){
            int mid = i + (j-i)/2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                i = mid+1;
            } else {
                j = mid -1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int piv = findPivot(nums);
        int ans = binary(nums, 0, piv-1, target);
        if(ans == -1) ans = binary(nums, piv, nums.length-1, target);
         return ans; 
    }   
}