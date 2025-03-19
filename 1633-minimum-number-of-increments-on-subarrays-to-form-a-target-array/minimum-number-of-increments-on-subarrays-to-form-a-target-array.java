class Solution {
    public int minNumberOperations(int[] target) {

        int prev = 0;
        int ans = 0;
        for(int i = 0; i<target.length; i++) {
            int cur = target[i];
            if(cur >= prev) {
                ans += cur-prev;
            }
            prev = cur;
        }
        return ans;
    }
}