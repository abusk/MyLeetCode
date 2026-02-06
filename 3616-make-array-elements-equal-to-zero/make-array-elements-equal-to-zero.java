class Solution {
    public int countValidSelections(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for(int i = 0; i<len; i++) {
            if(nums[i] == 0) {
                int ls = 0;
                for(int l = 0; l <i; l++) {
                    ls += nums[l];
                }
                int rs = 0;;
                for(int r = i+1; r < len; r++) {
                    rs += nums[r];
                }
                if(ls == rs) {
                    ans += 2;
                } else if(Math.abs(ls -rs) == 1) {
                    ans += 1;
                }
            }
        }
        return ans;
    }
}