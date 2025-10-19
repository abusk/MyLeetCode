class Solution {
    public int longestBalanced(int[] nums) {
        int ans = 0;
        int l = nums.length;
        for (int start = 0; start < l - 1; start++) {
            Set<Integer> odd = new HashSet<>();
            Set<Integer> even = new HashSet<>();
            if (nums[start] % 2 == 0) {
                even.add(nums[start]);
            } else {
                odd.add(nums[start]);
            }
            for (int end = start + 1; end < l; end++) {
                if (nums[end] % 2 == 0) {
                    even.add(nums[end]);
                } else {
                    odd.add(nums[end]);
                }
                if(odd.size()==even.size())
                {
                    ans=Math.max(ans,end-start+1);
                }
            }
        }
        return ans;
    }
}