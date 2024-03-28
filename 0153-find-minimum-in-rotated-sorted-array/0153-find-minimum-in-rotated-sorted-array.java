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
    public int findMin(int[] nums) {
        int piv = findPivot(nums);
        return nums[piv];
    }
}