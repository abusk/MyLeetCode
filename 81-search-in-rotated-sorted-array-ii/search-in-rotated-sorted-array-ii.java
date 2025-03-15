class Solution {
    public static boolean search(int[] nums, int target) {
        int p = findPivot(nums);

        if(p != -1) {
            return findBS(nums, 0, p, target) || findBS(nums, p, nums.length-1, target);
        }
        return findBS(nums,0, nums.length-1, target);
    }

    public static int findPivot(int[] nums) {
        int s = 0;
        int l = nums.length-1;
        while (s <= l) {
            while (s < l && nums[s] == nums[s + 1])
                ++s;
            while (s < l && nums[l] == nums[l - 1])
                --l;

            int mid = (s + l) /2;
            if(mid > 0 && (nums[mid] < nums[mid-1])) {
                return mid;
            }
            if(nums[mid] == nums[s]){
                s++;
                continue;
            }
            if(nums[mid] > nums[0]) {
                s = mid +1;
            } else {
                l = mid -1;
            }
        }
        return -1;
    }
    public static boolean findBS(int[] nums, int s, int l, int target) {
        while (s <= l) {
            int mid = (s+l)/2;
            if(nums[mid] == target) {
                return true;
            }
            if(nums[mid] < target) {
                s = mid+1;
            } else {
                l = mid -1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        System.out.println(search(nums, 0));
    }
}