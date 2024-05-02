class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> neg = new HashSet<>();
        for (int num : nums) {
            if (num < 0)
                neg.add(num);
        }
        
        int ans = -1;
        
        for (int num : nums) {
            if (num > ans && neg.contains(-num))
                ans = num;
        }
        
        return ans;
    }
}