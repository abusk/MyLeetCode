class Solution {
    public static int longestNiceSubarray(int[] nums) {
        int ans = 1;
        int s = 0;
        int e = 1;
        int cur = nums[0];
        while (e < nums.length) {
            while((cur & nums[e]) != 0) {
                cur = cur ^ nums[s];
                s++;
            }
            ans = Math.max(ans, e - s+1);
            cur = cur | nums[e];
            e++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] nums = {135745088,609245787,16,2048,2097152};
        System.out.println(longestNiceSubarray(nums));
    }
}