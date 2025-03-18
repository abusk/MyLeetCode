class Solution {
    public static int longestNiceSubarray(int[] nums) {
        int ans = 1;
        int s = 0;
        int e = 1;
        while (e < nums.length) {
            while(s < e && !isValid(nums, s, e)) {
                s++;
            }
            ans = Math.max(ans, e - s+1);
            e++;
            
        }
        return ans;
    }

    public static boolean isValid(int[] nums, int s, int e) {
        int nm = nums[e];
        for(int i = s; i<e; i++) {
            if((nm & nums[i]) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int [] nums = {135745088,609245787,16,2048,2097152};
        System.out.println(longestNiceSubarray(nums));
    }
}