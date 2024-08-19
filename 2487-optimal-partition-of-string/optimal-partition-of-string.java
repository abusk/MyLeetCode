class Solution {
    public int partitionString(String s) {
        boolean[] vis = new boolean[26];
        int ans = 1;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(vis[ch - 'a']) {
                ans++;
                Arrays.fill(vis, false);
            }
            vis[ch -'a'] = true;
        }
        return ans;
    }
}